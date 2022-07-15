
package StepDefinition;

import PageObject.Circles;
import PageObject.MyMedicare;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;

public class Verify_CMS_Partner extends generic_function {

    Circles circle;
    MyMedicare cms;
    @Given("MPH open in a browser")
    public void mph_Open_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle = new Circles(driver);
            browser_explicit_wait(circle.username, 6000);
            cms=new MyMedicare(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("mph_Open_Browser");
        }
    }

    @When("Login valid username and password")
    public void login_Valid_Username_Password() throws IOException {
        try{
            circle.Login();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("login_Valid_Username_Password");
        }
    }

    @Then("Navigate circles page")
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
    @And("Add CMS as a partner")
    public void add_CMS_Partner() throws IOException {
        try{
            click(circle.addPartner_button);
            CSVRecord record=td_reader("My Medicare");
            circle.partner_search(record.get(0));
            click(circle.sel_Partner);
            login_Partner(driver,record);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_CMS_Partner");
        }
    }

    @And("Accept terms and conditions")
    public void accept_TermsConditions() throws IOException {
        try{
            browser_explicit_wait(driver.findElement(By.xpath("//input[@id='approve']")),7000 );
            driver.findElement(By.xpath("//input[@id='approve']")).click();
            browser_explicit_wait(driver.findElement(By.xpath("//p[@class='MuiTypography-root jss152 MuiTypography-body1']")),3000);
            Assert.assertTrue(driver.findElement(By.xpath("//p[@class='MuiTypography-root jss152 MuiTypography-body1']")).isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("accept_TermsConditions");
        }
    }

    @And("Verify CMS is added as a partner")
    public void verify_CMS_Added_Partner() throws IOException {
        try{
                browser_explicit_wait(cms.myMedicareText,4000);
                Assert.assertTrue(cms.myMedicareText.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_CMS_Added_Partner");
        }
    }

    @And("Browser is closed")
    public void browser_Closed() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("browser_Closed");
        }
    }
}
