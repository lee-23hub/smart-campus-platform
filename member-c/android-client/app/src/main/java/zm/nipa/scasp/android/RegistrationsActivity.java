package zm.nipa.scasp.android;

public class RegistrationsActivity extends BaseListActivity {
    @Override protected String screenTitle() { return "My registrations"; }
    @Override protected String cacheKey() { return "regs"; }
    @Override protected Loader loader() { return api::registrations; }
}
