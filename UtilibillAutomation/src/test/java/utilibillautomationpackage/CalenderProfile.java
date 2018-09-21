package utilibillautomationpackage;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CalenderProfile extends LoginandQuit {
	
	
	@FindBy(xpath = "//*[@id=\"ctl06_AppMenuBarn5\"]/table/tbody/tr/td/a/table/tbody/tr/td")
	WebElement config;
	@FindBy(xpath = "//*[@id=\"ctl06_AppMenuBarn67\"]/td/table/tbody/tr/td/a/table/tbody/tr/td")
	WebElement calenderprofile_config;
	@FindBy(id = "TbNewCalendar")
	WebElement newcalender;
	@FindBy(id = "wfCalendarName")
	WebElement calenderprofile;
	@FindBy(id = "wfDescription")
	WebElement description;
	@FindBy(id = "btnSave")
	WebElement save;
	@FindBy(id = "wfHolidayDate")
	WebElement holidaydate;
	@FindBy(id = "wfComments")
	WebElement comments;
	@FindBy(id = "btnAddNewDate")
	WebElement addvalue;
	@FindBy(xpath = "//*[@id=\"ISI_TabBar_wfSettingsPageTbNotices_P\"]") 
	WebElement dnprnp;
	@FindBy(id = "btnSave")
	WebElement save_dnprnp;
	@FindBy(id="wfMinPaymentRes")
	WebElement residential;
	@FindBy(id="wfMinPaymentCom")
	WebElement commercial;
	@FindBy(id="ddlReconnectThresholdMethod")
	WebElement method1;
	@FindBy(id="ddlDisconnectThresholdMethod")
	WebElement method2;
	@FindBy(id="wfDisThresholdRes")
	WebElement res_dis;
	@FindBy(id="wfDisThresholdCom")
	WebElement comm_dis;
	
	
	
	public void calenderprofileforone() throws InterruptedException {
		
		et = ex.startTest("TC==04 : Calender Profile");
		
		driver.get("http://wv119/Utilibill24A/Config/CalendarProfileL.aspx");
		newcalender.click();
		calenderprofile.sendKeys("Newtest1");
		description.sendKeys("Newtest1");
		save.click();
		holidaydate.sendKeys("09/19/2018");
		comments.sendKeys("Newtest1");
		addvalue.click();
		driver.get("http://wv119/Utilibill24A/Config/SystemSettings.aspx");
		dnprnp.click();
		Select notice1 = new Select(driver.findElement(By.id("ddlDisconnectCalendarProfile")));
		notice1.selectByVisibleText("Newtest1");
		save_dnprnp.click();
		Assert.assertTrue(true);
		et.log(LogStatus.PASS, "Test Case passed");
		ex.endTest(et);
	}
	
	

	/*@DataProvider(name = "Authentication")
	public Object[][] data() {
		
		return new Object[][] {
			
			 { "1.2222", "50.6633" }, { "1.22", "50.33" }
		};
	}*/
	
	@DataProvider(name = "DNP/RNP Threshold")
	public Object[][] getdata() throws IOException{
		Object[][] excel = ExcelReader.get("C:\\Users\\vdesai\\Desktop\\Excel_Poi.xlsx");
		return excel;
	}
	
	
	
	 @Test(dataProvider = "DNP/RNP Threshold")
	public void threshold(String res,String comm) {
		et=ex.startTest("TC--10: Account with Calender Profile");
		PageFactory.initElements(LoginandQuit.driver, this);
		driver.get("http://wv119/Utilibill24A/Config/SystemSettings.aspx");
		dnprnp.click();
		Select method = new Select(method1);
		method.selectByValue("0");
		residential.clear();
		residential.sendKeys(res);
		commercial.clear();
		commercial.sendKeys(comm);
		res_dis.clear();
		res_dis.sendKeys(res);
		comm_dis.clear();
		comm_dis.sendKeys(comm);
		save_dnprnp.click();
		Select method_1 = new Select(method2);
		method_1.selectByValue("1");
		residential.clear();
		residential.sendKeys(res);
		commercial.clear();
		commercial.sendKeys(comm);
		res_dis.clear();
		res_dis.sendKeys(res);
		comm_dis.clear();
		comm_dis.sendKeys(comm);
		save_dnprnp.click();
		et.log(LogStatus.PASS, "Test Case passed");
		ex.endTest(et);
	}

}
