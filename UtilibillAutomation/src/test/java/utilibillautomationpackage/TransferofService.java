package utilibillautomationpackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;


import org.junit.runner.RunWith;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;




//@RunWith(Parameterized.class)
public class TransferofService extends LoginandQuit {

	String customerid;
	String uan;
	String d1;
	String d2;
	
	
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
	
	/*@Parameters
	public static Object[][] getname(){
		return new Object[][] {
			{"36997","1008901024900320850109yo1","08/31/2018","08/31/2018"},{"36997","1008901024900320850109yo2","08/31/2018","08/31/2018"}
		};
		
	}
	
	public TOS(String customerid,String uan,String d1,String d2) {
		driver=Login.before_2(driver);
		PageFactory.initElements(driver, this);
		this.customerid=customerid;
		this.uan=uan;
		this.d1=d1;
		this.d2=d2;
	
		
	}*/
	

	
	public  void MoveOut(String customerid,String uan,String d1,String d2) throws InterruptedException, FileNotFoundException {
		
		et = ex.startTest("TC-006: Transfer of Service page"); 
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
		 System.out.println(uanbox);
		
		
		for(int i=0;i<=1;i++) {
			try {
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				 WebElement moveout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wfMoveOutDate")));
				 moveout.sendKeys(d1);
				
			}
			
			catch(Exception e)
			{
				System.out.print(e.getMessage());
			}
		}
	
		
		 WebDriverWait wait3 = new WebDriverWait(driver, 10);
		 WebElement movein = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("wfMoveInDate")));
		 movein.sendKeys(d2);
		 
		
		check1.click();
		check2.click();
		check3.click();
		
		
		submit.click();
		
		
		//logout.utilibill(driver);
		System.out.println("Moveout and Movein date are present.Test case passed");
		
		driver = Moveoutresponse.uploadfiles(driver);
		driver = Moveinresponse.uploadfiles(driver);
		
		
		}		
		
	
		
	
	//Copy and paste the file
	static void copyFileUsingChannel(String source, String dest) throws IOException {
		File sourceFile = new File(source);
		File destFile = new File(dest);
		
	    FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
	        sourceChannel = new FileInputStream(sourceFile).getChannel();
	        destChannel = new FileOutputStream(destFile).getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	       }finally{
	           //sourceChannel.close();
	           //destChannel.close();
	       }
	    et.log(LogStatus.PASS, "Test Case pass");
		ex.endTest(et);
	}
}
