package Web_Automation.IT_Work_Education.Steps;

import java.io.IOException;
import Web_Automation.IT_Work_Education.*;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCourseSteps {

	WebDriver driver = null;
	
	
	@Before
	public void Lanuch_Broswer() throws IOException {
			LoginPage.lanuch_Brower();
	}
	
	@Given("I Navigate to URL")
	public void broswer_is_open() throws IOException {
	   LoginPage.Navigate_to_URL();
	}

	@When("I Enter Valid user Name and Password")
	public void i_enter_valid_user_name_and_password() {
	   LoginPage.Enter_Cred();
	}

	@When("I Click on Login button")
	public void i_click_on_login_button() throws IOException {
	    LoginPage.Press_Login();
	}
	
	@When("I Click on Courses Icon")
	public void i_click_on_courses_icon() throws IOException {
		CoursesPage.press_Courses_Tab();
	    
	}
	@When("I Click on Add Course button")
	public void i_click_on_add_course_button() {
		CoursesPage.press_Create_New_Course();
	    
	}
	@When("I Fill Mandatory Information")
	public void i_fill_mandatory_information() throws IOException {
		CoursesPage.Enter_Manadotry_Info();
	}
	@When("I Back to Courses Grid")
	public void i_back_to_courses_grid() {
		CoursesPage.Back_to_Courses();
	}
	@Then("Verify Course Created Successfully")
	public void verify_course_created_successfully() {
		CoursesPage.Course_Added();
	}

	@After
	public void Close_Broswer() throws IOException {
	  driver = LoginPage.Return_Driver();
		driver.close();
		driver.quit();
		
	}
}
