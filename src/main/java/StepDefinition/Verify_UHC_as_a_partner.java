package StepDefinition;


import PageObject.Circles;
import PageObject.UHC;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class Verify_UHC_as_a_partner extends generic_function {

    Circles circle; UHC uhc;
    @Given("Open browser")
    public void open_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            uhc=new UHC(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser");
        }
    }

    @When("Login to MPH")
    public void login_MPH() throws IOException {
        try{
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPH");
        }
    }

    @Then("Navigate to the circle page")
    public void navigate_Circle_Page() throws IOException {
        try{
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button,3000);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("navigate_Circle_Page");
        }
    }

    @And("Add UHC as a partner")
    public void add_UHC_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("United Health Care");
            circle.partner_search(record.get(0));
            click(uhc.uhc_link);
            login_Partner(driver,record);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_UHC_Partner");
        }
    }

    @And("Accept terms and conditions for UHC")
    public void accept_TermsAndConditions_UHC() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("accept_TermsAndConditions_UHC");
        }
    }

    @And("Verify UHC is added as a partner")
    public void verify_UHC_Added_Partner() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_UHC_Added_Partner");
        }
    }

    @And("Browser is close")
    public void browser_Close() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Close");
        }
    }
}
