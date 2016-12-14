package tests.actions;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Class for enter search text in search field.
 */
public class EnterSearchText extends BaseTest {

    /**
     * Id for search input field.
     */
    private static final String ID = "hp.search.field";

    /**
     * Search text.
     */
    private static final String SEARCH_TEXT = "for dummies";

    /**
     * Message for enter search text.
     */
    private static final String SEARCH_TEXT_MESSAGE = "Enter search text '%s'";

    @Override
    public void runTest() {
        getLogger().info(String.format(SEARCH_TEXT_MESSAGE, SEARCH_TEXT));

        checkElement(ID);
        LinkModel link = Repository.getInstance().getLinkById(ID);

        WebElement wileyInputField = Browser.getInstance().findElement(By.xpath(link.getXpath()));
        wileyInputField.sendKeys(SEARCH_TEXT);
    }
}
