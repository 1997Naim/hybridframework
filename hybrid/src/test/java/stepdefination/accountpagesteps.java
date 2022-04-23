package stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.accountpage;
import pages.loginpages;
import qa.factory.Driverfactory;

public class accountpagesteps {
	private loginpages loginp = new loginpages(Driverfactory.getDriver());
	private accountpage accountpage;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		 List<Map<String, String>> credList = dataTable.asMaps ();
		 String userName =  credList.get(0).get("username");
		 String password = credList.get(0).get("password");
		 
		 Driverfactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		 accountpage= loginp.doLogin(userName, password);
		 
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	   String title= accountpage.getpagetitle();
	   System.out.println("this is my page title"+title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		 List<String> expAccountSectionsList = sectionsTable.asList();
		 System.out.println("Expected accounts section list: " + expAccountSectionsList);
		 List<String> actualAccountSectionsList = accountpage.getAccountsSectionsList();
		 System.out.println("Actual accounts section list: "+ actualAccountSectionsList);
		 Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedsectioncount) {
	  Assert.assertTrue(accountpage.getaccountsectioncount() == expectedsectioncount); 
	}

}
