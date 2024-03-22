package Cucumber.OrangeHRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	Read_From_Properties Obj = new Read_From_Properties();
	public Properties Prop_Resource = Obj.Read_From_Prop_Files("resource");
	public static String EmployeeName;
	public String Count,GetNumbersOnly;
	boolean User_Added = false;
	WebDriverWait wait;
	WebElement Element;
	
	public WebDriver driver;
	public int Users_Count_beforeAdd,Users_Count_AfterAdd=0;
	
	
	public void Press_Admin_Tab(){
    	driver = LoginPage.Return_Driver();
    	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("User_DDL"))));

		EmployeeName = driver.findElement(By.xpath(Prop_Resource.getProperty("User_DDL"))).getText().toString();
		driver.findElement(By.xpath(Prop_Resource.getProperty("Admin_Tab"))).click();
	}
	
	public void Get_UsersCount(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("UsersCount_Label"))));
  		
	Count =	driver.findElement(By.xpath(Prop_Resource.getProperty("UsersCount_Label"))).getText().toString();
	
	GetNumbersOnly = Count.replaceAll("[^0-9]", "");
	Users_Count_beforeAdd = Integer.valueOf(GetNumbersOnly.toString());
	}
	
	public void Press_Add_Button() {
		driver.findElement(By.xpath(Prop_Resource.getProperty("Add_Button"))).click();
	}
	
	public void Check_UsersCount(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("UsersCount_Label"))));

	Count =	driver.findElement(By.xpath(Prop_Resource.getProperty("UsersCount_Label"))).getText().toString();
	
	GetNumbersOnly = Count.replaceAll("[^0-9]", "");
	Users_Count_AfterAdd = Integer.valueOf(GetNumbersOnly.toString());
	
	User_Added = (Users_Count_AfterAdd > Users_Count_beforeAdd) ? true : false;
	assertTrue(User_Added);	
	}
	
	public void Search_for_User(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("User_Name_Text"))));

		
		driver.findElement(By.xpath(Prop_Resource.getProperty("User_Name_Text"))).sendKeys(AddUser.StoredUserName,Keys.ENTER);		
		}

     public void Delete_Selected_User(){
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("Delete_Button"))));

	driver.findElement(By.xpath(Prop_Resource.getProperty("Delete_Button"))).click();
	driver.findElement(By.xpath(Prop_Resource.getProperty("YesDelete_Option"))).click();
	}
     
     public void Check_User_Deleted(){
    		
 		driver.findElement(By.xpath(Prop_Resource.getProperty("User_Name_Text"))).sendKeys(AddUser.StoredUserName,Keys.ENTER);		
 		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  		Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop_Resource.getProperty("UsersCount_Label"))));

	Count =	driver.findElement(By.xpath(Prop_Resource.getProperty("UsersCount_Label"))).getText().toString();
	assertEquals("No Records Found", Count);

 		    		} 
}