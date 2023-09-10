package com.fooodie.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
	public static void main(String[] args) {
        // declarations
        WebDriver driver = new FirefoxDriver();
        String email_input_value = "fooodie@gmail.com";
        String password_input_value = "111111111";
        int delay_milli_seconds = 1000;

        driver.get("https://fooodieweb.000webhostapp.com");
        clickWithDelay(driver, By.linkText("SIGN IN"), delay_milli_seconds);
        inputTextWithDelay(driver, By.cssSelector("input[type='email'][placeholder='example@gmail.com']"), email_input_value, delay_milli_seconds);
        inputTextWithDelay(driver, By.cssSelector("input[type='password'][placeholder='Enter Password']"), password_input_value, delay_milli_seconds);
        clickWithDelay(driver, By.name("login"), delay_milli_seconds);
        handleAlert(driver);
        addDelay(500);

        // Additional delay before clicking the "EXPLORE" link
        addDelay(2000);

        // Click the "EXPLORE" link
        clickWithDelay(driver, By.linkText("EXPLORE"), delay_milli_seconds);
        
        clickWithDelay(driver, By.linkText("REVIEWS"), delay_milli_seconds);
        driver.navigate().back();
       
        clickWithDelay(driver, By.linkText("FAQ"), delay_milli_seconds);
        driver.navigate().back();
       
        clickWithDelay(driver, By.linkText("CONTACT"), delay_milli_seconds);
        driver.navigate().back();
       
        clickWithDelay(driver, By.linkText("MY CART"), delay_milli_seconds);
      
        clickWithDelay(driver, By.linkText("HOME"), delay_milli_seconds);
       
        clickWithDelay(driver, By.linkText("LOGOUT"), delay_milli_seconds);
        
        driver.quit();
  
    }

    // Method for click with a delay
    public static void clickWithDelay(WebDriver driver, By locator, long milliseconds) {
        WebElement element = driver.findElement(locator);
        element.click();
        addDelay(milliseconds);
    }

    // Method for adding a delay
    public static void addDelay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    // Method to input text into a field and add a delay
    public static void inputTextWithDelay(WebDriver driver, By locator, String text, long milliseconds) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        addDelay(milliseconds);
    }
    
    // Method to handle the alert
    public static void handleAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }
    
	
}