package BaseTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.beust.jcommander.Parameter;

@RunWith(Parameterized.class)
public class WithJunit {
	
	String emailhost;
	String timeout;
	String username;
	String password;
	String emailhostforeci;
	String timeoutforeci;
	String usernameforeci;
	String passwordforeci;
  
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        	{"smtp.gmail.com","900000","Utilibilleci","Siberia@123"},{"ecimailsvr.domain.local","900000","Utilibillsupport","U^98iq"}  
           });
    }



    public WithJunit(String emailhost, String timeout, String username ,String password) {
        this.emailhost = emailhost;
        this.timeout = timeout;
        this.username = username;
        this.password = password;
    }



    
}