package tests.actions.verify;

import core.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Verify that alert appeared.
 */
public class VerifyAlertBodyMessage extends BaseTest {

    /**
     * Message for alert log.
     */
    private static final String ALERT_MESSAGE = "Check that alert appeared";

    /**
     * Error message for alert.
     */
    private static final String ALERT_ERROR_MESSAGE = "Alert is not appeared";

    /**
     * Message for check alert body.
     */
    private static final String ALERT_CHECK_BODY_MESSAGE = "Check that alert text is '%s'";

    /**
     * Alert body message.
     */
    private String message;

    public VerifyAlertBodyMessage(String message) {
        this.message = message;
    }

    @Override
    public void runTest() {
        Logger logger = getLogger();
        logger.info(ALERT_MESSAGE);

        try {
            Alert alert = Browser.getInstance().switchTo().alert();
            assertTrue(ALERT_ERROR_MESSAGE, alert != null);

            logger.info(String.format(ALERT_CHECK_BODY_MESSAGE, message));
            String alertText = alert.getText();
            assertTrue(message.equals(alertText));

            alert.accept();
        } catch (NoAlertPresentException e) {
            // Alert is not appeared.
            e.printStackTrace();
        }
    }
}
