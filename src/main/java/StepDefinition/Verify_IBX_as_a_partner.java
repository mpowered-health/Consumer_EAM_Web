package StepDefinition;

import PageObject.Circles;
import PageObject.IBX;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_IBX_as_a_partner extends generic_function {
    Circles circle;
    IBX ibx;
    @When("Login  MPH web")
    public void login_MPH_Web() throws IOException {
        try{
            Browser_Launch(driver);
            circle = new Circles(driver);
            ibx=new IBX(driver);
            browser_explicit_wait(circle.username, 6000);
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_MPH_Web");
        }

    }

    @Then("Navigate to  circles")
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

    @And("Add IBX as a partner")
    public void add_IBX_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Independence Blue Cross");
            circle.partner_search(record.get(0));
            click(ibx.IBX_link);
            click(ibx.ibxLogin);
            login_Partner(driver,record);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_IBX_Partner");
        }
    }



    @And("Verify IBX is added as a partner")
    public void verify_IBX_Added_Partner() throws IOException {
        try{
            browser_explicit_wait(ibx.IBXTile_text,3000);
            Assert.assertTrue(ibx.IBXTile_text.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_IBX_Added_Partner");
        }
    }

    @And("Browser  closed")
    public void browser_Closed() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Closed");
        }
    }
}
