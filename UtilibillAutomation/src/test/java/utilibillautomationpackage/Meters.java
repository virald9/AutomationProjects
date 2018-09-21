package utilibillautomationpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Meters extends LoginandQuit {
	
	
	@FindBy(id = "gvLocations_ctl02_gvcMeterTab")
	WebElement meternumber;
	@FindBy(id="ucExtendedRateClass_ToolBarButton_New")
	WebElement newschedule;
	@FindBy(id="ucExtendedRateClass_ddlType")
	WebElement click;
	
	
	public void meterpage(String customerid) {
	
		driver.get("http://localhost/Utilibill24A/Customer/CusMain.aspx?rid="+customerid);
		meternumber.click();
		newschedule.click();
		Select type=new Select(click);
		click.click();
		type.selectByValue("7");
		
	}
	
	

}
