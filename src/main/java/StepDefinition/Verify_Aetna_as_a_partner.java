package StepDefinition;

import PageObject.Aetna;
import PageObject.Circles;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_Aetna_as_a_partner extends generic_function {
    Circles circle;
    Aetna aetna;
    @Given("Initiate browser")
    public void initiate_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            aetna=new Aetna(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("initiate_Browser");
        }
    }

    @When("Login  to MPH web")
    public void login_MPH_Web() throws IOException {
        try{
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPH_Web");
        }
    }

    @Then("Navigate to  the circles")
    public void navigate_Circles() throws IOException {
        try{
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button,3000);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("navigate_Circles");
        }
    }

    @And("Add Aetna as a partner")
    public void add_Aetna_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Aetna");
            circle.partner_search(record.get(0));
            click(aetna.aetnaLink);
            login_Partner(driver,record);

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_Aetna_Partner");
        }
    }

    @And("Verify Aetna is added as a partner")
    public void verify_Aetna_Added_Partner() throws IOException {
        try{
            browser_explicit_wait(aetna.aetnaTile_link,3000);
            Assert.assertTrue(aetna.aetnaTile_link.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_Aetna_Added_Partner");
        }
    }

    @And("Browser   is closed")
    public void browser_Closed() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Closed");
        }
    }
}
