package Web_Automation.IT_Work_Education;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_From_Properties {

	
	public static Properties prop = new Properties();
	static File file;
	
	public static Properties Read_config_File() throws IOException
	{
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Web_Automation\\IT_Work_Education\\properties\\config.properties");
		FileInputStream new_file = new FileInputStream(file);
		prop.load(new_file);
		
		return prop;
		
	}
	
	public static Properties Read_Resource_File() throws IOException
	{
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Web_Automation\\IT_Work_Education\\properties\\Resources.properties");
		FileInputStream new_file = new FileInputStream(file);
		prop.load(new_file);
		
		return prop;
		
	}
	
}
