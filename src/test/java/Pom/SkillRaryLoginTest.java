package Pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SkillRaryLoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        SkillraryDemoAppLoginPage login= new SkillraryDemoAppLoginPage(driver);
        login.setUsername("admin");
        login.setPassword("admin");
        login.clickKeepMeLoggedInCB();
        login.clickLoginButton();
        Thread.sleep(3000);
        driver.quit();
	}

}
