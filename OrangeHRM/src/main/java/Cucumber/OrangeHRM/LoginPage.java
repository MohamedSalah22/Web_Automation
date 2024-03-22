package Cucumber.OrangeHRM;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public Properties Prop_Config,Prop_Resource = new Properties();
	 static WebDriver driver;
	Read_From_Properties Obj = new Read_From_Properties();
	WebDriverWait wait;
	WebElement Element;
	
	
	public void lanuch_Brower()
	{
 		Prop_Config = Obj.Read_From_Prop_Files("config");
		Prop_Resource = Obj.Read_From_Prop_Files("resource");
		System.setProperty("webdrive.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\java\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(Prop_Config.getProperty("url"));
	}
	
	public void Navigate_to_URL()
	{
		driver.navigate().to(Prop_Config.getProperty("url"));
	}
	
	public void Enter_Cred() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  		 Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("User_Name_Text"))));

		 driver.findElement(By.xpath(Prop_Resource.getProperty("User_Name_Text"))).sendKeys(Prop_Config.getProperty("username"));
		 driver.findElement(By.xpath(Prop_Resource.getProperty("Password_Text"))).sendKeys(Prop_Config.getProperty("password"));
	}
	
	public void Press_Login() {
		driver.findElement(By.xpath(Prop_Resource.getProperty("Login_Button"))).click();
	}
	
	public static WebDriver Return_Driver() {
		return driver;
	}

}
