package Web_Automation.IT_Work_Education;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	public static Properties prop = new Properties();
	static WebDriver driver = null;
	
	public static void lanuch_Brower() throws IOException
	{
		prop= Read_From_Properties.Read_config_File();
		
		System.setProperty("webdrive.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\java\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
		
	}
	
	public static void Navigate_to_URL() throws IOException
	{
		driver.navigate().to(prop.getProperty("url"));
	}
	
	
	public static void Enter_Cred() {
		 driver.findElement(By.id("Email")).sendKeys(prop.getProperty("username"));
		 driver.findElement(By.id("inputPassword")).sendKeys(prop.getProperty("password"));
	}
	
	public static void Press_Login() throws IOException {
		driver.findElement(By.id("btnLogin")).click();
	}
	public static WebDriver Return_Driver() {
		return driver;
	}

}
