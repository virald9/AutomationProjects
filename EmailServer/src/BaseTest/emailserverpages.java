package BaseTest;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.collections.Lists;


public class emailserverpages {
	
	static WebDriver driver;
	
	
	@DataProvider(name="SystemSettings")
	public static Object[][] systemsettings()  {
		return new Object[][] 
				{
			{"ecimailsvr.domain.local","900000","Utilibillsupport","U^98iq"}
			
				};
	}
	
	
	@Test(dataProvider="SystemSettings")
	//@Parameters({"emailhost","timeout","username","password"})
	public static void systemssettingconfig(String emailhost, String timeout, String username ,String password) {
		driver=Loginandquit.before();
		driver.findElement(By.xpath("//*[@id=\"ctl06_AppMenuBarn5\"]/table/tbody/tr/td/a/table/tbody/tr/td")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl06_AppMenuBarn45\"]/td/table/tbody/tr/td/a")).click();
		driver.findElement(By.id("wfEmailHost")).clear();
		driver.findElement(By.id("wfEmailHost")).sendKeys(emailhost);
		driver.findElement(By.id("wfEmailTimeout")).clear();
		driver.findElement(By.id("wfEmailTimeout")).sendKeys(timeout);
		WebElement chk= driver.findElement(By.id("chkEmailAuthenticationRequired"));
		if(chk.isSelected()) {
			chk.click();
		}
		WebElement sslchk= driver.findElement(By.id("chkEnableSSL"));
		if(sslchk.isSelected()) {
			chk.click();
		}
		
		 
		driver.findElement(By.id("wfDefaultEmailSenderAccount")).clear();
		driver.findElement(By.id("wfDefaultEmailSenderAccount")).sendKeys(username);
		driver.findElement(By.id("wfDefaultEmailSenderPassword")).clear();
		driver.findElement(By.id("wfDefaultEmailSenderPassword")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		
	
	}
	
	@DataProvider(name="Correspon")  
	public Object[][] Correspon(){
	   return new Object [][]{ 
	     { "2","2" }
	     
	   };
	}
	
	
	@Test(dataProvider = "Correspon",dependsOnMethods = { "systemssettingconfig" })
	public static void Correspondence(String customerid,String value) {
		driver.get("http://wv119/Utilibill24A/Customer/CusMain.aspx?rid="+customerid);
		driver.findElement(By.xpath("//*[@id=\"ISI_TabBar_wfCustomerPageTbCorrespondence_U\"]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"tdUser\"]")).click();
		Select a = new Select(driver.findElement(By.id("ddlUsers")));
		a.selectByValue(value);
		driver.findElement(By.id("btnEmailUser")).click();
		WebElement message= driver.findElement(By.xpath("//*[@id=\"wfStatus\"]"));
		message.getText();
		Assert.assertEquals(message.getText(), "Email Sent.");
		
	}
	
	
	@DataProvider(name="OnlineAcc")  
	public Object[][] OnlineAcc(){
	   return new Object [][]{ 
	     { "2","vdesai@ecinfosystems.com" }, 
	     {  "100","virald9@gmail.com"} 
	     
	   };
	}
	
	@Test(dataProvider = "OnlineAcc",dependsOnMethods = { "systemssettingconfig" })
	public static void OnlineAccount(String customerid,String password) {
		driver.findElement(By.xpath("//*[@id=\"ctl11_AppMenuBarn0\"]/table/tbody/tr/td/a/table/tbody/tr/td")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl11_AppMenuBarn10\"]/td/table/tbody/tr/td/a/table/tbody/tr/td")).click();		
		//driver.findElement(By.cssSelector("a[href = '/Utilibill24A/Customer/EUsersD.aspx?rid=']"+customerid)).click();
		driver.get("http://wv119/Utilibill24A/Customer/EUsersD.aspx?rid="+customerid);
		driver.findElement(By.id("wfPassword")).sendKeys(password);
		driver.findElement(By.id("btnEmailNewPassword")).click();
		
	}
	
	@DataProvider(name="invoice")  
	public Object[][] invoiceemail(){
	   return new Object [][]{ 
	     { "2", "vdesai@ecinfosystems.com" },
	     {"2", "virald9@gmail.com"}
	     
	   };
	}
	
	

	@Test(dataProvider = "invoice",dependsOnMethods = { "systemssettingconfig" })
	public static void Invoiceemails(String customerid,String emailid) {
		driver.get("http://wv119/Utilibill24A/Customer/CusMain.aspx?rid="+customerid);
		driver.findElement(By.xpath("//*[@id=\"ISI_TabBar_wfCustomerPageTbBilling_U\"]/img")).click();
		driver.findElement(By.id("gvGrid_ctl03_gvcName")).click();
		driver.findElement(By.id("wfBillingEmail")).sendKeys(emailid);
		driver.findElement(By.id("btnEmailUser")).click();
		
		
		
	}
	
	@Test(dependsOnMethods = { "systemssettingconfig" })
	public static void latenotice() {
	
		driver.findElement(By.xpath("//*[@id=\"ctl06_AppMenuBarn1\"]/table/tbody/tr/td/a/table/tbody/tr/td")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl06_AppMenuBarn24\"]/td/table/tbody/tr/td/a/table/tbody/tr/td")).click();
		
	
	}
	
	

	/*Combine two data providers
	@DataProvider(name="combine")
	public static Object[] concat(Object[] systemsettings, Object[] systemsettingsforgmail) {
        Object[] result = ArrayUtils.addAll(systemsettings, systemsettingsforgmail);
        return result;
	}*/
	
		
	/*@AfterMethod
	public static void after() {
		driver.quit();
	}*/
}
