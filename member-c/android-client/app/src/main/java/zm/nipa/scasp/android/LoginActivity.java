package zm.nipa.scasp.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends Activity {
    private final ExecutorService io = Executors.newSingleThreadExecutor();
    private final Handler ui = new Handler(Looper.getMainLooper());
    private TextView status;
    private EditText userId;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);
        userId = findViewById(R.id.userId);
        EditText password = findViewById(R.id.password);
        status = findViewById(R.id.status);
        Button btn = findViewById(R.id.loginBtn);
        btn.setOnClickListener(v -> {
            final String u = userId.getText().toString();
            final String p = password.getText().toString();
            if (u.trim().isEmpty() || p.isEmpty()) { status.setText("Enter your user ID and password."); return; }
            btn.setEnabled(false);
            status.setText("Signing in...");
            io.execute(() -> {                         // background thread: main thread never blocked
                String msg; boolean ok = false;
                try { ok = new PlatformApi().login(u, p); msg = ok ? "" : "Wrong ID or password."; }
                catch (PlatformApi.OfflineException e) { msg = "You are offline. Try again."; }
                final boolean fok = ok; final String fmsg = msg;
                ui.post(() -> {
                    btn.setEnabled(true);
                    status.setText(fmsg);
                    if (fok) {
                        new Prefs(this).saveUser(u.trim());
                        startActivity(new Intent(this, HomeActivity.class)); // explicit intent
                        finish();
                    }
                });
            });
        });
    }

    @Override protected void onSaveInstanceState(Bundle out) {   // preserve UI state on rotation
        super.onSaveInstanceState(out);
        out.putString("userId", userId.getText().toString());
    }

    @Override protected void onRestoreInstanceState(Bundle in) {
        super.onRestoreInstanceState(in);
        userId.setText(in.getString("userId", ""));
    }

    @Override protected void onDestroy() { super.onDestroy(); io.shutdownNow(); }
}
