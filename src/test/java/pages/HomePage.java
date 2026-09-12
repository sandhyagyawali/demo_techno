package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    public WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
        // Locators
    private By homePage = By.xpath("//a[normalize-space()='Home']");

    private By signLogin = By.xpath("//a[normalize-space()='Signup / Login']");


    public void verifyHomePage(String expected) {

        // Get the actual text from the Home element
        String actual = driver.findElement(homePage).getText();

        // Compare actual and expected text
        Assert.assertEquals(actual, expected);
    }

//    public void verifyHomePage(String expected) {
//
//        WebElement homePage = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
//        // Get the actual text from the Home element
//        String actual = homePage.getText();
//
//        // Compare actual and expected text
//        Assert.assertEquals(actual, expected);
//    }

    public void clickSignupLogin(){

        driver.findElement(signLogin).click();
    }
}
