package utilibillautomationpackage;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UtilibillPageFactory extends LoginandQuit  {

	
	
	@Test(priority=1,groups = { "dnp/rnp" })
	public void action() {
		DNPRNP_nonpayment_report ac = PageFactory.initElements(LoginandQuit.driver, DNPRNP_nonpayment_report.class);
		ac.disconnectreconnect();
		
	}
	
	@Test(priority=2,groups = { "dnp/rnp" })
	public void warningcheckbox() {
		DNPRNP_nonpayment_report ac = PageFactory.initElements(LoginandQuit.driver, DNPRNP_nonpayment_report.class);
		ac.warningcheckbox();
	}
	
	@Test(priority=3,groups = { "dnp/rnp" })
	public void calenderprofilefordnprnp() throws InterruptedException {
		CalenderProfile cp = PageFactory.initElements(LoginandQuit.driver, CalenderProfile.class);
		cp.calenderprofileforone();
		
	
	}
	
	//ToDO : find the text using xpath and check the corresponding checkbox
	@Test(priority=4,groups = { "dnp/rnp" })
	public void forlatenotice() throws InterruptedException {
		PastDueNotice_report ps = PageFactory.initElements(LoginandQuit.driver, PastDueNotice_report.class);
		ps.notice();
		
	
	}
	
	@Test(dependsOnMethods= {"forlatenotice"},priority=5,groups = { "dnp/rnp" })
	public void reportforcalenderprofile() {
		DNPRNP_nonpayment_report ac = PageFactory.initElements(LoginandQuit.driver, DNPRNP_nonpayment_report.class);
		ac.nonpayment_calenderprofile();
		
	}
		
		
	
	@Test(groups = { "movein_moveout" },priority=6)
	public void TransferofServicepage()  {
	TransferofService t = PageFactory.initElements(LoginandQuit.driver, TransferofService.class);
	try {
		t.MoveOut("36997","1008901024900320850109gt","09/04/2018","09/04/2018");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		t.copyFileUsingChannel("C:\\Users\\vdesai\\Desktop\\3668_files\\In_569_ERCOT_180531_81425_F990001.txt","C:\\UtilibillData\\V24\\Inbound\\In_569_ERCOT_180531_81425_F990001.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		t.copyFileUsingChannel("C:\\Users\\vdesai\\Desktop\\3668_files\\In_569_ERCOT_180406_81405_F990006.txt","C:\\UtilibillData\\V24\\Inbound\\In_569_ERCOT_180406_81405_F990006.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	//TC-02 - Contract Expired should show message
	@Test(groups = { "movein_moveout" },priority=7)
	public void contractexpirationpage()  {
		ContractExpired con = PageFactory.initElements(LoginandQuit.driver, ContractExpired.class);
		
			try {
				con.drop("47762");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
	}
	
	//TC-03 DroppedAccount should show message
	@Test(groups = { "movein_moveout" },priority=8)
	public void droppedaccountpage()  {
		DroppedAccount da = PageFactory.initElements(LoginandQuit.driver, DroppedAccount.class);
	
		try {
			da.drop("32363");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}
	
	//TC-04 Move out date should be blanked to show enrollment link 
	@Test(groups = { "movein_moveout" },priority=9)
	public void Moveoutwithoutdatepage()  {
		Moveoutwithoutdate mv = PageFactory.initElements(LoginandQuit.driver, Moveoutwithoutdate.class);
	
			try {
				mv.MoveOut("36997","1008901024900320850109gtvnt","09/04/2018","0.1", "12304569988888", "test", "08/16/2018");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
	}
	
	@Test(groups = { "billing" },enabled= false)
	public void transaction() {
		Transactions t = PageFactory.initElements(LoginandQuit.driver, Transactions.class);
		t.meterreading();
	}
	
	@Test(groups = { "billing" })
	public void meterpages() {
		Meters m = PageFactory.initElements(LoginandQuit.driver, Meters.class);
		m.meterpage("1");

	}
	
}
	
	
