package test.java.org;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.seleniumhq.jetty7.*;  Broke when I update the Selenium Driver?
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getData {
    
    String DODGX;
    String VIIIX;
    String PLGIX;
    String VSCPX;
            
    public void loginToPage(String location){
    //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();
    // Go to Transamerica Webpage
    //WebDriver driver = new HtmlUnitDriver();
    
    WebDriver driver = new FirefoxDriver();
      
    WebDriverWait wait = new WebDriverWait(driver, 60);
    // Windows Machine System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
    //Use this on a Mac
    System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
    
    driver.manage().window().maximize();
    driver.get("https://www.trsretire.com/webportal/retire/index.html");
    
    
    // Find the Username input element by its name
    WebElement userName = driver.findElement(By.name("username"));
    
    // Enter Username
    userName.sendKeys("Username");
    
    // Find the Password input element by its name
    WebElement passWord = driver.findElement(By.name("password"));
    
    // Enter Password
    passWord.sendKeys("Password");

    // Now submit the form. WebDriver will find the form for us from the element
    passWord.submit();
        
    //Click Button for First Account
    //WebElement account1 = driver.findElement(By.xpath("html/body/div[2]/div/div/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[9]/a"));
   
    WebElement account1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(location)));
    //WebElement account1 = driver.findElement(By.xpath(location));
    account1.click(); 
    
    //create a wait with 5-second timeout to see if the button becomes visable
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
    WebElement balance = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id('balanceDetails')")));
    
    //Get Details so you can get the units for Each fund    
    //WebElement balance = driver.findElement(By.xpath("html/body/footer/div[2]/div[1]/div[1]/ul[1]/li[3]/a"));
    balance.click();
    
    //Sigh, it is so fast it needs to wait for the Table to populate.  This will slow it down
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    // Get DODGX units      
    WebElement Dodge = driver.findElement(By.xpath(".//*[@id='accountBalanceByFund1']/tbody/tr[9]/td[3]"));
    DODGX = Dodge.getText();
        
    //Get VIIIX units
    WebElement van1 = driver.findElement(By.xpath(".//*[@id='accountBalanceByFund1']/tbody/tr[11]/td[3]"));
    VIIIX = van1.getText();
       
    //Get PLGIX units
    WebElement plg = driver.findElement(By.xpath(".//*[@id='accountBalanceByFund1']/tbody/tr[12]/td[3]"));
    PLGIX = plg.getText();
       
    //Get VSCPX units
    WebElement van2 = driver.findElement(By.xpath(".//*[@id='accountBalanceByFund1']/tbody/tr[17]/td[3]"));
    VSCPX = van2.getText();
    
    //Close the browser
    driver.quit();
    
    }
    public float getDodge() {
        DODGX = DODGX.replace(",", "");
        float f = Float.parseFloat(DODGX);
        return f;
    }
    public float getVan1() {
        VIIIX = VIIIX.replace(",", "");
        float f = Float.parseFloat(VIIIX);
        return f;
    }
    public float getPLG() {
        PLGIX = PLGIX.replace(",", "");
        float f = Float.valueOf(PLGIX);
        return f;
    }
    public float getVan2() {
        VSCPX = VSCPX.replace(",", "");
        float f = Float.parseFloat(VSCPX);
        return f;
    }
  
    
}
