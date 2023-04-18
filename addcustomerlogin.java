package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class addcustomerlogin 
{
	public static WebDriver ldriver;
	public addcustomerlogin(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	By customersmenu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By customers=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By Addnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By email=By.xpath("//*[@id=\"Email\"]");
	By password=By.xpath("//*[@id=\"Password\"]");
	
	By customerroles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div"); 
	
	
	By Administrators=By.xpath("//li[contains(text(),'Administrators')]");
	//By Forummoderators=By.xpath("//li[contains(text(),'Forummoderators')]");
	By Guests=By.xpath("//li[contains(text(),'Guests')]");
	By Registered=By.xpath("//li[contains(text(),'Registered')]");
	By Vendors=By.xpath("//*[@id=\"VendorId\"]"); 
	
	By F_name=By.xpath("//*[@id=\"FirstName\"]");
	By L_name=By.xpath("//*[@id=\"LastName\"]");
	By MaleGender=By.id("Gender_Male");
	By FemaleGender=By.id("Gender_Female");
	By Dob=By.id("DateOfBirth");
	By save=By.name("save");
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void customers() {
		ldriver.findElement(customersmenu).click();
	}
	
	public void customer() {
		ldriver.findElement(customers).click();
	}
	public void add() {
		ldriver.findElement(Addnew).click();	
		}
	public void email(String mail) {
		ldriver.findElement(email).sendKeys(mail);
	}
	public void setpwd(String pwd) {
		ldriver.findElement(password).sendKeys(pwd);
	}
		
		public void setcustomerroles(String role)	throws InterruptedException {
		{
			if(!role.equals("Vendors"))
			{
				
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
			}
			
			ldriver.findElement(customerroles).click();
						
			WebElement listitem;
			
			Thread.sleep(3000);
						
			if(role.equals("Administrators"))
			{
				listitem=ldriver.findElement(Administrators); 
			}
			else if(role.equals("Guests"))
			{
				listitem=ldriver.findElement(Guests);
			}
			else if(role.equals("Registered"))
			{
				listitem=ldriver.findElement(Registered);
			}
			else
			{
				listitem=ldriver.findElement(Guests);
			}
			
						
			//listitem.click();
			//Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
			
		}
		}
		public void setGender(String gender)
		{
			if(gender.equals("Male"))
			{
				ldriver.findElement(MaleGender).click();
			}
			else if(gender.equals("Female"))
			{
				ldriver.findElement(FemaleGender).click();
			}
			else
			{
				ldriver.findElement(MaleGender).click();//Default
			}
		}
			public void firstname(String fname) {
				ldriver.findElement(F_name).sendKeys(fname);
			}
			public void lastname(String lastname) {
				ldriver.findElement(L_name).sendKeys(lastname);
			}
			public void dob(String dob) {
				ldriver.findElement(Dob).sendKeys(dob);
			}
			public void save() {
				ldriver.findElement(save).click();
			}
	}

