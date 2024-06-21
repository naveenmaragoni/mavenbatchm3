package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageAssignment {
 @FindBy(id="APjFqb")
 private WebElement searchTF;
 @FindBy(xpath="//a[text()='Gmail']")
 private WebElement gmailLK;
 @FindBy(xpath="//a[contains(@aria-label,\"Search Labs\")]")
 private WebElement searchLabs;
 @FindBy(xpath="//input[contains(@value,\"I'm Feeling Lucky\")]")
 private WebElement imFeelLucky;
 
//initialization

public GooglePageAssignment(WebDriver driver) {
	PageFactory.initElements(driver, this);
	//this.driver=driver;
}
//Utilization

public void setDataToSearchTF(String data) {
searchTF.sendKeys(data);
}
public void clickImFeelLucky() {
	imFeelLucky.submit();
}
public void clickGmailLK() {
	gmailLK.click();
}
public void clickSearchLabs() {
	searchLabs.click();
}

}
