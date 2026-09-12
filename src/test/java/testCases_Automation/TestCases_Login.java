package testCases_Automation;

import baseClass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPageObject;

@Listeners(utilities.CustomTestListener.class)
public class TestCases_Login extends BaseClass {

    @Test(priority = 1)
    public void loginTest() {
        HomePage home = new HomePage(driver);
        LoginPageObject login = new LoginPageObject(driver);

        home.verifyHomePage("Home");

        home.clickSignupLogin();

        Assert.assertEquals(login.verifyLoginHeading(),
                "Login to your account");

        login.enterEmail("preksha34@gmail.com");

        login.enterPassword("preksha34");

        login.clickLogin();

        Assert.assertEquals(login.verifyLoggedInUser(),
                "Preksha Neupaneee");

        login.clickLogout();

        Assert.assertEquals(login.verifyLoginHeading(),
                "Login to your account");
    }

    @Test(priority = 2,dependsOnMethods = "loginTest")
    public void invalidLoginTest() {
        HomePage home = new HomePage(driver);
        LoginPageObject login = new LoginPageObject(driver);

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
