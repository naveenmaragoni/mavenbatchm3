package Listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SkillraryBaseClass1 {
	public WebDriver driver;
	public static WebDriver driver1;

	@BeforeClass
	public void classSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver1=driver;
	}
	
	@BeforeMethod
	public void methodSetup() {
		driver.get("https://demoapp.skillrary.com/login.php");
		driver.findElement(By.linkText("Login")).click();

	}

	@Test(dataProvider = "data1")
	public void validateCreds1(String username, String password) throws Exception {
		try {
		driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='last']")).click();
		Thread.sleep(4000);
		
		WebElement error=driver.findElement(By.xpath("//h3[normalize-space()='Register']"));
		String error_text=error.getText();
		String expected="Register";
		Thread.sleep(4000);
		if(error_text.equals(expected)) {
			Assert.fail();
		}else {
			Assert.assertTrue(true);
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(4000);
		}
		
	
    @DataProvider(name = "data1")
	public Object[][] GetData() {
		return new Object[][] { { "admin123", "adminw21" }, { "admin", "admin" } };

	}

	@AfterClass
	public void classTearDown() {
		driver.quit();
	}
}
