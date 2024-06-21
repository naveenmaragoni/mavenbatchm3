package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLoginPage {
	//declaration
	@FindBy(id="email")
	private WebElement usernameTF;
	@FindBy(id="pass")
	private WebElement passwordTF;
	@FindBy (name="login")
	private WebElement loginBTN;
	@FindBy (linkText="Forgotten account")
	private WebElement forgotPwdLink;
	@FindBy (xpath="//a[text()='Create a new account']")
	private WebElement createAcLink;
	
	//initialization 
	
	public FaceBookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void setUsename(String un) {
		usernameTF.sendKeys(un);
	}
	public void setPassword(String pwd) {
		passwordTF.sendKeys(pwd);
	}
	public void clickLoginButton() {
		loginBTN.click();
		
	}
	public void clickforgotPwdLink() {
		forgotPwdLink.click();
	}
	public void clickcreateAcLink() {
		createAcLink.click();
	}
	
	
}
