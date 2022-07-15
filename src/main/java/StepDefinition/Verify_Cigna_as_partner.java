package StepDefinition;

import PageObject.Cigna;
import PageObject.Circles;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_Cigna_as_partner extends generic_function {
    Circles circle;
    Cigna cigna;
    @Given("Initiate the browser")
    public void initiate_Browser() throws IOException {
       try{
           Browser_Launch(driver);
           circle = new Circles(driver);
           browser_explicit_wait(circle.username, 6000);
           cigna=new Cigna(driver);
           circle.Login();
       }catch (Exception e){
           e.printStackTrace();
           takeScreenShot("initiate_Browser");
       }
    }

    @Then("Goto Circles page")
    public void goto_Circles_Page() throws IOException {
        try{
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
            browser_explicit_wait(circle.addPartner_button,3000);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("goto_Circles_Page");
        }
    }

    @And("add cigna as a partner")
    public void add_Cigna_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Cigna");
            circle.partner_search(record.get(0));
            click(cigna.cigna_link);
            login_Partner(driver,record);
            click(cigna.cignaTermsConditions);
            click(cigna.allowData);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_Cigna_Partner");
        }
    }

    @And("Verify cigna as a partner")
    public void verify_Cigna_Partner() throws IOException {
        try{
            browser_explicit_wait(cigna.partner_addedLogo,4000);
            Assert.assertTrue(cigna.cignaLogo.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_Cigna_Partner");
        }
    }

    @And("Close browser")
    public void close_Browser() throws IOException {
        try{
            driver.close();
        }catch(Exception e){
            e.printStackTrace();
            takeScreenShot("close_Browser");
        }
    }
}
