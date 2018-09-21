package utilibillautomationpackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;



public class ContractExpired extends LoginandQuit {


	@FindBy(id="gvLocations_ctl02_gvcMeterTab")
	static WebElement click;
	@FindBy(xpath="//*[@id=\"ucExtendedRateClass_gvGrid\"]/tbody/tr[2]/td[5]")
	static WebElement contractexpirationdate;
	@FindBy(xpath="//*[@id=\"common1\"]/tbody/tr/td/table/tbody/tr/td/font")
	static WebElement message;
	
	
	

	
	public static void drop(String customerid) throws InterruptedException {
		
		
		et = ex.startTest("TC-007: Contract Expiration page"); 
		 driver.get("http://localhost/Utilibill24A/Customer/CusMain.aspx?rid="+customerid);
		 Actions act = new Actions(driver);
		 act.moveToElement(click).click().build().perform();
		 Thread.sleep(3000);
		
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 Date date = new Date();
		 String time = sdf.format(date);
		 System.out.println(time);
		 
		 String ced = contractexpirationdate.getText();
		 System.out.println(ced);
		 
		
		 if(ced.compareTo(time)<=0) {
			 
			driver.get("http://localhost/Utilibill24A/Customer/CusMain.aspx?rid="+customerid);
			 
			 /*Actions act1 = new Actions(driver);
			 WebElement click1 = driver.findElement(By.xpath("//*[@id=\"ISI_TabBar_wfCustomerPageTbMain_U\"]/img"));
			 act1.moveToElement(click).click().build().perform();*/
			 
			 Actions act2 = new Actions(driver);
			 WebDriverWait wait2 = new WebDriverWait(driver, 10);
			 WebElement click2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ddlActions\"]")));
			 act2.moveToElement(click2).perform();
			 Select more = new Select(click2);
			 more.selectByVisibleText("More...");
			 
			 Actions act3 = new Actions(driver);
			 WebDriverWait wait1 = new WebDriverWait(driver, 10);
			 WebElement click3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ISIOption\"]")));
			 act3.moveToElement(click3).perform();
			 Select more1 = new Select(click3);
			 more1.selectByVisibleText("Transfer Of Service");
			 Thread.sleep(3000);
			 
			 String msg = message.getText();
			 System.out.println(msg+"Test case passed");
		 
			 
		 }
		 
		 else {
			 System.out.println("Account has active contract");
		 }
		 et.log(LogStatus.PASS, "Test Case passed");
			ex.endTest(et);
			
		
			
	}
		 
	
		
		
		
		
	}


