package tests.actions.verify;
import core.Browser;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Test for check students header.
 */
public class VerifyStudentsHeader extends BaseTest {

    /**
     * Id for students header for data store.
     */
    private static final String ID = "st.header";

    /**
     * Message for check 'Students' header.
     */
    private static final String CHECK_HEADER_MESSAGE = "Check that 'Students' header is displayed";

    /**
     * Error message for 'Students' header.
     */
    private static final String CHECK_HEADER_ERROR_MESSAGE = "'Students' header is not displayed";

    @Override
    public void runTest() {
        checkElement(ID);

        LinkModel linkModel = Repository.getInstance().getLinkById(ID);
        WebElement header = Browser.getInstance().findElement(By.xpath(linkModel.getXpath()));

        getLogger().info(CHECK_HEADER_MESSAGE);
        assertTrue(header.getText().equals(linkModel.getText()), CHECK_HEADER_ERROR_MESSAGE);
    }
}
