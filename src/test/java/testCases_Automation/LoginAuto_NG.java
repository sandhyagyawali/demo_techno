package testCases_Automation;

import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;


public class LoginAuto_NG extends BaseClass {

    // Actual Test Case
    @Parameters("email")
    @Test(priority = 1 , groups = {"smoke","regression"})
    public void validloginTest(String u_email) {

        // Verify Home page
        WebElement homePage = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        String actualResult = homePage.getText();
        Assert.assertEquals(actualResult, "Home");

        // Click Signup/Login
        WebElement signLogin = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signLogin.click();

        // Verify Login page heading
        WebElement verifyLogin = driver.findElement(By.cssSelector("div.login-form h2"));
        String loginHeading = verifyLogin.getText();
        Assert.assertEquals(loginHeading, "Login to your account");

        // Enter Email
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys(u_email);

        // Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("preksha34");

        // Click Login
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        loginButton.click();

        // Verify Logged In User
        WebElement userName = driver.findElement(By.xpath("//b[normalize-space()='Preksha Neupane']"));
        String actualUser = userName.getText();
        Assert.assertEquals(actualUser, "Preksha Neupaneee");

        // Logout
        WebElement logout = driver.findElement(By.cssSelector("a[href='/logout']"));
        logout.click();

        // Verify Logout successful
        WebElement verifyLogout = driver.findElement(By.cssSelector("div.login-form h2"));
        String logoutHeading = verifyLogout.getText();
        Assert.assertEquals(logoutHeading, "Login to your account");
    }


    @Test(priority = 2, groups = {"regression"}, dependsOnMethods = "validloginTest")
    public void invalidloginTest() {

        // Verify Home page
        WebElement homePage = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        String actualResult = homePage.getText();
        Assert.assertEquals(actualResult, "Home");

        // Click Signup/Login
        WebElement signLogin = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signLogin.click();

        // Verify Login page heading
        WebElement verifyLogin = driver.findElement(By.cssSelector("div.login-form h2"));
        String loginHeading = verifyLogin.getText();
        Assert.assertEquals(loginHeading, "Login to your account");

        // Enter Email
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("preksha34@gmail.com");

        // Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("preksha134");

        // Click Login
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        loginButton.click();

        // Invalid Error
        WebElement verifyLogout = driver.findElement(By.cssSelector("div.login-form h2"));
        String logoutHeading = verifyLogout.getText();
        Assert.assertEquals(logoutHeading, "Login to your account");
    }

//    // Runs AFTER every test method
//    @AfterMethod
//    public void closeBrowser() {
//
//        driver.quit();
//    }
//
//    @AfterClass
//    public void after(){
//        System.out.println("@AfterCl");
//    }
}
