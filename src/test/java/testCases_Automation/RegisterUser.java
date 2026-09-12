package testCases_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterUser {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");


        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Orry Te");

        WebElement email = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        email.sendKeys("orryte63@gmail.com");

        WebElement signup = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        signup.click();

        WebElement verify1 = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
        String actualResult2 = verify1.getText();
        Assert.assertEquals(actualResult2,"ENTER ACCOUNT INFORMATION");

        WebElement title = driver.findElement(By.id("id_gender2"));
        title.click();

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("sandhya63");

        // Locate Day Dropdown
        WebElement dayDropdown = driver.findElement(By.id("days"));

        // Create Select Object
        Select day = new Select(dayDropdown);

        // Select Day 18
        day.selectByVisibleText("18");

        WebElement months = driver.findElement(By.id("months"));
        months.sendKeys("December");

        WebElement years= driver.findElement(By.id("years"));
        years.sendKeys("2002");

        WebElement newsletter= driver.findElement(By.id("newsletter"));
        newsletter.click();

        WebElement offers= driver.findElement(By.id("optin"));
        offers.click();

        WebElement firstname= driver.findElement(By.id("first_name"));
        firstname.sendKeys("Sandhya");

        WebElement lastname= driver.findElement(By.id("last_name"));
        lastname.sendKeys("Gyawali");

        WebElement company= driver.findElement(By.id("company"));
        company.sendKeys("TechAxis");

        WebElement address= driver.findElement(By.id("address1"));
        address.sendKeys("Downtown 8");

        WebElement address2= driver.findElement(By.id("address2"));
        address2.sendKeys("Kathmandu,Kalanki");

        WebElement country= driver.findElement(By.id("country"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("India");

        WebElement state= driver.findElement(By.id("state"));
        state.sendKeys("Downtown");


        WebElement city= driver.findElement(By.id("city"));
        city.sendKeys("Pune");

        WebElement zipcode= driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("9900");

        WebElement mobileno= driver.findElement(By.id("mobile_number"));
        mobileno.sendKeys("9876543201");

//        WebElement create = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
//        create.click();

    }
}
