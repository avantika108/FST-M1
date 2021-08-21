package TestNGPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://www.training-support.net/selenium/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Write a @Test method, with the annotation @Parameters below @Test.
//Pass "username" and "password" as the parameters. Also add them as formal parameters for the test method.
//Use findElements() to find the username and password text boxes and the login button.
//Use sendKeys() with the variable names as input. Then click() the login button.

//In testng.xml,
//Add the <parameter> tags before the <classes> tag.
//Add name parameters for username and password.
//Set their value to "admin" and "password", respectively.
//Save all the files and RUN testng.xml, NOT the test script.
//
//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
//<suite parallel="false" name="Suite">
//    <test name="Test">
//        <parameter name="username" value="admin"/>
//        <parameter name="password" value="password"/>
//        <classes>
//            <class name="session9.Activity6"/>
//        </classes>
//    </test> <!-- Test -->
//</suite> <!-- Suite -->


public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @Test
    @Parameters({"username", "password"})
    public void loginTestCase(String username, String password) {
        //Find username and pasword fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        //Click Log in
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        //Assert Message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}




