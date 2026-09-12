package testCases_Automation;

import baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPageObject;

public class TestCases_Login1 extends BaseClass {

    // Global page object variables
    HomePage home;
    LoginPageObject login;

    @BeforeMethod
    public void setUpPages() {
        home = new HomePage(driver);
        login = new LoginPageObject(driver);
    }

    @Test(priority = 1)
    public void loginTest() {

        home.verifyHomePage("Home");

        home.clickSignupLogin();

        Assert.assertEquals(login.verifyLoginHeading(),
                "Login to your account");

        login.enterEmail("preksha34@gmail.com");

        login.enterPassword("preksha34");

        login.clickLogin();

        Assert.assertEquals(login.verifyLoggedInUser(),
                "Preksha Neupane");

        login.clickLogout();

        Assert.assertEquals(login.verifyLoginHeading(),
                "Login to your account");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        home.verifyHomePage("Home");

        home.clickSignupLogin();

        Assert.assertEquals(login.verifyLoginHeading(),
                "Login to your account");

        login.enterEmail("preksha34@gmail.com");

        login.enterPassword("wrongpassword");

        login.clickLogin();

        Assert.assertEquals(login.verifyInvalidLogin(),
                "Your email or password is incorrect!");
    }

    @Test(priority = 3)
    public void empty(){}
}
