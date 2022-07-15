package StepDefinition;

import PageObject.Circles;
import PageObject.ScanHealth;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class Verify_ScanHealth_as_a_partner extends generic_function {

    Circles circle;
    ScanHealth scanHealth;
    @Given("Open browser with  appropriate browser")
    public void open_Browser_Appropriate_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            scanHealth=new ScanHealth(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser_Appropriate_Browser");
        }
    }

    @When("Login MPH to web")
    public void login_MPH_Web() throws IOException {
        try{
            browser_explicit_wait(circle.username, 6000);
            circle.Login(); browser_explicit_wait(circle.username, 6000);
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPH_Web");
        }
    }

    @Then("Navigate to  circle")
    public void navigate_Circle() throws IOException {
        try{
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button,3000);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("navigate_Circle");
        }
    }

    @And("Add Scan Health as a partner")
    public void add_ScanHealth_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Scan Health");
            circle.partner_search(record.get(0));
            click(scanHealth.Scanhealth_link);
            login_Partner(driver,record);

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_ScanHealth_Partner");
        }
    }

    @And("Verify Scan Health is added as a partner")
    public void verify_ScanHealth_Added_Partner() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_ScanHealth_Added_Partner");
        }
    }

    @And("Close  the browser")
    public void close_Browser() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("close_Browser");
        }
    }
}
