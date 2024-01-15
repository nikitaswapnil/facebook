package StepDefinition;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseLayer.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterPage extends BaseClass	 {
	

	@Given("user open {string} browser")
	public void user_open_browser(String string) {
		
		
		driver.get("https://www.facebook.com/signup");
	}

	@Given("user is on register page")
	public void user_is_on_register_page() {
		String title = driver.getTitle();
		boolean a = title.contains("Facebook");
		System.out.println(a);

	}

	@When("user enter valid {string},{string},{string},{string},")
	public void user_enter_valid(String fname, String lname, String userName, String password) {
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("reg_email__")).sendKeys(userName);
		driver.findElement(By.name("reg_passwd__")).sendKeys(password);
	}

	

	@When("user select {string},{string},{string} and select gender as {string}")
	public void user_select_and_select_gender_as(String date, String month, String year, String gender) {
		WebElement Date = driver.findElement(By.name("birthday_day"));
		Select sel = new Select(Date);
		sel.selectByVisibleText(date);

		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select sel2 = new Select(Month);
		sel2.selectByVisibleText(month);

		WebElement Year = driver.findElement(By.name("birthday_year"));
		Select sel3 = new Select(Year);
		sel3.selectByVisibleText(year);

		List<WebElement> ls = driver.findElements(By.xpath("//label[@class='_58mt']"));
		for (WebElement abc : ls) {
			String a = abc.getText();
			if (a.equalsIgnoreCase(gender)) {
				abc.click();
			}

		}
	}
	
	@AfterAll
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(5000);
	}
}
