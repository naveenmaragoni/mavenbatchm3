package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SkillRaryLoginUsingPropertiesTest
{
	public static void main(String[] args) throws InterruptedException {
		
		FileUtility naveen =new FileUtility();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(naveen.readFromProperties("url"));
		
		long time=Long.parseLong(naveen.readFromProperties("timeouts"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
        SkillraryDemoAppLoginPage login= new SkillraryDemoAppLoginPage(driver);
        
        login.setUsername(naveen.readFromProperties("username"));
        login.setPassword(naveen.readFromProperties("password"));
        login.clickKeepMeLoggedInCB();
        login.clickLoginButton();
        Thread.sleep(3000);
        driver.quit(); 

        

	}

}
