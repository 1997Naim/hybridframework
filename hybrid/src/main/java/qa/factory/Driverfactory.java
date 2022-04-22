package qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	public WebDriver driver;
 public static ThreadLocal <WebDriver> tlDriver= new ThreadLocal<>();
 /**
  * This method is used to initialize the thradlocal driver on the basis of given browser
 * @param browser
  * @return this will return tlDriver;
  * */
  
 public WebDriver init_driver(String Browser) {
	 System.out.println("browser value is :"+Browser);
	 if(Browser.equals("Chrome")) {
		 WebDriverManager.chromedriver().setup();
		 tlDriver.set(new ChromeDriver());
		  }
	 else if(Browser.equals("Edge")) {
		 WebDriverManager.edgedriver().setup();
		 tlDriver.set(new EdgeDriver());
		  }
	 else if(Browser.equals("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
		 tlDriver.set(new FirefoxDriver());
		  }
	 else {
		 System.out.println("please the correct browser value"+Browser);
	 }
getDriver().manage().deleteAllCookies();
getDriver().manage().window().maximize();
return getDriver();
 }
 /**
 * this is used to get the driver with ThreadLocal
 * @return
  */
 
public static synchronized WebDriver getDriver() {
	return tlDriver.get();
	 
 }
 
 

}
