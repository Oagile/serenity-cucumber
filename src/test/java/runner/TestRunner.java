package runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import ui.LoginPage;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions
            (
                features = {"src/test/java/features"},
                glue = "esseex.glue",
                tags = {"@SmokeTest"}
            )
public class TestRunner {

}


