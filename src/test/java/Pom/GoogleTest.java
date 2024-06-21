package Pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		GooglePageAssignment google=new GooglePageAssignment(driver);
		
		//google.clickGmailLK();
		//driver.switchTo().defaultContent();
		google.setDataToSearchTF("ac");
		google.clickImFeelLucky();
		//driver.navigate().back();
		google.clickSearchLabs();
		//driver.switchTo().defaultContent();

		//google.setDataToSearchTF("ac");
		Thread.sleep(3000);
		driver.quit();
	

}
}