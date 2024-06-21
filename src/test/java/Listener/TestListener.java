package Listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution");
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		TakesScreenshot ts =(TakesScreenshot)SkillraryBaseClass1.driver1;
		File temp =ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+result.getMethod().getMethodName()+".png");
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	System.out.println(result.getThrowable());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts =(TakesScreenshot)SkillraryBaseClass1.driver1;
		File temp =ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+result.getMethod().getMethodName()+".png");
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	System.out.println(result.getThrowable());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
}



