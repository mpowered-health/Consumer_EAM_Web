package StepDefinition;

import PageObject.Circles;
import PageObject.VeteranAffairs;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_VeteranAffairs_as_a_partner extends generic_function {
    Circles circle;
    VeteranAffairs va;
    @Given("Open the browser")
    public void open_Browser() throws IOException {
        try {
            Browser_Launch(driver);
            circle=new Circles(driver);
            va=new VeteranAffairs(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser");
        }
    }

    @When("Login to the MPH web")
    public void login_MPHWeb() throws IOException {
        try{
            circle.Login();
    }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPHWeb");
        }
    }


    @Then("Navigate circle page")
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

    @And("Add VA as a partner")
    public void add_VA_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Veteran Affairs");
            circle.partner_search(record.get(0));
            click(va.VA_link);
            browser_explicit_wait(va.VA_IDme,3000);
            click(va.VA_IDme);
           login_Partner(driver,record);

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_VA_Partner");
        }
    }

    @And("Send OTP and click continue for VA")
    public void Send_OTP_click_continue_VA() throws IOException {
        try{
            click(va.VA_continue);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("Send_OTP_click_continue_VA");
        }
    }

    @And("Verify VA is added as a partner")
    public void verify_VA_Added_Partner() throws IOException {
        try{
            browser_explicit_wait(va.VATile_text,4000);
            Assert.assertTrue(va.VATile_text.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_VA_Added_Partner");
        }
    }

    @And("Browser  is closed")
    public void browser_Closed() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Closed");
        }
    }
}
