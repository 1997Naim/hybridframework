package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utility.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.factory.Driverfactory;

public class hooks {
	
	private Driverfactory driverfactory;
	private WebDriver driver;
	private configReader configReader;
	Properties prop;

@Before(order=0)
public void getproperty() {
	configReader = new configReader();
	prop=configReader.init_prop();
	
}
@Before(order=1)
public void lunchbrowser() {
	String browsername= prop.getProperty("Browser");
	driverfactory = new Driverfactory();
    driver=driverfactory.init_driver(browsername);
    }
@After(order=0)
public void quitebrowser() {
	driver.quit();
}

@After (order=1)
public void teardown(Scenario scenario) {
	if(scenario.isFailed()) {
		String screenshot = scenario.getName().replaceAll("", "_");
		byte [] sourchpath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourchpath, "image/png", screenshot);
	}
}




}
