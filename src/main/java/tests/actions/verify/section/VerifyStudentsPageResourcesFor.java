package tests.actions.verify.section;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for verify students page resources for menu.
 */
public class VerifyStudentsPageResourcesFor extends BaseVerifySection {

    /**
     * Page section name.
     */
    private static final String PAGE_SECTION = "Students page resources for menu";

    public VerifyStudentsPageResourcesFor() {

        List<String> ids = new ArrayList<String>();

        ids.add("st.authors");
        ids.add("st.librarians");
        ids.add("st.booksellers");
        ids.add("st.instructors");
        ids.add("st.students");

        // Government Employees does not exist. This is bug or not.
        //ids.add("st.government.employees");

        ids.add("st.societies");
        ids.add("st.corporate.partners");

        setSectionName(PAGE_SECTION);
        setIds(ids);
    }
}
