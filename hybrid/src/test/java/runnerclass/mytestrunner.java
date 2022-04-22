package runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
       features ={"src/test/java/featurefiles"},
       glue = {"stepdefination", "apphooks"},
       plugin = {"pretty"})
                

public class mytestrunner {

}
