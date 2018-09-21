package utilibillautomationpackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Moveoutresponse {

	public static WebDriver uploadfiles(WebDriver driver) throws FileNotFoundException {
	String mg=driver.findElement(By.xpath("//*[@id=\"common1\"]/tbody/tr/td/table/tbody/tr[3]/td")).getText();
		String[] word = mg.split(" ");
		String one= word[0];
		String two= word[1];
		String three= word[2];
		String four= word[3];
		String five= word[4];
		String six= word[5];
		String seven= word[6];
		String eight= word[7];
		String nine= word[8].substring(0, word[8].length()-1);
		String ten= word[9];
	
		System.out.println(nine);
		
	
	 
	File log= new File("C:\\Users\\vdesai\\Desktop\\FilesforTesting\\In_569_ERCOT_180625_81425_S990004.txt");
	String search = "0103180817323406";
	String replace = nine;

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
