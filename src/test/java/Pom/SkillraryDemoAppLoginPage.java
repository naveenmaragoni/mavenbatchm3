package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryDemoAppLoginPage {
	
	//declaration
	
	@FindBy(id="email")
	private WebElement usernameTF;
	
	@FindBy(id="password")
	private WebElement passwordTF;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement KeepMeLoggedInCB;
	
	@FindBy(id="toPasswordRecoveryPageLink")
	private WebElement ForgotPwdLink;
	 
	@FindBy(id="last")
	private WebElement LoginButton;
	
	//initialization
	
	public SkillraryDemoAppLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
   //utilization
	public void setUsername(String username) {
		usernameTF.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordTF.sendKeys(password);
	}
	public void clickKeepMeLoggedInCB() {
		KeepMeLoggedInCB.click();
		
	}
	public void clickForgotPasswordLink() {
		ForgotPwdLink.click();
	}
	public void clickLoginButton() {
		LoginButton.click();
		
	}
}
