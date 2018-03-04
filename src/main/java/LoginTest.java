import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to execute login and logout steps

        WebDriver driver = getDriver();
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        Sleep(1000);

        // Login steps
         if (findElement(driver, By.id("email"))) {getElement(driver, By.id("email")).sendKeys("webinar.test@gmail.com");}
         if (findElement(driver, By.id("passwd"))) {
             getElement(driver, By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
             getElement(driver, By.id("passwd")).submit();
         }
         Sleep(1000);

        // Logout steps
        if (findElement(driver, By.id("header_employee_box"))) {getElement(driver, By.id("header_employee_box")).click();}
        if (findElement(driver, By.id("header_logout"))) {getElement(driver, By.id("header_logout")).click();}

        // Close browser
        driver.quit();
    }
}