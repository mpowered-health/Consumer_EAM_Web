package RunnerFile;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(
            plugin = {"pretty","html:target/site/serenity/Report.html"},
            features = {"src/main/resources/Features/08_Your_profile_negative_scenarios.feature"},
            glue= {"Stepdefinition"})

    public class Runner {
}
