package stepDefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginToApplication
{
	WebDriver driver;
	@Given("enter the url")
	public void enter_the_url() {
	    driver=new ChromeDriver();
	   driver.get("http://localhost:8888");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@When("enter the username {string} and password {string}")
	public void enter_the_username_and_password(String Username, String Password) 
	{
	   driver.findElement(By.name("user_name")).sendKeys(Username);
	   driver.findElement(By.name("user_password")).sendKeys(Password);
	}
	@Then("click on login button")
	public void click_on_login_button() {
	   driver.findElement(By.id("submitButton")).click();
	}
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
	  String actTitle = driver.getTitle();
	if(actTitle.contains("Home"))
	{
		System.out.println("HomePage is displayed");
	}
	else
	{
		System.out.println("HomePage is not displayed");
	}
	
	}
	
	@Then("error message should be dispalyed")
	public void error_message_should_be_dispalyed() {
	   
		String expError = driver.findElement(By.xpath("//div[contains(text(),'You must specify a valid username and pass')]")).getText();
		
		if(expError.contains("You must specify a valid username and password."))
		{
			System.out.println("error message is displayed");
			
		}
		else
		{
			System.out.println("error message is not displayed");
		}
	}
	
	@When("^enter the username(.+) and PassWord(.+) and click on login btn.$")
	public void enter_the_username_admin_and_pass_word_admin(String username,String password) throws InterruptedException
	{
		String USERNAME=username.toString().trim();
		String PASSWORD = password.toString().trim();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		
		
	}
	
	@When("enter the username and password click on login btn")
	public void enter_the_username_and_password_click_on_login_btn(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		String USERNAME = data.get(0).get(0);
		String PASSWORD = data.get(0).get(1);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
}
