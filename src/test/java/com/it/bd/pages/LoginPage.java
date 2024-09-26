package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.ExcelUtils;
import com.it.bd.utilities.GetScreenShot;

public class LoginPage {
ExtentTest test;

ExcelUtils excelData = new ExcelUtils();
	
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;
	}
	
	@FindBy(xpath="//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[2]")
	WebElement login;
		
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//body/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/form[1]/p[3]/input[3]")
	WebElement loginbutton;
	
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	
	public void login() throws InterruptedException, IOException {
		
		excelData.ReadExcel();
		try {
			test.info("Click on Login");
			if(login.isDisplayed()) {
				login.click();
				Thread.sleep(5000);
			    passCase("Entered Loginpage");
				try {
					test.info("Click on username");
					if(username.isDisplayed()) {
				       username.clear();
				       username.sendKeys(excelData.username);
				       Thread.sleep(2000);
				       passCase("Entered username");
					
					try {
						test.info("Click on password");
						if(password.isDisplayed()) {			
				            password.clear();
				            password.sendKeys(excelData.password);
				            Thread.sleep(2000);
				            passCase("Entered password");
						
						try {
							test.info("Click on loginbutton");
							if(loginbutton.isDisplayed()) {		
				              loginbutton.click();
				               Thread.sleep(5000);
							}
						}
						catch(Exception e) {
							failCase("loginbutton was not locateable. Please check the error message", "loginbuttonfail");
				
			}
					}
					}
					catch(Exception e) {
						failCase("password was not locateable. Please check the error message", "passwordfail");
						
					}
				}
				}
				catch(Exception e) {
					failCase("username was not locateable. Please check the error message", "usernamefail");
				}
				
			}
			
		
		}catch(Exception e) {
			failCase("login was not locateable. Please check the error message", "loginfail");
			
		}
		
		
	}
	
}




