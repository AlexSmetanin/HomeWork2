import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to check Main Menu items
        WebDriver driver = getDriver();
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        Sleep(1000);

        // Login steps
        if (findElement(driver, By.id("email"))) {
            getElement(driver, By.id("email")).sendKeys("webinar.test@gmail.com");
        }
        if (findElement(driver, By.id("passwd"))) {
            getElement(driver, By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
            getElement(driver, By.id("passwd")).submit();
        }
        Sleep(1000);

        // Check Main Menu items
        String[] menuItems = {"Dashboard", "Заказы", "Каталог", "Клиенты", "Служба поддержки", "Статистика",
                "Modules", "Design", "Доставка", "Способ оплаты", "International", "Shop Parameters", "Конфигурация"};
        for (String currentItem : menuItems) {
            checkMainMenu(driver, By.linkText(currentItem));
        }

        // Close browser
        driver.quit();
    }

    // Click menu item, refresh page and compare page title
    public static void checkMainMenu(WebDriver driver, By by) {
        if (findElement(driver, by)) {
            getElement(driver, by).click();
            Sleep(1000);
            String currentTitle = driver.getTitle();
            System.out.println("Page title is: " + currentTitle);
            driver.navigate().refresh();
            Sleep(1000);
            if (!driver.getTitle().toString().equals(currentTitle)) {   // if the page was changed
                System.out.println("Warning! The page was changed!");   // that print message
            }
        }
    }

}