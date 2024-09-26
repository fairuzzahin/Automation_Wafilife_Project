package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class OrderPage {
ExtentTest test;
	
	public OrderPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;
	}
	
	@FindBy(xpath="//input[@id='billing_first_name']")
	WebElement name;
	
		
	@FindBy(xpath="//input[@id='billing_phone']")
	WebElement Phoneno1;
	
	@FindBy(xpath="//input[@id='billing_alternative_phone']")
	WebElement Phoneno2;
	
	@FindBy(xpath=" //input[@id='billing_email']")
	WebElement email;
	
	/*@FindBys({
		@FindBy	(xpath="//span[@id='select2-billing_state-container']"),
		@FindBy	(xpath="//body/div[1]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/p[5]/span[1]/span[1]/span[1]/span[1]/span[2]")
		
	})
	WebElement district;
	
	
	@FindBy(xpath="//select[@id='billing_area']")
	
	WebElement area;*/
	
	
	//@FindBy(xpath="//textarea[@id='billing_address_1']")
	//WebElement  address;
	
	//@FindBy(xpath="//textarea[@id='order_comments']")
	//WebElement order_comments;
	
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
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

	
	public void order() throws InterruptedException, IOException {
		try {
			test.info("Name Info");
			if(name.isDisplayed()) {
			name.clear();
			name.sendKeys("Fairuz Zahin Sneha");
			Thread.sleep(2000);
		       passCase("Entered name");
			
				try {
					test.info("Phoneno1 Info");
					if(Phoneno1.isDisplayed()) {
						Phoneno1.clear();
						Phoneno1.sendKeys("01918055382");
						Thread.sleep(2000);
						passCase("Entered phoneno1");


						try {

							test.info("Phoneno2 Info");
							if(Phoneno2.isDisplayed()) {
								Phoneno2.clear();
								Phoneno2.sendKeys("01918089582");
								Thread.sleep(2000);
								passCase("Entered phoneno2");


								try {
									test.info("Email Info");
									if(email.isDisplayed()) {
										email.clear();
										email.sendKeys("fairuz.zahin2018@gmail.com");
										Thread.sleep(2000);
										passCase("Entered email");

					
				/*try {
					test.info("District Info");
					if(district.isDisplayed()) {
		              Select select =new Select(district);
				      select.selectByIndex(4);
				       Thread.sleep(2000);
				       passCase("Entered district");
				try {
					test.info("Area Info");
					if(area.isDisplayed()) {
				    Select select1 =new Select(area);
				    select1.selectByIndex(3);
				    Thread.sleep(2000);
				    passCase("Entered area");
				try {
					test.info("Address Info");
					if(address.isDisplayed()) {
				       address.clear();
				       address.sendKeys("G.P Cha-24,North Badda,Badda,Dhaka-1212");
				       Thread.sleep(2000);
				   	   passCase("Entered address");
				   	try {
						test.info("Order Info");
						if(order_comments.isDisplayed()) {
				           order_comments.clear();
				           order_comments.sendKeys("I want to order two books");
				           Thread.sleep(4000);
				           passCase("Ordercomments is done");
				
			}
				   	}
				   	catch(Exception e) {
						failCase("ordercomments was not locateable. Please check the error message", "ordercommentsfail");
						
					}
					}
				}
				catch(Exception e) {
					failCase("address was not locateable. Please check the error message", "addressfail");
					
				}
					}
				}
				catch(Exception e) {
					failCase("area was not locateable. Please check the error message", "areafail");
					
				}
					}
				}
				catch(Exception e) {
					failCase("district was not locateable. Please check the error message", "districtfail");
					
				}*/
			}
			}
								catch(Exception e) {
									failCase("Email was not locateable. Please check the error message", "emailfail");
									
								}
							}
						}
						catch(Exception e) {
							failCase("Phoneno2 was not locateable. Please check the error message", "phoneno2fail");
							
						}
					}
				}
		
		catch(Exception e) {
			failCase("Phoneno1 was not locateable. Please check the error message", "phoneno1fail");
			
		}
	}
				
				
			
		}catch(Exception e) {
			failCase("Name was not locateable. Please check the error message", "namefail");
			
		}
		
		
	}

}
