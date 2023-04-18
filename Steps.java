package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.addcustomerlogin;

public class Steps extends BaseClass {
	
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		//System.setProperty("Webdriver.firefox.driver", System.getProperty("user")+"//Drivers/Firefox Installer.exe");
		   // driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		    lp=new LoginPage(driver);
	}
	@When("User opens URL {string}")
	public void user_opens_URL_admin_demo_nopcommerce_com_login(String url) {
		driver.get(url);
	    
	}
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		lp.clickLogin();
	  
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
	  if(driver.getPageSource().contains("Login was unsuccessful.")) {
		  driver.close();
		  Assert.assertTrue(false);
	  }else {
		  Assert.assertEquals(title, driver.getTitle());
	  }
	}

	//@When("User click on Logout link")
	//public void user_click_on_Logout_link() throws InterruptedException {
	  // lp.clickLogout();
	   //Thread.sleep(3000);
	//}

//	@Then("close browser")
//	public void close_browser() {
//		driver.close();	   
	
//adding new customer
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		add=new addcustomerlogin(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",add.getPageTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() {
	   add.customers();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() {
	  add.customer();
	}

	@When("Click on Add new button")
	public void click_on_Add_new_button() {
	    add.add();	}

	@Then("user can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", add.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   add.firstname("Tarun");
	   add.lastname("k");
	   add.setcustomerroles("Vendor");
	   add.dob("01/01/01");
	   add.setGender("Male");
	   add.email("tk@gmail.com");
	   add.setpwd("123@tk");
	}

	@When("click on save button")
	public void click_on_save_button() {
	    add.save();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
		}
	@Then("close browser")
	public void close_browser() {
		driver.close();	   
	}
	
}