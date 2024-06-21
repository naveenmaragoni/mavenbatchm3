package CrossBrowserParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  WebDriver driver;
  @Parameters("Browser")
  
  @BeforeClass
  public void classConfig(String browser) {
	  switch(browser) {
	  case"chrome":
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  break;
	  case"firefox":
		  WebDriverManager.firefoxdriver().setup();
		  driver=new ChromeDriver();
		  break;
	  case"edge":
		  WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
		  break;
		  default:
			  System.out.println("invalid browser");
				  
	  }
	  driver.manage().window().maximize();
  }
  @AfterClass
  public void classTeardown() {
	  driver.quit();
  }
}
