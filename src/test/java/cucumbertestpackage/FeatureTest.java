package cucumbertestpackage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeatureTest {
	WebElement we;
	static WebDriver driver;
	String url = "http://www.practiceselenium.com/welcome.html";
	static Actions action;
	
	
	@Before
	public void init() {
		//system properties
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get(url);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {

		we = driver.findElement(
				By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
		we.click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws InterruptedException {
//		Thread.sleep(1000);
		we = driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1"));
		assertEquals("Menu",we.getText());
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		we = driver.findElement(
				By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
		we.click();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		WebElement we2 = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span"));
		assertEquals("Enter your billing information",we2.getText());
	}
	
	@After
	public void finalise() {
		driver.quit();
	}
}
