package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class loginpages {

	

	private WebDriver driver;
	
	private By emailid = By.id("email");
	private By password = By.id("passwd");
	private By Singin = By.id("SubmitLogin");
	private By forgotlink = By.linkText("Forgot your password?");

	
	public  loginpages (WebDriver driver) {
		this.driver=driver;
	}
	public String getLoginPageTitle() {
	    return driver.getTitle();
	}
	public boolean isForgotPwdLinkExist() {
	    return driver.findElement(forgotlink).isDisplayed ();
}
	public void enterUserName(String username) {
	    driver.findElement (emailid).sendKeys (username);}
	public void enterPassword(String pwd) {
	    driver.findElement (password).sendKeys (pwd);
	}
	public void clickOnLogin() {
	    driver.findElement (Singin).click();
	}
	
	 public accountpage doLogin(String un, String pwd) {
		 System.out.println("login with:"+ un + "and"+ pwd);
		 driver.findElement (emailid). sendKeys (un);
		 driver.findElement (password).sendKeys (pwd);
		 driver.findElement(Singin).click();
		 return new accountpage(driver);

}}