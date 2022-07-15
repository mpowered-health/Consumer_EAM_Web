package StepDefinition;

import PageObject.Cigna;
import PageObject.Circles;
import PageObject.Humana;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_Humana_As_Partner extends generic_function {
    Circles circle; Humana humana;
    @Given("Browser with MPH application open")
    public void browser_MPH_Application_Open() throws IOException {
        try {
            Browser_Launch(driver);
            circle = new Circles(driver);
            browser_explicit_wait(circle.username, 6000);
            humana = new Humana(driver);
            circle.Login();
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button, 3000);
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_MPH_Application_Open");
        }
    }

    @When("Added Humana as partner")
    public void added_Humana_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Humana");
            circle.partner_search(record.get(0));
            click(humana.humana_link);
            login_Partner(driver,record);
            click(humana.allow_humana);

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("added_Humana_Partner");
        }
    }

    @Then("Verify Humana is added as a partner")
    public void verify_Humana_Added_Partner() throws IOException {
        try{
            browser_explicit_wait(humana.humanaTile_text, 4000);
            Assert.assertTrue(humana.humanaTile_text.getText().contains(humana.humanaText_Added));
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_Humana_Added_Partner");
        }
    }

    @And("Close the browser")
    public void close_Browser() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("close_Browser");
        }
    }
}
