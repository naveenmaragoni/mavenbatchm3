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

	public class DPcg {

		@Test(dataProvider = "data")
		public void searchForFlightsTest(String src, String dest) throws InterruptedException, AWTException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement frame = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
			driver.switchTo().frame(frame);
			driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

			driver.findElement(By.xpath("//span[text()='From']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src); // Corrected the input locator
			Thread.sleep(3000);

			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[text()='To']")).click();
			driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dest); // Corrected the input locator
			Thread.sleep(3000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//div[@aria-label='Sun Jun 16 2024']")).click(); // Use click instead of clear
			driver.findElement(By.xpath("//a[text()='Search']")).click();
			
			String text = driver.findElement(By.className("font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom")).getText();
			Assert.assertTrue(text.contains(src) && text.contains(dest));
			driver.quit();
		}
		
		@DataProvider
		public Object[][] data() {
			return new Object[][] {
				{ "Hyderabad", "Delhi" },{ "Chennai", "Mumbai" }};
		}
	}



