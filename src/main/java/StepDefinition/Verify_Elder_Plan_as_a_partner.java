package StepDefinition;

import PageObject.Circles;
import PageObject.ElderPlan;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.IOException;

public class Verify_Elder_Plan_as_a_partner extends generic_function {
    Circles circle;
    ElderPlan elderPlan;
    @Given("Open browser with appropriate browser")
    public void open_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            elderPlan= new ElderPlan(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser");
        }

    }

    @When("Login MPH web")
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

    @Then("Navigate to circles")
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

    @And("Add Elder plan as a partner")
    public void add_ElderPlan_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Elder Plan");
            circle.partner_search(record.get(0));
            click(elderPlan.elderPlan_link);
            login_Partner(driver,record);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_ElderPlan_Partner");
        }
    }

    @And("Authorise Elder plan")
    public void Authorise_ElderPlan() throws IOException {
        try{
            click(elderPlan.authorise_elderPlan);
            browser_explicit_wait(elderPlan.elderPlanTile_text, 3000);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("Authorise_ElderPlan");
        }
    }

    @And("Verify Elder plan is added as a partner")
    public void verify_ElderPlan_Added_Partner() throws IOException {
        try{
            Assert.assertTrue(elderPlan.elderPlanTile_text.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_ElderPlan_Added_Partner");
        }
    }

    @And("Browser closed")
    public void browser_Closed() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Closed");
        }
    }
}
