package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class accountpage {
private WebDriver driver;


private By accountsections= By.cssSelector("div#center_column span");

public accountpage (WebDriver driver){
	this.driver=driver;
}

public String getpagetitle() {
	return driver.getTitle();
}

public int getaccountsectioncount() {
	return driver.findElements(accountsections).size();
}

public List<String> getAccountsSectionsList() {
List<String> accountsList = new ArrayList ();
List<WebElement> accountsHeaderList = driver.findElements (accountsections);
for (WebElement e : accountsHeaderList) {
String text = e.getText();
System.out.println(text);
accountsList.add (text);}
return accountsList;


}}
