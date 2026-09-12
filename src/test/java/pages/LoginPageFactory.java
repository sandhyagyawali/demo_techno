package pages;

import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPageFactory {
    WebDriver driver;

    // Constructor
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ===================== Locators =====================

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signLogin;


    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    // ===================== Methods =====================


    // Click Signup/Login
    public void clickSignupLogin() {
        signLogin.click();
    }

    public void enterEmail(String useremail){
        email.sendKeys(useremail);
    }

    // Enter Password
    public void enterPassword(String userPassword) {
        password.sendKeys(userPassword);
    }
}
