package utilibillautomationpackage;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.automationtesting.excelreport.Xl;


public class LoginandQuit 
{

	public static WebDriver driver;
	public static ExtentReports ex;
	public static ExtentTest et;
	static String b;
	

@BeforeMethod(groups = { "dnp/rnp","movein_moveout", "billing" })
public  void setup() {
	

	System.setProperty("webdriver.chrome.driver","C:\\Users\\vdesai\\Downloads\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://wv119/Utilibill24A/Logon.aspx");
	//Passing Login and Password
	WebElement login = driver.findElement(By.name("wfUserid"));
	WebElement Password = driver.findElement(By.name("wfPassword"));
	login.sendKeys("eci569");
	Password.sendKeys("siberia");
	driver.findElement(By.name("btnLogon")).click();
	driver.manage().window().maximize();
	//CalenderProfile cp = new CalenderProfile(driver);
	

}

@AfterMethod(groups = { "dnp/rnp","movein_moveout", "billing" })
public  void teardown() {
	
	// driver.quit();
	 
	 
}

@BeforeSuite(groups = { "dnp/rnp","movein_moveout", "billing" })
public void reportpath() throws Exception {
	
	ex = new ExtentReports("C:\\Users\\vdesai\\Downloads\\report.html",true);
	ex.addSystemInfo("Author","Viral");
	
}



@AfterSuite(groups = { "dnp/rnp","movein_moveout" , "billing"})
public void generatereport() throws Exception {
	
	Xl.generateReport("Report_Excel.xlsx");
	ex.flush();
	
}



}
