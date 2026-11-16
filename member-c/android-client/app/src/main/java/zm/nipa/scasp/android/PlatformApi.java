package zm.nipa.scasp.android;

import java.util.Arrays;
import java.util.List;

/**
 * Boundary to the SCASP server. USE_MOCK=true returns fictional data so the app
 * runs without a server (allowed by the Stage 10 brief). Swap in HttpURLConnection
 * calls to BuildConfig.BASE_URL + "/api/..." once the web module exposes JSON endpoints.
 * NEVER call these methods on the main thread.
 */
public class PlatformApi {
    public boolean simulateOffline = false;

    public static class OfflineException extends Exception {
        public OfflineException() { super("No connection"); }
    }

    private void checkOnline() throws OfflineException {
        if (simulateOffline) throw new OfflineException();
    }

    public boolean login(String userId, String password) throws OfflineException {
        checkOnline();
        return userId != null && !userId.trim().isEmpty() && password != null && password.length() >= 4;
    }

    public List<String> courses() throws OfflineException {
        checkOnline();
        return Arrays.asList("BOCS3100 Advanced Java (28/30)", "BOCS3090 Advanced Databases (30/30 FULL)",
                "BOCS3080 Human-Computer Interaction (12/40)");
    }

    public List<String> registrations() throws OfflineException {
        checkOnline();
        return Arrays.asList("BOCS3100 - REGISTERED", "BOCS3090 - WAITLISTED (position 2)");
    }

    public List<String> requests() throws OfflineException {
        checkOnline();
        return Arrays.asList("#1 TRANSCRIPT - OPEN", "#2 CLEARANCE - ASSIGNED");
    }

    public List<CampusService> campusServices() throws OfflineException {
        checkOnline();
        return Arrays.asList(
                new CampusService("Registry Office", -15.4167, 28.2833),
                new CampusService("Library", -15.4175, 28.2845),
                new CampusService("Finance Office", -15.4160, 28.2850));
    }
}
