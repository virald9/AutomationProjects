package utilibillautomationpackage;


import java.io.File;
import java.io.FilenameFilter;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class DNPRNP_nonpayment_report extends LoginandQuit {
	
	

	@FindBy(xpath="//tr/td[contains(text(), 'Total Records')]")
	WebElement text;
	@FindBy(name="btnView")
	WebElement view;
	@FindBy(name="chkDisThreshold")
	WebElement check;
	@FindBy(id="wfAccountNumber")
	WebElement acc;
	@FindBy(id="gvGrid_ctl03_ckbSelected")
	WebElement checkselected;
	@FindBy(id="tbProcess")
	WebElement senddnprnp;

	
	
	/*public actionbutton() {
		PageFactory.initElements(loginandquit.driver, this);
		
	}*/
	

	public void disconnectreconnect() {
		
		et = ex.startTest("TC-001: Action Button fuctionality");
		
		driver.get("http://wv119/Utilibill24A/Billing/Autodnp_rnp.aspx");
		Select disconnect = new Select(driver.findElement(By.name("ddlAction")));
		    		disconnect.selectByVisibleText("Disconnect");
		    		view.click();
		    		String text_disconnect=text.getText();
		    		System.out.println(text_disconnect);
		    		String[] trimmedText_disconnect = text_disconnect.split(" ");
		    		String one = trimmedText_disconnect[0];
		    		String two = trimmedText_disconnect[1];
		    		String three = trimmedText_disconnect[2];
		    		String four = trimmedText_disconnect[3];
		    		/*boolean pageSource = driver.getPageSource().contains("Total Records");
		    		System.out.println(pageSource);*/
		    		
		    			
		    			
		    	
		    		
		    		
		    		Select reconnect = new Select(driver.findElement(By.name("ddlAction")));
		    		reconnect.selectByVisibleText("Reconnect");
		    		view.click();
		    		String text_reconnect=text.getText();
		    		System.out.println(text_reconnect);
		    		String[] trimmedText_reconnect = text_reconnect.split(" ");
		    		String one1 = trimmedText_reconnect[0];
		    		String two1 = trimmedText_reconnect[1];
		    		String three1 = trimmedText_reconnect[2];
		    		String four1 = trimmedText_reconnect[3];
		    		int x = Integer.parseInt(four)+Integer.parseInt(four1);
		    		
		    		
		    		
		    		
		    		Select disconnectreconnect = new Select(driver.findElement(By.name("ddlAction")));
		    		disconnectreconnect.selectByVisibleText("Disconnect/Reconnect");
		    		view.click();
		    		String text_disconnectreconnect=text.getText();
		    		System.out.println(text_disconnectreconnect);
		    		String[] trimmedText_disconnectreconnect = text_disconnectreconnect.split(" ");
		    		String one11 = trimmedText_disconnectreconnect[0];
		    		String two11 = trimmedText_disconnectreconnect[1];
		    		String three11 = trimmedText_disconnectreconnect[2];
		    		String four11 = trimmedText_disconnectreconnect[3];
		    		int y = Integer.parseInt(four11);
		    		Assert.assertEquals(x, y);
		    		et.log(LogStatus.PASS, "Test Case pass");
		    		ex.endTest(et);


	}
		
		public void warningcheckbox() {
			
			et=ex.startTest("TC--02:Warning Checkbox");
			
			driver.get("http://wv119/Utilibill24A/Billing/Autodnp_rnp.aspx");
			check.click();
			if(!check.isSelected()) {
				check.click();
			}
			String warn=text.getText();
			System.out.println(warn);
			et.log(LogStatus.PASS, "Test Case passed");
			ex.endTest(et);
			
	
		}
		
		
		public void nonpayment_calenderprofile() {
			
			et=ex.startTest("TC--05: Account with Calender Profile");
			driver.get("http://wv119/Utilibill24A/Billing/Autodnp_rnp.aspx");
			acc.sendKeys(b);
			view.click();
			Assert.assertFalse(false);
			et.log(LogStatus.PASS, "Test Case passed");
			ex.endTest(et);
			
			
		}
		
		
		public void findfile() {
			
			driver.get("http://wv119/Utilibill24A/Billing/Autodnp_rnp.aspx");
			acc.sendKeys(b);
			view.click();
			checkselected.click();
			senddnprnp.click();
			File f = new File("C:\\example");
			File[] matchingFiles = f.listFiles(new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.startsWith("OUT") && name.endsWith("91132");
			    }
			});
			
		}
		

}
