package utilibillautomationpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Transactions extends LoginandQuit {

	@FindBy(css = "img[title='Customers - Transaction History']")
	WebElement transaction;
	
	
	public void meterreading() {
		
		driver.get("http://localhost/Utilibill24A/Customer/CusMain.aspx?rid=45893");
		transaction.click();
		
	}
}
