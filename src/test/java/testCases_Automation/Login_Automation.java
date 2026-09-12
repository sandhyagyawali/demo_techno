package testCases_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login_Automation {
    public static void main(String[] args){

        // Launches a new Chrome browser and stores it in the WebDriver variable.
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new EdgeDriver();


        // Maximizes the browser window.
        driver.manage().window().maximize();

        // Deletes all cookies from the browser before starting the test.
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com/");

//        driver.navigate().to("https://automationexercise.com");
//
//        driver.navigate().back();
//
//        driver.navigate().forward();
//
//        driver.navigate().refresh();


        WebElement homePage = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        String actualResults =  homePage.getText();
        Assert.assertEquals(actualResults,"Home");


        WebElement signlogin = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signlogin.click();

        WebElement verify1 = driver.findElement(By.cssSelector("div[class='login-form'] h2"));
        String actualResults1 = verify1.getText();
        Assert.assertEquals(actualResults1,"Login to your account");


        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("preksha34@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("preksha34");

        WebElement login = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        login.click();

        WebElement verify2 = driver.findElement(By.xpath("//b[normalize-space()='Preksha Neupane']"));
        String actualResult2 = verify2.getText();
        Assert.assertEquals(actualResult2,"Preksha Neupane");

        WebElement logout = driver.findElement(By.cssSelector("a[href='/logout']"));
        logout.click();

        try{

            WebElement verify3 = driver.findElement(By.cssSelector("div[class='login-form'] h2"));
            String actualResults3 = verify3.getText();
            Assert.assertEquals(actualResults3,"Login to your account");
        }
        catch (Exception e){
            System.out.println("Login content not found..");
        }

        driver.quit();


    }
}
