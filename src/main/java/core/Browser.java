package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * The class for work with browser.
 */
public class Browser {

    /**
     * Web driver instance.
     */
    private static WebDriver browser = null;

    /**
     * Gets web driver instance.
     * @return Web driver instance.
     */
    public static WebDriver getInstance() {
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
            browser = new ChromeDriver();
        }

        return browser;
    }

    /**
     * Closes browser.
     */
    public static void close() {
        if (browser != null) {
            browser.quit();
        }
    }
}
