package tests.actions.verify.section;

import core.Browser;
import core.CheckUtils;
import core.Repository;
import data.LinkModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import tests.BaseTest;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Abstract class for verify section.
 */
public abstract class BaseVerifySection extends BaseTest {

    /**
     * Template for start verify section.
     */
    private static final String START_VERIFY_SECTION_TEMPLATE = "Start verify section '%s'";

    /**
     * Template for end verify section.
     */
    private static final String END_VERIFY_SECTION_TEMPLATE = "End verify section '%s'";

    /**
     * Error message for section name.
     */
    private static final String SECTION_NAME_ERROR_MESSAGE = "Section name is null";

    /**
     * Error message for ids.
     */
    private static final String IDS_ERROR_MESSAGE = "Ids is null or empty";

    /**
     * Error message for element present.
     */
    private static final String ELEMENT_PRESENT_ERROR_MESSAGE = "The element '%s' do not present";
    /**
     * Error message for element text.
     */
    private static final String ELEMENT_TEXT_ERROR_MESSAGE = "The text '%s' do not match";

    /**
     * Template for element present.
     */
    private String ELEMENT_PRESENT_TEMPLATE = "Verify on element '%s' present";

    /**
     * Template for compare text of element.
     */
    private String ELEMENT_COMPARE_TEXT_TEMPLATE = "Verify that element '%s' has text '%s'";

    /**
     * Section name.
     */
    private String sectionName = null;

    /**
     * Id of links for check from data store.
     */
    private List<String> ids = null;

    @Test
    public final void runTest() {
        assertFalse(SECTION_NAME_ERROR_MESSAGE, getSectionName() == null);
        assertFalse(IDS_ERROR_MESSAGE, getIds() == null || getIds().isEmpty());

        Logger logger = getLogger();
        logger.info(String.format(START_VERIFY_SECTION_TEMPLATE, getSectionName()));

        for (String id: getIds()) {
            checkElement(id);
            LinkModel link = Repository.getInstance().getLinkById(id);

            // Check on exist link by path
            logger.info(String.format(ELEMENT_PRESENT_TEMPLATE, link.getText()));
            assertTrue(CheckUtils.checkOnElementPresent(By.xpath(link.getXpath())),
                    String.format(ELEMENT_PRESENT_ERROR_MESSAGE, link.getId()));

            // Check on text link
            String elementText = Browser.getInstance().findElement(By.xpath(link.getXpath())).getText();
            logger.info(String.format(ELEMENT_COMPARE_TEXT_TEMPLATE, link.getId(), link.getText()));
            assertTrue(link.getText().equals(elementText),
                    String.format(ELEMENT_TEXT_ERROR_MESSAGE, link.getId()));
        }

        logger.info(String.format(END_VERIFY_SECTION_TEMPLATE, getSectionName()));
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }
}
