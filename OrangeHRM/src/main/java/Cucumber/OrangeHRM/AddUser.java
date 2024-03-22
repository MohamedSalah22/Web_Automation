package Cucumber.OrangeHRM;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser {

	Read_From_Properties Obj = new Read_From_Properties();
	public Properties Prop_Resource = Obj.Read_From_Prop_Files("resource");
	public WebDriver driver;
	
	public String Random_Num_User = String.valueOf(Math.random());
	public String Random_Num_Pass = String.valueOf(Math.random());
    public static String StoredUserName,StoredPassword;
    String Emp_Name;
    WebDriverWait wait;
	WebElement Element;
     
     public void Enter_Manadotry_Info(){
 		
    	 driver = LoginPage.Return_Driver();
    	 Emp_Name = AdminPage.EmployeeName;
    	 
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
   		
 		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("User_Role_DDL"))));

    	 
    	driver.findElement(By.xpath(Prop_Resource.getProperty("User_Role_DDL"))).click();
  		driver.findElement(By.xpath(Prop_Resource.getProperty("Select_Role"))).click();
    	
  		driver.findElement(By.xpath(Prop_Resource.getProperty("Employee_Name_Text"))).sendKeys(Emp_Name,Keys.ENTER);
  		
  		
  		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  		
  		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@role,'option')][contains(.,'"+Emp_Name.substring(0, 2)+"')]")));
  		
  		driver.findElement(By.xpath("//div[contains(@role,'option')][contains(.,'"+Emp_Name.substring(0, 2)+"')]")).click();
  		
  		driver.findElement(By.xpath(Prop_Resource.getProperty("Status_DDL"))).click();
  		driver.findElement(By.xpath(Prop_Resource.getProperty("Select_Status"))).click();
 		
  		StoredUserName = Prop_Resource.getProperty("User_Name")+ Random_Num_User;
 		driver.findElement(By.xpath(Prop_Resource.getProperty("User_Name_Text"))).sendKeys(StoredUserName);
 		
 		StoredPassword = Prop_Resource.getProperty("Password")+ Random_Num_Pass;
 		driver.findElement(By.xpath(Prop_Resource.getProperty("Password_Text"))).sendKeys(StoredPassword);
 		
 		driver.findElement(By.xpath(Prop_Resource.getProperty("Confirm_Password_Text"))).sendKeys(StoredPassword);
 	}
     
     public void Press_Save_button() {
    	 driver.findElement(By.xpath(Prop_Resource.getProperty("Save_button"))).click();
 	}
	
}
