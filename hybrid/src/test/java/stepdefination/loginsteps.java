package stepdefination;



import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginpages;
import qa.factory.Driverfactory;

public class loginsteps {
	private static String title;
	
	private loginpages loginp = new loginpages(Driverfactory.getDriver());
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    Driverfactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginp.getLoginPageTitle();
		System.out.println("page title is :"+title); 
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	
		Assert.assertTrue(title.contains(string));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    Assert.assertTrue(loginp.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   loginp.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	  loginp.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginp.clickOnLogin();
	}

	
}
