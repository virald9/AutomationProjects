package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginandquit {
	
	static WebDriver driver;
	
	public static WebDriver before() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vdesai\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://wv119/Utilibill24A/Logon.aspx");
		driver.findElement(By.id("wfUserid")).sendKeys("eci569");
		driver.findElement(By.id("wfPassword")).sendKeys("siberia");
		driver.findElement(By.id("btnLogon")).click();
		return driver;
	}

}
