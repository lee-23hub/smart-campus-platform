package zm.nipa.scasp.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Shared behaviour for list screens: load on a background thread, cache result,
 * fall back to cache when offline, show an empty state, survive rotation.
 */
public abstract class BaseListActivity extends Activity {
    protected interface Loader { List<String> load() throws PlatformApi.OfflineException; }

    private final ExecutorService io = Executors.newSingleThreadExecutor();
    private final Handler ui = new Handler(Looper.getMainLooper());
    protected ListView list;
    protected TextView status;
    protected final PlatformApi api = new PlatformApi();
    private ArrayList<String> shown = new ArrayList<>();

    protected abstract String screenTitle();
    protected abstract String cacheKey();
    protected abstract Loader loader();

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list);
        ((TextView) findViewById(R.id.title)).setText(screenTitle());
        list = findViewById(R.id.list);
        status = findViewById(R.id.status);
        if (b != null && b.getStringArrayList("shown") != null) {      // configuration change
            shown = b.getStringArrayList("shown");
            render(shown, "");
        }
        refresh();
    }

    protected void refresh() {
        status.setText("Loading...");
        io.execute(() -> {
            List<String> result; String note = "";
            try {
                result = loader().load();
                new Prefs(this).saveList(cacheKey(), result);
            } catch (PlatformApi.OfflineException e) {
                result = new Prefs(this).loadList(cacheKey());
                note = result.isEmpty() ? "Offline and nothing saved yet." : "Offline - showing saved data.";
            }
            final List<String> fr = result; final String fn = note;
            ui.post(() -> render(fr, fn));
        });
    }

    private void render(List<String> items, String note) {
        shown = new ArrayList<>(items);
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shown));
        status.setText(note);
        findViewById(R.id.empty).setVisibility(shown.isEmpty() ? android.view.View.VISIBLE : android.view.View.GONE);
    }

    @Override protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        out.putStringArrayList("shown", shown);
    }

    @Override protected void onDestroy() { super.onDestroy(); io.shutdownNow(); }
}
