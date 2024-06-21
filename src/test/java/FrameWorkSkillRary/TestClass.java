package FrameWorkSkillRary;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass extends BaseClass{
@Test(dataProvider = "credentials")
public void loginTest(String username,String password) {
	login.setUsername(username);
	login.setPassword(password);
	login.clickKeepMeLoggedInCB();
	login.clickLoginButton();
	
	Assert.assertTrue(login.adminPageHeaderIsDisplayed());
	
}
@DataProvider
public Object [][]credentials(){
	Object[][]obj=new Object[2][2];
	obj[0][0]="adminn";
	obj[0][1]="nani";
	
	obj[1][0]="admin";
	obj[1][1]="admin";
	return obj;
	}
}
