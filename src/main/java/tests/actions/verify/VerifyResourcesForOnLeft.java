package tests.actions.verify;

import core.Browser;
import core.CheckUtils;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;

/**
 * Test for checks 'Resources For' menu on the left.
 */
public class VerifyResourcesForOnLeft extends BaseTest {

    /**
     * Error message for link position.
     */
    private static final String POSITION_LINK_ERROR_MESSAGE = "Link 'Resource for' is not left";

    /**
     * Id for 'Resources For' link.
     */
    private static final String id = "st.resources.for";

    @Override
    public void runTest() {
        checkElement(id);
        getLogger().info("Verify on 'Resources For' menu on the left");

        WebDriver driver = Browser.getInstance();
        LinkModel link = Repository.getInstance().getLinkById(id);

        By xpath = By.xpath(link.getXpath());
        CheckUtils.checkOnElementPresent(xpath);
        CheckUtils.compareElementText(xpath, link.getText());

        WebElement resourcesForElement = driver.findElement(xpath);
        Point viewPortLocation = ((Locatable) resourcesForElement)
                .getCoordinates()
                .getLocationOnScreen();

        int positionResourcesLink = viewPortLocation.getX();
        int windowWidth = Browser.getInstance().manage().window().getSize().getWidth();

        assertTrue(positionResourcesLink < windowWidth/2, POSITION_LINK_ERROR_MESSAGE);
    }
}
