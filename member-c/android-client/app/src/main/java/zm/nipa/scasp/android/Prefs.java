package zm.nipa.scasp.android;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;

/**
 * Small local cache using SharedPreferences (Stage 10, item 7).
 * Offline behaviour: show the last cached list with an "offline - showing saved data" notice;
 * refresh happens every time a screen opens and the network call succeeds.
 */
public final class Prefs {
    private static final String FILE = "scasp_prefs";
    private static final String SEP = "\u001F";
    private final SharedPreferences sp;

    public Prefs(Context ctx) { sp = ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE); }

    public void saveList(String key, List<String> items) {
        sp.edit().putString(key, join(items)).apply();
    }

    public List<String> loadList(String key) { return split(sp.getString(key, "")); }

    public void saveUser(String id) { sp.edit().putString("user", id).apply(); }
    public String user() { return sp.getString("user", null); }
    public void clearUser() { sp.edit().remove("user").apply(); }

    static String join(List<String> items) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < items.size(); i++) { if (i > 0) b.append(SEP); b.append(items.get(i)); }
        return b.toString();
    }

    static List<String> split(String s) {
        List<String> out = new ArrayList<>();
        if (s == null || s.isEmpty()) return out;
        for (String p : s.split(SEP, -1)) out.add(p);
        return out;
    }
}
