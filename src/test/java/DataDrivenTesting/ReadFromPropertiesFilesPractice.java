package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFromPropertiesFilesPractice {
	
	
	public static String read(String key) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/test/resources/Data.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return property.getProperty(key);
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(read("url"));
		long time=Long.parseLong(read("timeouts"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		driver.findElement(By.id("email")).sendKeys(read("username"));
		driver.findElement(By.id("password")).sendKeys(read("password"));
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("last")).click();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
