package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageObject {
    // Driver
    public WebDriver driver1;

    // Constructor
    public LoginPageObject(WebDriver driver){
        this.driver1 = driver;
    }

    private By loginHeading = By.cssSelector("div.login-form h2");

    private By email = By.xpath("//input[@data-qa='login-email']");

    public void enterEmail(String userEmail){

        driver1.findElement(email).sendKeys(userEmail);
    }

    private By password = By.name("password");

    private By loginButton = By.cssSelector("button[data-qa='login-button']");

    private By userName = By.xpath("//b[normalize-space()='Preksha Neupane']");

    private By logoutButton = By.cssSelector("a[href='/logout']");

    private By invalidMessage = By.xpath("//p[text()='Your email or password is incorrect!']");

    // Methods

    public String verifyLoginHeading(){

        return driver1.findElement(loginHeading).getText();
    }


    public void enterPassword(String userPassword){

        driver1.findElement(password).sendKeys(userPassword);
    }

    public void clickLogin(){

        driver1.findElement(loginButton).click();
    }

    public String verifyLoggedInUser(){

        return driver1.findElement(userName).getText();
    }

    public void clickLogout(){

        driver1.findElement(logoutButton).click();
    }

    public String verifyInvalidLogin(){

        return driver1.findElement(invalidMessage).getText();
    }

}
