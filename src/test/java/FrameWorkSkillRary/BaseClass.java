package FrameWorkSkillRary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	protected  WebDriver driver;	
	
	protected DriverUtility driverUtil;
	protected JavaUtility jUtil;
	protected FileUtility file;
	
	protected SkillraryDemoAppLoginPage login;
	
	public static WebDriver sdriver;
	public static JavaUtility sjUtil;
	public static DriverUtility sdriverUtil;
	
	@BeforeClass
	public void ClassSetup() {
		driverUtil =new DriverUtility();
		file= new FileUtility();
		jUtil=new JavaUtility();
		
		file.propertiesInit();
		driver=driverUtil.launchBrowser(file.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
		driverUtil.waitTillElementFound(jUtil.convertStringToLong(file.readFromProperties("timeouts")));
		 
		sdriver=driver;
		sjUtil=jUtil;
		sdriverUtil=driverUtil;
		
	}
	@BeforeMethod 
	public void methodSetup() {
		driverUtil.navigateToApp(file.readFromProperties("url"));
		login=new SkillraryDemoAppLoginPage(driver);
		login.clickLogin();
	}
	@AfterClass
	public void classTeardown() {
		driverUtil.closeBrowser();
	}
	

}
