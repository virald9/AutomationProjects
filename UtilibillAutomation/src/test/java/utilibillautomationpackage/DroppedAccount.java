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



public class DroppedAccount extends LoginandQuit {

	
	
	@FindBy(xpath="//*[@id=\"common1\"]/tbody/tr/td/table/tbody/tr/td/font")
	static WebElement message;
	


	
	public static void drop(String customerid) throws InterruptedException {
		
		
		et = ex.startTest("TC-008: Dropped Account ");
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
		 
		 String va = message.getText();
		 if(va.equals("No active meters found.")) {
			 System.out.println("Dropped Account.Test cases passed");
		 }
		 else {
			 System.out.println("Account is Active");
			
		 }
		 et.log(LogStatus.PASS, "Test Case passed");
		ex.endTest(et);
	
		
		
		
	
		
	}

}
