package DataProvider;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripFlightsTest {

	@Test(dataProvider = "data")
	public void searchForFlightsTest(String src,String dest) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frame = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Delhi']")).sendKeys(src);
		Thread.sleep(3000);

		Robot r=new Robot() ;
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@value='Bengaluru']")).sendKeys(dest);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[@aria-label='Sun Jun 16 2024']")).clear();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.className("overlayCrossIcon")).click();
		
		String text =driver.findElement(By.cssSelector("p.whiteText")).getText();
		Assert.assertTrue(text.contains(src)&&text.contains(dest));
		driver.quit();
		
	}
		@DataProvider
		public Object [] [] data(){
			Object[][]obj=new Object[3][2];
			
			obj[0][0]="Hyderabad";
			obj[1][0]="Chennai";
			
			obj[0][0]="Hyderabad";
			obj[1][0]="Mumbai";
			
			obj[0][0]="Hyderabad";
			obj[1][0]="bengaluru";
			
			return obj;
	}
		
}
