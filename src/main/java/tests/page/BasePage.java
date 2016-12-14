package tests.page;

import tests.BaseTest;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertFalse;

/**
 * Abstract class for base page.
 */
public abstract class BasePage extends BaseTest{

    /**
     * Template for open page.
     */
    private static final String OPEN_PAGE_TEMPLATE = "Open page with name - %s";

    /**
     * Error message for page name.
     */
    private static final String PAGE_NAME_ERROR_MESSAGE = "Page name is null";

    /**
     * Page name.
     */
    private String pageName = null;

    /**
     * Sets page name.
     * @param pageName String for page name.
     */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * Gets page name.
     * @return String for page name.
     */
    public String getPageName() {
        return this.pageName;
    }

    @Test
    public final void runTest() {
        assertFalse(PAGE_NAME_ERROR_MESSAGE, getPageName() == null);

        Logger logger = getLogger();
        logger.info(String.format(OPEN_PAGE_TEMPLATE, getPageName()));
        doTest();
    }

    /**
     * Do test steps.
     */
    public abstract void doTest();
}
