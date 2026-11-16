package zm.nipa.scasp.android;

public class RequestsActivity extends BaseListActivity {
    @Override protected String screenTitle() { return "Service requests"; }
    @Override protected String cacheKey() { return "reqs"; }
    @Override protected Loader loader() { return api::requests; }
}
