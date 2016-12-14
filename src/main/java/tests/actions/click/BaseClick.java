package tests.actions.click;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import tests.BaseTest;

/**
 * Base class for click action.
 */
public abstract class BaseClick extends BaseTest {

    /**
     * Message for click.
     */
    private static final String CLICK_MESSAGE = "Click on element '%s'";

    /**
     * Id of element for click from data store.
     */
    private String elementId = null;

    @Override
    public void runTest() {
        checkElement(elementId);
        LinkModel link = Repository.getInstance().getLinkById(elementId);

        getLogger().info(String.format(CLICK_MESSAGE, link.getId()));
        Browser.getInstance().findElement(By.xpath(link.getXpath())).click();
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
}
