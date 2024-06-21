package Basics;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchUserDesiredBrowser {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
    Scanner scan =new Scanner (System.in);
    System.out.println("Enter BrowserName");
    String browser= scan.next();
    //WebDriver driver ;
    
     switch (browser) {
     case"chrome":
    	 WebDriverManager.chromedriver().setup();
    	 new ChromeDriver();
    	 break;
     case"firefox":
    	 WebDriverManager.firefoxdriver().setup();
    	 new FirefoxDriver();
    	 break;
     case"edge":
    	 WebDriverManager.edgedriver().setup();
    	 new EdgeDriver();
    	 break;
    	 default:
    		 System.out.println("Invalid Browser Info");
	}
	
	Thread.sleep(6000);
	driver.quit();
	
    	 
    
    
	}

}
