package tests.actions.verify.url;

import core.Browser;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Verifies institutions url.
 */
public class VerifyInstitutionsUrl extends BaseTest {

    /**
     * Url for compare.
     */
    private String compareUrl = "https://edservices.wiley.com/";

    /**
     * Url error message.
     */
    private static final String URL_ERROR_MESSAGE = "Url of page '%s' do not match with compare url '%s'";

    /**
     * Message for log.
     */
    private static final String LOG_MESSAGE = "Verify 'Institutions' url '%s'";

    @Override
    public void runTest() {
        String currentUrl = Browser.getInstance().getCurrentUrl();

        getLogger().info(String.format(LOG_MESSAGE, currentUrl));
        assertTrue(String.format(URL_ERROR_MESSAGE, currentUrl, compareUrl),
                currentUrl.equals(compareUrl));
    }
}
