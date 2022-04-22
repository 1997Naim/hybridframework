package runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	       features ={"src/test/java/featurefiles"},
	       glue = {"stepdefination", "apphooks"},
	       plugin = {"pretty"})

public class testngrunner extends AbstractTestNGCucumberTests{

}
