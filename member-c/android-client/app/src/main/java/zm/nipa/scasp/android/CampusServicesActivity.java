package zm.nipa.scasp.android;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Lists campus services; tap one to open a map (implicit intent). "Show my position" asks permission only on tap. */
public class CampusServicesActivity extends Activity {
    private static final int REQ_LOCATION = 42;
    private final ExecutorService io = Executors.newSingleThreadExecutor();
    private final Handler ui = new Handler(Looper.getMainLooper());
    private final List<CampusService> services = new ArrayList<>();
    private TextView status;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list);
        ((TextView) findViewById(R.id.title)).setText("Campus services");
        status = findViewById(R.id.status);
        Button action = findViewById(R.id.actionBtn);
        action.setVisibility(android.view.View.VISIBLE);
        action.setText("Show my position");
        action.setOnClickListener(v -> onShowPositionClicked());
        ListView list = findViewById(R.id.list);
        list.setOnItemClickListener((p, v, pos, id) -> openMap(services.get(pos)));
        io.execute(() -> {
            List<CampusService> data = new ArrayList<>();
            try { data = new PlatformApi().campusServices(); } catch (PlatformApi.OfflineException ignored) { }
            final List<CampusService> fd = data;
            ui.post(() -> {
                services.clear(); services.addAll(fd);
                list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, services));
                findViewById(R.id.empty).setVisibility(services.isEmpty() ? android.view.View.VISIBLE : android.view.View.GONE);
            });
        });
    }

    private void openMap(CampusService s) {
        Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse(s.toGeoUri()));   // implicit intent
        if (map.resolveActivity(getPackageManager()) != null) startActivity(map);
        else Toast.makeText(this, "No map app installed.", Toast.LENGTH_LONG).show();
    }

    private void onShowPositionClicked() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            showPosition();
        } else {
            status.setText("We need location access only to show where you are on campus.");
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_LOCATION);
        }
    }

    @Override public void onRequestPermissionsResult(int code, String[] perms, int[] results) {
        super.onRequestPermissionsResult(code, perms, results);
        if (code != REQ_LOCATION) return;
        if (results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED) showPosition();
        else status.setText("Location permission denied. You can still open any service on the map.");
    }

    @SuppressWarnings("MissingPermission")
    private void showPosition() {
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc == null) loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (loc == null) { status.setText("Position unavailable. Turn on location and try again."); return; }
        status.setText(String.format(java.util.Locale.US, "You are at %.5f, %.5f", loc.getLatitude(), loc.getLongitude()));
    }

    @Override protected void onDestroy() { super.onDestroy(); io.shutdownNow(); }
}
