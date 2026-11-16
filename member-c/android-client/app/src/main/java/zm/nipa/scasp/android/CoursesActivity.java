package zm.nipa.scasp.android;

public class CoursesActivity extends BaseListActivity {
    @Override protected String screenTitle() { return "Course catalogue"; }
    @Override protected String cacheKey() { return "courses"; }
    @Override protected Loader loader() { return api::courses; }
}
