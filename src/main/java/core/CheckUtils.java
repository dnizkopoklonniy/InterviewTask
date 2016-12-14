package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Utils for check web elements.
 */
public class CheckUtils {

    /**
     * Checks on element present.
     * @param by Element with id or name attributes.
     * @return True if element present, false another.
     */
    public static boolean checkOnElementPresent(By by) {
        try {
            Browser.getInstance().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Compares web element text with text from data store.
     * @param by By.
     * @param text Text from data store.
     * @return True if texts are equals, false another.
     */
    public static boolean compareElementText(By by, String text) {
        try {
            String currentText = Browser.getInstance().findElement(by).getText();
            return text.equals(currentText);
        } catch (NoSuchElementException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
