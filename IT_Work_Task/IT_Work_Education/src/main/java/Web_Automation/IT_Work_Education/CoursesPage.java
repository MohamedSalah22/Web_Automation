package Web_Automation.IT_Work_Education;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CoursesPage {
	
	static WebDriver driver = LoginPage.Return_Driver();
	public static Properties prop = new Properties();
	   
     public static String Random_Value = String.valueOf(Math.random());
     public static String StoredName = null;

	
	public static void press_Courses_Tab() throws IOException {
		prop= Read_From_Properties.Read_Resource_File();
		driver.findElement(By.id(prop.getProperty("collaspe_menu"))).click();
		driver.findElement(By.id(prop.getProperty("Courses_Tab"))).click();
	}
	
	public static void press_Create_New_Course() {
		driver.findElement(By.id(prop.getProperty("Add_Course_Button"))).click();
	}
	
	public static void Enter_Manadotry_Info() throws IOException {
		
		StoredName = prop.getProperty("courseName")+ Random_Value;
		driver.findElement(By.id(prop.getProperty("Course_Name_Text"))).sendKeys(StoredName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		
		
		driver.findElement(By.xpath(prop.getProperty("Select_Range_Radio"))).click();
		driver.findElement(By.xpath(prop.getProperty("Course_Teacher_DDL"))).click();
		driver.findElement(By.xpath(prop.getProperty("Select_Teacher"))).click();
		
		
		//To scroll down the web page at the bottom of the page.
		         		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		 driver.findElement(By.id(prop.getProperty("Create_Course_Button"))).click();
	}
	
	public static void Back_to_Courses() {
		driver.findElement(By.id(prop.getProperty("Courses_Tab"))).click();
	}
	
	public static void Course_Added() {
		driver.findElement(By.id(prop.getProperty("Search_For_Course"))).sendKeys(StoredName,Keys.ENTER);
   
		Select se = new Select(driver.findElement(By.id(prop.getProperty("Sort_By_DDL"))));
		
     	se.selectByIndex(3);
			
     	assertEquals(StoredName, driver.findElement(By.id(prop.getProperty("Returned_Course"))).getText());
		}
}
