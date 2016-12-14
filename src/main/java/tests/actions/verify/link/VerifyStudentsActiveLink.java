package tests.actions.verify.link;

import core.Browser;
import core.Repository;
import data.LinkModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Checks 'Students' item has different style.
 * 'Students' link has active and parent styles.
 */
public class VerifyStudentsActiveLink extends BaseTest {

    /**
     * Error message for css style.
     */
    private static final String STYLE_ERROR_MESSAGE = "'Students' do not have a different style(do not active or parent)";

    /**
     * Error message for 'Students' link.
     */
    private static final String TEXT_ERROR_MESSAGE = "'Students' text do not match with text from data store";

    /**
     * Id of active link from data store.
     */
    private static final String ID = "st.students.active";

    /**
     * Attribute name.
     */
    private static final String ATTRIBUTE_NAME = "class";

    /**
     * Css style for 'active'.
     */
    private static final String CSS_ACTIVE_STYLE = "active";

    /**
     * Css style for 'parent'.
     */
    private static final String CSS_PARENT_STYLE = "parent";

    /**
     * Error message for link.
     */
    private static final String LINK_ERROR_MESSAGE = "Link with id '%s' not found in data store";

    /**
     * Message for log link text.
     */
    private static final String LINK_LOG_TEXT_MESSAGE = "Check on 'Students' link has text '%s'";

    /**
     * Message for log link style.
     */
    private static final String STYLE_LOG_TEXT_MESSAGE = "Check on 'Students' item has different style";

    @Override
    public void runTest() {
        checkElement(ID);
        LinkModel link = Repository.getInstance().getLinkById(ID);

        WebElement linkElement = Browser
                .getInstance()
                .findElement(By.xpath(link.getXpath()));

        Logger logger = getLogger();

        logger.info(String.format(LINK_LOG_TEXT_MESSAGE, linkElement.getText()));
        assertTrue(TEXT_ERROR_MESSAGE, link.getText().equals(linkElement.getText()));

        logger.info(STYLE_LOG_TEXT_MESSAGE );
        String cssClass = linkElement.findElement(By.xpath("..")).getAttribute(ATTRIBUTE_NAME);
        assertTrue(STYLE_ERROR_MESSAGE, cssClass.contains(CSS_ACTIVE_STYLE) && cssClass.contains(CSS_PARENT_STYLE));
    }
}
