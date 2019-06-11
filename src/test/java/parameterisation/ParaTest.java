package parameterisation;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParaTest {
	WebElement we;
	static WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@After
	public void finialised() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1){
		driver.get(arg1);
	    

	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws InterruptedException{
		we = driver.findElement(By.name("q"));
		we.sendKeys(arg1);
		Thread.sleep(200);
		we.sendKeys(Keys.ENTER);
		
		Thread.sleep(200);
		we = driver.findElement(By.name("q"));
		assertEquals(arg1.toString(), we.getAttribute("value"));
		
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws InterruptedException{
		Thread.sleep(3000);
		
	
	}

}
