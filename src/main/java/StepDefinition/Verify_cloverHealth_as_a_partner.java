package StepDefinition;

import PageObject.Circles;
import PageObject.CloverHealth;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_cloverHealth_as_a_partner extends generic_function {
    Circles circle;
    CloverHealth cloverHealth;

    @Given("Open browser and access MPH")
    public void open_Browser_Access_MPH() throws IOException {
        try {
            Browser_Launch(driver);
            circle = new Circles(driver);
            cloverHealth = new CloverHealth(driver);
        }
        catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser_Access_MPH");
        }
    }

    @When("Login  MPH")
    public void login_MPH() throws IOException {
        try {
            circle.Login();
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPH");
        }
    }
    @Then("Navigate to circle page")
    public void navigate_Circle_Page() throws IOException {
        try {
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button,3000);
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("navigate_Circle_Page");
        }
    }

    @And("Add Clover Health as a partner")
    public void add_CloverHealth_Partner() throws IOException {
        try {
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Clover Health");
            circle.partner_search(record.get(0));
            click(cloverHealth.cloverHealthLink);
            login_Partner(driver,record);
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_CloverHealth_Partner");
        }
    }

    @And("Accept terms and conditions for Clover Health")
    public void accept_TermsAndConditions_CloverHealth() throws IOException {
        try {
            click(cloverHealth.cloverHealth_agree);
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("accept_TermsAndConditions_CloverHealth");
        }
    }

    @And("Verify Clover Health is added as a partner")
    public void verify_CloverHealth_Added_Partner() throws IOException {
        try {
            browser_explicit_wait(cloverHealth.cloverHealthTile_text,3000);
            Assert.assertTrue(cloverHealth.cloverHealthTile_text.isDisplayed());
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_CloverHealth_Added_Partner");
        }
    }

    @And("Browser Close")
    public void browser_Close() throws IOException {
        try {
            driver.close();
        } catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Close");
        }
    }
}
