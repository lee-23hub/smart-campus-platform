package zm.nipa.scasp.android;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlatformApiTest {
    @Test public void loginRejectsBlankAndShortPassword() throws Exception {
        PlatformApi api = new PlatformApi();
        assertFalse(api.login("", "abcd"));
        assertFalse(api.login("u1", "abc"));
        assertTrue(api.login("u1", "abcd"));
    }
    @Test(expected = PlatformApi.OfflineException.class)
    public void offlineThrows() throws Exception {
        PlatformApi api = new PlatformApi(); api.simulateOffline = true; api.courses();
    }
    @Test public void atLeastThreeCampusServices() throws Exception {
        assertTrue(new PlatformApi().campusServices().size() >= 3);
    }
}
