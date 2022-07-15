package StepDefinition;

import PageObject.Circles;
import PageObject.MagellanHealth;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class Verify_Magellan_Health_as_a_partner extends generic_function {

    Circles circle;
    MagellanHealth magellanHealth;
    @Given("Open browser and login")
    public void open_Browser_Login() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            magellanHealth=new MagellanHealth(driver);
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("open_Browser_Login");
        }

    }

    @When("Navigate to  circle page")
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

    @And("Add Magellan Health as a partner")
    public void add_Magellan_Health_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("Magellan Health");
            circle.partner_search(record.get(0));
            click(magellanHealth.magellanHealth_Link);
            login_Partner(driver,record);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_Magellan_Health_Partner");
        }
    }

    @And("Accept terms and conditions for Magellan Health")
    public void accept_Terms_Conditions_MagellanHealth() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("accept_Terms_Conditions_MagellanHealth");
        }
    }

    @And("Verify Magellan Health is added as a partner")
    public void verify_Magellan_Health_Added_Partner() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_Magellan_Health_Added_Partner");
        }
    }

    @And("Browser  close")
    public void browser_Close() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Close");
        }
    }
}
