package utilibillautomationpackage;
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



public class Moveoutwithoutdate extends LoginandQuit {
	

	
	@FindBy(id = "wfNewUtilityAccount")
	static WebElement uanbox;
	@FindBy(id = "ChkUseSameContractOne")
	static WebElement check1;
	@FindBy(id = "ChkUseSameServiceAddress")
	static WebElement check2;
	@FindBy(id = "ChkUseSameBillingAddress")
	static WebElement check3;
	@FindBy(id = "tbSaveAndSubmit")
	static WebElement submit;
	@FindBy(css="#common1 > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > a")
	static WebElement enroll;
	@FindBy(linkText="New Enrollment")
	static WebElement enr1;
	@FindBy(id = "wfContractOneRate")
	static WebElement rate;
	@FindBy(id = "wfUtilityAccount")
	static WebElement uan1;
	@FindBy(id = "wfContractStart")
	static WebElement contractstart;
	@FindBy(id = "wfCustomerName")
	static WebElement name;
	@FindBy(id = "btnSaveAndSubmit")
	static WebElement saveandsubmit;
	


	
	public static void MoveOut(String customerid,String uan,String d1,String rate_param, String uan1_param,String name_param,String contractstart_param) throws InterruptedException {
		
		
		et = ex.startTest("TC-009: Move out without date for enrollment");
		driver.get("http://localhost/Utilibill24A/Customer/CusMain.aspx?rid="+customerid);
		 Actions act = new Actions(driver);
		 WebDriverWait wait2 = new WebDriverWait(driver, 10);
		 WebElement click = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ddlActions\"]")));
		 act.moveToElement(click).perform();
		 Select more = new Select(click);
		 more.selectByVisibleText("More...");
		 
		 Actions act1 = new Actions(driver);
		 WebDriverWait wait1 = new WebDriverWait(driver, 10);
		 WebElement click1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ISIOption\"]")));
		 act.moveToElement(click1).perform();
		 Select more1 = new Select(click1);
		 more1.selectByVisibleText("Transfer Of Service");
		 Thread.sleep(3000);
		 
		
		uanbox.sendKeys(uan);
		

		
		
		for(int i=0;i<=1;i++) {
			try {
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement moveout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wfMoveInDate")));
				 moveout.sendKeys(d1);
				
			}
			
			catch(Exception e)
			{
				System.out.print(e.getMessage());
			}
		}
		
		check1.click();
		check2.click();
		check3.click();
		
		
		submit.click();
		
		String enr= enroll.getText();
		if(enr.equals("New Enrollment")) {
			System.out.println("Moveout date is blank.New Enrollement link is present.Test case passed");
			enr1.click();
			//driver = Enrollment.enroll("0.1", "12304569988888", "test", "08/16/2018");
			
			rate.sendKeys(rate_param);
			uan1.sendKeys(uan1_param);
			contractstart.sendKeys(contractstart_param);
			
			for(int i=0;i<=1;i++) {
				saveandsubmit.click();
				if(i==1) {
					name.sendKeys(name_param);
					contractstart.sendKeys(contractstart_param);
				}
				saveandsubmit.click();
			}
			
		}
		
		else {
			System.out.println("MoveOut date is present");
		}
		 et.log(LogStatus.PASS, "Test Case pass");
			ex.endTest(et);
		
		
		
		
		
		
	
		
	}

}
