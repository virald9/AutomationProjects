package utilibillautomationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class PastDueNotice_report extends LoginandQuit {
	
	
	
	@FindBy(id = "ddlUtility_lblDisplayText")
	WebElement none;
	@FindBy(id = "ddlUtility_chkAllItems")
	WebElement all;
	@FindBy(id="ddlUtility_cblDropList_8")
	WebElement centerpoint;
	@FindBy(id = "txtStartDate")
	WebElement startdate;
	@FindBy(id = "txtEndDate")
	WebElement enddate;
	@FindBy(id = "btnView")
	WebElement View;
	@FindBy(linkText = "8")
	WebElement number;
	@FindBy(xpath = "//tr/td[text()='Clear']/preceding::input[1]")
	WebElement check;
	@FindBy(id="gvGrid_ctl03_dgcName")
	WebElement link;
	@FindBy(xpath="//*[@id=\"pnlCriteria\"]/table[2]/tbody/tr/td/table/tbody/tr/td[6]")
	WebElement printnotice;
	

	
	public void notice() throws InterruptedException  {
		
		et = ex.startTest("TC==03 : Calender Profile");
		driver.get("http://wv119/Utilibill24A/Billing/LateNotices.aspx");
		none.click();
		//all.click();
		if(all.isSelected()) {
			all.click();
			centerpoint.click();
		}
		
		else if(!all.isSelected()) {
			centerpoint.click();
		}
		
	
		
		Select days = new Select(driver.findElement(By.id("ddlNoOfDays")));
		days.selectByVisibleText("Custom Dates");
		startdate.sendKeys("01/01/2017");
		enddate.sendKeys("09/14/2018");
		View.click();
		Thread.sleep(5000);
		number.click();
		check.click();
		b = link.getText();
		printnotice.click();
		et.log(LogStatus.PASS, "Test Case passed");
		ex.endTest(et);
		
		
	}

}
