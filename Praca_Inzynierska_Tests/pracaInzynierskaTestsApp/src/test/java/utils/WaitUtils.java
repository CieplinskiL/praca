package utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class WaitUtils {

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    public static void clickAndWait(WebElement webElement, long millis){
        try {
            webElement.click();
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }
}
