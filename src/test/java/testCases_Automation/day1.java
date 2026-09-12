package testCases_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class day1 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");

//        driver.navigate().to("https://automationexercise.com/");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

        WebElement loginHeading = driver.findElement(By.cssSelector("div[class='login-form'] h2"));
        String h1 = loginHeading.getText();
        Assert.assertEquals(h1,"Login to your account");

        Boolean b = loginHeading.isDisplayed();
        Assert.assertTrue(b);


        WebElement email = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        email.sendKeys("preksha@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("134444");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        loginBtn.click();


//        WebElement verify1 = driver.findElement(By.cssSelector("div[class='login-form'] h2"));
//        String actualResults1 = verify1.getText();
//        Assert.assertEquals(actualResults1,"Login to your account");
//
//
//        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
//        email.sendKeys("preksha34@gmail.com");
//
//        WebElement password = driver.findElement(By.name("password"));
//        password.sendKeys("preksha34");

        //driver.quit();
        //driver.close();
    }
}
