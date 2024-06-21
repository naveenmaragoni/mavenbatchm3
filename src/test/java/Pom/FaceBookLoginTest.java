package Pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FaceBookLoginPage FBlogin=new FaceBookLoginPage(driver);
		FBlogin.setUsename("naveen");
		FBlogin.setPassword("nani");
		FBlogin.clickLoginButton();
		
		Thread.sleep(3000);
		driver.quit();
		
		


	}

}
