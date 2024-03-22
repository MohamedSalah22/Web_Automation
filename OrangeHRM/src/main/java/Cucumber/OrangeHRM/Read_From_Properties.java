package Cucumber.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_From_Properties {
	
	public Properties prop = new Properties();
    File file;
	
	public Properties Read_From_Prop_Files(String fileName) 
	{
		try {
		if (fileName.toLowerCase()=="config")
		{
			file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\config.properties");
		}
		
		else if(fileName.toLowerCase()=="resource")
		{
			file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\Resources.properties");
		}
			FileInputStream new_file = new FileInputStream(file);
			prop.load(new_file);
			
			return prop;
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage() +"In Read_From_Prop_Files Method");
		}
		return null;	
	}
}
