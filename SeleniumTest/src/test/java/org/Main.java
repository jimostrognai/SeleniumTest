package test.java.org;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.io.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Main  {
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        
        String location1;
        String location2;
        String location3;
        
        location1 = "id('viewButtonDC1-1')";
        location2 = "id('viewButtonDC1-3')"; 
        location3 = "id('viewButtonDC1-4')";
        
        
        Float msg1;
        Float msg2;
        Float msg3;
        Float msg4;
        
        //Global Counts
        Float DODGX = null;
        Float VIIIX = null;
        Float PLGIX = null;
        Float VSCPX = null;
        
        //Website 1
        getData fourFifty7 = new getData();
        fourFifty7.loginToPage(location1);
        msg1 = fourFifty7.getDodge();
        msg2 = fourFifty7.getVan1();
        msg3 = fourFifty7.getPLG();
        msg4 = fourFifty7.getVan2();
              
        //Website 2
        getData fourOthree = new getData();
        fourOthree.loginToPage(location2);
        msg1 = fourOthree.getDodge();
        msg2 = fourOthree.getVan1();
        msg3 = fourOthree.getPLG();
        msg4 = fourOthree.getVan2();
        
        //Website 3
        getData match = new getData();
        match.loginToPage(location3);
        msg1 = match.getDodge();
        msg2 = match.getVan1();
        msg3 = match.getPLG();
        msg4 = match.getVan2();
        
        
        DODGX = match.getDodge() + fourOthree.getDodge() + fourFifty7.getDodge();
        VIIIX = match.getVan1() + fourOthree.getVan1() + fourFifty7.getVan1();
        PLGIX = match.getPLG() + fourOthree.getPLG() + fourFifty7.getPLG();      
        VSCPX = match.getVan2() + fourOthree.getVan2() + fourFifty7.getVan2();
        
        //Get the Current Date
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(dateFormat.format(cal.getTime())); 
        System.out.println("You have " + DODGX +" Units of DODGX - Dodge and Cox");
        System.out.println("You have " + PLGIX +" Units of PLGIX - Principal LargeCap Growth Fund I Institutional Class");
        System.out.println("You have " + VIIIX +" Units of VIIIX - Vanguard Institutional Index Fund Institutional Plus Shares");
        System.out.println("You have " + VSCPX +" Units of VSCPX - Vanguard Small Cap Index InstlPlus");
                 
      
    }
    

}