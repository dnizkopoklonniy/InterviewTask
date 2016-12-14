package tests.actions.verify.section;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for verify home page resources sub-header.
 */
public class VerifyHomePageResourcesSubHeader extends BaseVerifySection{

    /**
     * Page section name.
     */
    private static final String PAGE_SECTION = "Home page resources sub-header";

    public VerifyHomePageResourcesSubHeader() {
        List<String> ids = new ArrayList<String>();

        ids.add("hp.students");
        ids.add("hp.authors");
        ids.add("hp.instructors");
        ids.add("hp.librarians");
        ids.add("hp.societies");

        ids.add("hp.conferences");
        ids.add("hp.booksellers");
        ids.add("hp.corporations");
        ids.add("hp.institutions");

        setSectionName(PAGE_SECTION);
        setIds(ids);
    }
}
