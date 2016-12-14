package tests.actions.verify;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * "Check that page with header equal to the title you clicked is displayed.
 */
public class VerifySearchItemHeader extends BaseTest {

    /**
     * Header text.
     */
    private String headerText;

    /**
     * Message for search item.
     */
    private static final String SEARCH_ITEM_MESSAGE = "Verify that text header '%s' is equal equal to the title '%s'";

    /**
     * Error message for search item.
     */
    private static final String SEARCH_ITEM_ERROR_MESSAGE = "Text header '%s' is not equal equal to the title '%s'";

    /**
     * Id for book header.
     */
    private static final String ID = "sr.result.book.header";

    public VerifySearchItemHeader(String headerText) {
        this.headerText = headerText;
    }

    @Override
    public void runTest() {
        checkElement(ID);
        LinkModel link = Repository.getInstance().getLinkById(ID);

        WebElement header = Browser.getInstance().findElement(By.xpath(link.getXpath()));
        getLogger().info(String.format(SEARCH_ITEM_MESSAGE, header.getText(), headerText));
        assertTrue(SEARCH_ITEM_ERROR_MESSAGE, header.getText().equals(headerText));
    }
}
