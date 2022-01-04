package StepDefiniton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingIn {
	
	WebDriver driver = null;
// Common Things
	@Given("User is in the register page")
	public void user_is_in_the_register_page() {
		
		String ProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ProjectPath+"/src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.opencart.com/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();

	}

	@When("User does not fill any field")
	public void user_does_not_fill_any_field() throws InterruptedException {
		
		Thread.sleep(1000);
		
	}
	
	@When("^User fills (.*) (.*) (.*) (.*) (.*) (.*) with scenario description$")
	public void user_fills_Alessandro_Silva_alessandro_silva_oktana_com_with_scenario_description(String name, String  lastname, String telephone,String password,String confirmpass,String email) throws InterruptedException {
		driver.findElement(By.id("input-firstname")).sendKeys(name);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(confirmpass);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		Thread.sleep(3000);
	}
	
	@And("User Submits")
	public void user_Submits() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	}

	
// Scenario 1
	@Then("Error message detailing what mandatory fields are missing")
	public void error_message_detailing_what_mandatory_fields_are_missing() {
		driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).isDisplayed();
		driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).isDisplayed();
		driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).isDisplayed();
		driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).isDisplayed();
		driver.close();
		driver.quit();
	}

// Scenario 2
	
	@Then("^A (.*) detailing the warning$")
	public void a_E_Mail_Address_is_already_registered_detailing_the_warning(String message) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//*[contains(text(), '"+message+"')]"));
	   Thread.sleep(3000);
	   driver.close();
	   driver.quit();
	}

// Scenario Whitout
	
	@And("User doesnt check checking Privacy Policy box")
	public void user_doesnt_check_checking_Privacy_Policy_box() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
	}

}
