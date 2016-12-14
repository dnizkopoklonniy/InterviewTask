package tests.actions;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Class for enter invalid email.
 */
public class EnterInvalidEmail extends BaseTest {

    /**
     * Id for wiley input field.
     */
    private static final String ID = "hp.receive.wiley.input_field";

    /**
     * Invalid email.
     */
    private static final String INVALID_EMAIL = "a.klimov.gmail.com";

    /**
     * Message for input text.
     */
    private static final String INPUT_TEXT_MESSAGE = "Enter invalid email '%s'";

    @Override
    public void runTest() {
        checkElement(ID);
        LinkModel link = Repository.getInstance().getLinkById(ID);

        getLogger().info(String.format(INPUT_TEXT_MESSAGE, INVALID_EMAIL));
        WebElement wileyInputField = Browser.getInstance().findElement(By.xpath(link.getXpath()));
        wileyInputField.sendKeys(INVALID_EMAIL);
    }
}
