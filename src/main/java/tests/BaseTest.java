package tests;

import core.Repository;
import data.LinkModel;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Base test for all tests.
 */
public abstract class BaseTest {

    /**
     * Error message for element id.
     */
    private static final String ELEMENT_ID_ERROR_MESSAGE = "Element id is null";

    /**
     * Error message for link.
     */
    private static final String LINK_ERROR_MESSAGE = "Link with id '%s' not found in data store";

    /**
     * Logger.
     */
    private static Logger logger = null;

    /**
     * Gets logger instance.
     * @return Logger instance.
     */
    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(BaseTest.class);
        }

        return logger;
    }

    @Test
    public abstract void runTest();

    public void checkElement (String elementId) {
        assertTrue(elementId != null, String.format(ELEMENT_ID_ERROR_MESSAGE, elementId));

        LinkModel link = Repository.getInstance().getLinkById(elementId);
        assertTrue(link != null, String.format(LINK_ERROR_MESSAGE, elementId));
    }
}
