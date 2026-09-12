package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseClass {
    // Global Driver
    public static WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void setupBrowser() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        driver.quit();
    }

}
