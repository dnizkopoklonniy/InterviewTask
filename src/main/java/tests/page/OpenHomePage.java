package tests.page;

import core.Browser;

/**
 * This test for open Home Page.
 */
public class OpenHomePage extends BasePage {

    /**
     * Url for home page.
     */
    private static final String URL = "http://www.wiley.com/WileyCDA/";

    /**
     * Name of page.
     */
    private static final String PAGE_NAME = "Home Page";

    public OpenHomePage() {
        setPageName(PAGE_NAME);
    }

    @Override
    public void doTest() {
        Browser.getInstance().get(URL);
    }
}
