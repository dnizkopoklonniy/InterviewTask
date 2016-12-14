package tests.actions.verify.url;

import core.Browser;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Verifies students url.
 */
public class VerifyStudentsUrl extends BaseTest {

    /**
     * Url for compare.
     */
    private String compareUrl = "http://eu.wiley.com/WileyCDA/Section/id-404702.html";

    /**
     * Url error message.
     */
    private static final String URL_ERROR_MESSAGE = "Url of page '%s' do not match with compare url '%s'";

    /**
     * Message for log.
     */
    private static final String LOG_MESSAGE = "Verify 'Students' url '%s'";

    @Override
    public void runTest() {
        String currentUrl = Browser.getInstance().getCurrentUrl();

        getLogger().info(String.format(LOG_MESSAGE, currentUrl));
        assertTrue(String.format(URL_ERROR_MESSAGE, currentUrl, compareUrl),
                currentUrl.equals(compareUrl));
    }
}
