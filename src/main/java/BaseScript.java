import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    // @return New instance of {@link WebDriver} object.
    public static WebDriver getDriver() {
        // TODO return WebDriver instance
        String driverPath = System.getProperty("user.dir")+"/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }

    // Wait for some milliseconds
    public static void Sleep(Integer mSeconds) {
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Check if element is present
    public static boolean findElement(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element "+by.toString()+" not found.");
            return false;
        }
    }

    // Get element
    public static WebElement getElement(WebDriver driver, By by) {
        WebElement getElement = driver.findElement(by);
        return getElement;
    }
}