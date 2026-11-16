package zm.nipa.scasp.android;

/** Immutable campus service location (Stage 10, items 9). Coordinates are demo values near Lusaka. */
public final class CampusService {
    public final String name;
    public final double latitude;
    public final double longitude;

    public CampusService(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /** geo: URI used by the implicit map intent. */
    public String toGeoUri() {
        return "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude
                + "(" + android.net.Uri.encode(name) + ")";
    }

    @Override public String toString() { return name; }
}
