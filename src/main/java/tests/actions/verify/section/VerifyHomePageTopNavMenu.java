package tests.actions.verify.section;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for verify 'home page top navigation menu'.
 */
public class VerifyHomePageTopNavMenu extends BaseVerifySection {

    /**
     * Page section name.
     */
    private static final String PAGE_SECTION = "Home page top navigation menu";

    public VerifyHomePageTopNavMenu() {

        List<String> ids = new ArrayList<String>();

        ids.add("hp.home");
        ids.add("hp.subjects");
        ids.add("hp.about.wiley");
        ids.add("hp.contact.us");
        ids.add("hp.help");

        setSectionName(PAGE_SECTION);
        setIds(ids);
    }
}
