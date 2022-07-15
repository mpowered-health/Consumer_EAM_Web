package StepDefinition;

import PageObject.BCBS;
import PageObject.Circles;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_BCBS_As_Partner extends generic_function {
    Circles circle;
    BCBS bcbs;
    @Given("Open a browser")
    public void open_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            bcbs= new BCBS(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser");
        }
    }

    @When("Login to MPH with valid username and password")
    public void login_MPH_Valid_Username_Password() throws IOException {
        try{
            browser_explicit_wait(circle.username, 6000);
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPH_Valid_Username_Password");
        }
    }

    @Then("Navigate to the circles page")
    public void navigate_Circles_Page() throws IOException {
        try{
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button,3000);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("navigate_Circles_Page");
        }
    }
    @And("Add BCBS as a partner")
    public void add_BCBS_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("BCBS");
            circle.partner_search(record.get(0));
            click(bcbs.bcbs_link);
            browser_explicit_wait(bcbs.medicareAdvMember_Role,3000);
            click(bcbs.medicareAdvMember_Role);
            login_Partner(driver,record);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_BCBS_Partner");
        }
    }

    @And("Accept terms and conditions for BCBS")
    public void accept_Terms_Conditions_BCBS() throws IOException {
        try{
            browser_explicit_wait(bcbs.bcbs_Agree, 2000);
            click(bcbs.BCBS_TC_Agree);
            click(bcbs.bcbs_Agree);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("accept_Terms_Conditions_BCBS");
        }
    }

    @And("Verify BCBS is added as a partner")
    public void verify_BCBS_Added_Partner() throws IOException {
        try{
            Assert.assertTrue(bcbs.bcbs_TileText.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_BCBS_Added_Partner");
        }
    }

    @And("Browser close")
    public void browser_Close() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Close");
        }
    }

}
