package utilibillautomationpackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Moveinresponse {

	public static WebDriver uploadfiles(WebDriver driver) throws FileNotFoundException {
	String mg=driver.findElement(By.xpath("//*[@id=\"common1\"]/tbody/tr/td/table/tbody/tr[2]/td")).getText();
	/*Scanner sc=new Scanner (System.in);
	mg=sc.nextLine();
	while(mg!=null)*/
		String[] word = mg.split(" ");
		String one= word[0];
		String two= word[1];
		String three= word[2];
		String four= word[3];
		String five= word[4];
		String six= word[5].substring(1, word[5].length()-1);
		
		System.out.println(six);
		
	
	 
	File log= new File("C:\\Users\\vdesai\\Desktop\\FilesforTesting\\In_569_ERCOT_180626_81405_P990001.txt");
	String search = "0104180817323405";
	String replace = six;

	try{
	    FileReader fr = new FileReader(log);
	    String s;
	    String totalStr = "";
	    try (BufferedReader br = new BufferedReader(fr)) {

	        while ((s = br.readLine()) != null) {
	            totalStr = totalStr +  s + "\n";
	        }
	        totalStr = totalStr.replaceAll(search, replace);
	        FileWriter fw = new FileWriter(log);
	    fw.write(totalStr);
	    fw.close();
	    }
	}catch(Exception e){
	    e.printStackTrace();
	
	}
	return driver;
}
}
