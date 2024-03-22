package Steps;

import org.openqa.selenium.WebDriver;

import Cucumber.OrangeHRM.AddUser;
import Cucumber.OrangeHRM.AdminPage;
import Cucumber.OrangeHRM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Manage_User {
	
WebDriver driver;
LoginPage Obj_Login = new LoginPage();
AdminPage Obj_Admin = new AdminPage();
AddUser Obj_Add_User= new AddUser();

		
	@Before
	public void Lanuch_Broswer() {
			Obj_Login.lanuch_Brower();
	}
	
	@Given("I Navigate to URL")
	public void i_navigate_to_url() {
		Obj_Login.Navigate_to_URL();
	}

	@When("I Enter Valid user Name and Password")
	public void i_enter_valid_user_name_and_password() {
		Obj_Login.Enter_Cred();
	}

	@When("I Click on Login button")
	public void i_click_on_login_button() {
		Obj_Login.Press_Login();
	}
	
	@When("I Click on Admin Tab")
	public void i_click_on_admin_tab() {
		Obj_Admin.Press_Admin_Tab();
	}

	@When("I Get Count of Records")
	public void i_get_count_of_records() {
		Obj_Admin.Get_UsersCount();
	}

	@When("I Click on Add button")
	public void i_click_on_add_button() {
		Obj_Admin.Press_Add_Button();
	}

	@When("I Fill Mandatory Information")
	public void i_fill_mandatory_information() {
		Obj_Add_User.Enter_Manadotry_Info();
	}

	@When("I Back to Users Grid")
	public void i_back_to_users_grid() {
		Obj_Add_User.Press_Save_button();
	}

	@Then("Verify Users added Successfully")
	public void verify_users_added_successfully() {
		Obj_Admin.Check_UsersCount();
	}

	@When("I Search For User")
	public void i_search_for_user() {
		Obj_Admin.Search_for_User();
	}

	@When("I Click on Delete")
	public void i_click_on_delete() {
		Obj_Admin.Delete_Selected_User();
	}

	@Then("Verify Number of Users decreased Successfully")
	public void verify_number_of_users_decreased_successfully() {
		
		Obj_Admin.Check_User_Deleted();
	}
	@After
	public void Close_Broswer() {
		driver = LoginPage.Return_Driver();
		driver.close();
		driver.quit();
	}

}
