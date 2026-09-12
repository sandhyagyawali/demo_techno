package testCases_Automation;

import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPageFactory;

public class LoginPageFactoryCase extends BaseClass {
    @Test (groups = "smoke")
    public void loginPF(){
        LoginPageFactory lpf = new LoginPageFactory(driver);
        lpf.clickSignupLogin();
        lpf.enterEmail("tester@gmail.com");
        lpf.enterPassword("Tester#134");
    }
}
