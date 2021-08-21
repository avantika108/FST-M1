package TestNGPrograms;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://www.training-support.net/selenium/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Find the login input fields - username and password
//Enter the credentials - admin and password - and click the "Log in" button.
//Read the confirmation message and make and assertion to check if the correct message has been printed.

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        System.out.println("Before");
        
        driver.get("https://www.training-support.net/selenium/login-form");
        System.out.println("After");
    }

    @Test
    public void loginTest() throws Throwable {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        
        //Enter credentials
        username.sendKeys("admin");
        password.sendKeys("password");
        Thread.sleep(10);
        wait(10);
        
        //Click login
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        //Read login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        //Close browser
       driver.close();
    }
}