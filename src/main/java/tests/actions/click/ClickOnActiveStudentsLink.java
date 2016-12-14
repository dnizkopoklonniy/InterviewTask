package tests.actions.click;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;
import tests.actions.verify.url.VerifyStudentsUrl;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Class for check condition - link 'Students' item is not clickable.
 */
public class ClickOnActiveStudentsLink extends BaseTest {

    /**
     * Message for active students.
     */
    private static final String ACTIVE_STUDENTS_MESSAGE = "Check that 'Students' item is not clickable";

    /**
     * Id for students.
     */
    private static final String ID = "st.students.active";

    @Override
    public void runTest() {
        checkElement(ID);
        LinkModel link = Repository.getInstance().getLinkById(ID);

        WebElement linkElement = Browser.getInstance().findElement(By.xpath(link.getXpath()));
        linkElement.findElement(By.xpath(".."));

        linkElement.click();

        getLogger().info(ACTIVE_STUDENTS_MESSAGE);
        new VerifyStudentsUrl().runTest();
    }
}
