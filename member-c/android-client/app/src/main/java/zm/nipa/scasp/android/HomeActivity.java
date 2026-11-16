package zm.nipa.scasp.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends Activity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_home);
        go(R.id.toCourses, CoursesActivity.class);
        go(R.id.toRegs, RegistrationsActivity.class);
        go(R.id.toRequests, RequestsActivity.class);
        go(R.id.toServices, CampusServicesActivity.class);
    }
    private void go(int id, Class<?> target) {
        findViewById(id).setOnClickListener(v -> startActivity(new Intent(this, target)));
    }
}
