package tests.actions.verify;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Class for check result search(must be appeared).
 */
public class VerifySearchResultAppeared extends BaseTest {

    /**
     * Id for block (list books) for data store.
     */
    private static final String ID_BLOCK = "sr.result.block";

    /**
     * Id for block (list books) item for data store.
     */
    private static final String ID_ITEM = "sr.result.item";

    /**
     * Id for block (list book) item title for data store.
     */
    private static final String ID_ITEM_TITLE = "sr.result.item.title";

    /**
     * Error message for link.
     */
    private static final String LINK_ERROR_MESSAGE = "Link with id '%s' not found in data store";

    /**
     * Message for random item click on title.
     */
    private static final String ITEM_TITLE_CLICK_MESSAGE = "Click on item link (link with book title) with number %s";

    /**
     * Message for check header.
     */
    private static final String CHECK_HEADER_MESSAGE = "Check that page with header '%s' equal to the title you clicked is displayed";

    /**
     * Message for search list appeared.
     */
    private static final String SEARCH_LIST_APPEARED_MESSAGE = "Check that list of items appeared";

    /**
     * Error message for search list in not appeared.
     */
    private static final String SEARCH_LIST_APPEARED_ERROR_MESSAGE = "List of items is not appeared";

    @Override
    public void runTest() {
        checkElement(ID_BLOCK);
        LinkModel link = Repository.getInstance().getLinkById(ID_BLOCK);

        Logger logger = getLogger();
        logger.info(SEARCH_LIST_APPEARED_MESSAGE);

        // Check that list of items appeared
        WebElement element = Browser
                .getInstance()
                .findElement(By.xpath(link.getXpath()));
        assertTrue(SEARCH_LIST_APPEARED_ERROR_MESSAGE, element.isDisplayed());

        checkElement(ID_ITEM);
        link = Repository.getInstance().getLinkById(ID_ITEM);
        assertTrue(String.format(LINK_ERROR_MESSAGE, ID_ITEM), link != null);

        // Get item of list.
        List<WebElement> listBooks = element.findElements(By.xpath(link.getXpath()));
        int index = generateRandomInt(0,  listBooks.size()-1);
        element = listBooks.get(index);

        logger.info(String.format(ITEM_TITLE_CLICK_MESSAGE, index));

        checkElement(ID_ITEM_TITLE);
        link = Repository.getInstance().getLinkById(ID_ITEM_TITLE);
        assertTrue(String.format(LINK_ERROR_MESSAGE, ID_ITEM_TITLE), link != null);

        WebElement bookTitle = element.findElement(By.xpath(link.getXpath()));
        logger.info(String.format(CHECK_HEADER_MESSAGE, bookTitle.getText()));
        String bookTitleText = bookTitle.getText();

        bookTitle.click();
        new VerifySearchItemHeader(bookTitleText).runTest();
    }

    /**
     * Generates random int in interval from min to max.
     * @param min Integer min.
     * @param max Integer max.
     * @return Gandom int in interval from min to max
     */
    private int generateRandomInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
