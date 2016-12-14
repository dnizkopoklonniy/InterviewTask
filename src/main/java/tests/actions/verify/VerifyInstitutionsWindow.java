package tests.actions.verify;

import core.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;
import tests.actions.verify.url.VerifyInstitutionsUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Check that 'Institutions' url is opened in new window (or tab).
 */
public class VerifyInstitutionsWindow extends BaseTest {

    /**
     * Old tab index.
     */
    private static final int OLD_TAB_INDEX = 0;

    /**
     * New tab index.
     */
    private static final int NEW_TAB_INDEX = 1;

    /**
     * Message for switch tab.
     */
    private static final String SWITCH_TAB_MESSAGE = "Switch to new tab";

    /**
     * Message for close tab.
     */
    private static final String CLOSE_TAB_MESSAGE = "Close tab and get back";

    @Override
    public void runTest() {
        WebDriver driver = Browser.getInstance();
        Logger logger = getLogger();

        // Gets window handlers as list.
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        logger.info(SWITCH_TAB_MESSAGE);
        driver.switchTo().window(browserTabs.get(NEW_TAB_INDEX));

        new VerifyInstitutionsUrl().runTest();

        logger.info(CLOSE_TAB_MESSAGE);
        driver.close();
        driver.switchTo().window(browserTabs.get(OLD_TAB_INDEX));
    }
}
