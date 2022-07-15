package StepDefinition;

import PageObject.Cigna;
import PageObject.Circles;
import PageObject.MyMedicare;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class Verification_of_Circles_Page extends generic_function {
    Circles circle;
    MyMedicare cms;
    Cigna cigna;
    String partnerName;

    @Given("MPH URL open in a browser")
    public void mphURL_Open_Browser() throws IOException {
        try {
            Browser_Launch(driver);
            circle = new Circles(driver);
            cigna = new Cigna(driver);
            browser_explicit_wait(circle.username, 6000);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("mphURL_Open_Browser");
        }
    }

    @When("Login using valid username and password")
    public void login_Valid_Username_Password() throws IOException {
        try {
            circle.Login();
            browser_explicit_wait(circle.skipButton, 8000);
            circle.skipButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("login_Valid_Username_Password");
        }
    }

    @Then("Navigate to circles page")
    public void navigate_CirclesPage() throws IOException {
        try {
            browser_explicit_wait(circle.accessRecords, 5000);
            circle.accessRecords.click();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("navigate_CirclesPage");
        }
    }

    @And("Verify the circles page UI")
    public void verify_Circles_PageUI() throws IOException {
        try {
            browser_explicit_wait(circle.addPartner_button, 7000);
            Assert.assertTrue(circle.noPartnerImg.isDisplayed());
            Assert.assertTrue(circle.myPartnerButton.isDisplayed());
            Assert.assertTrue(circle.noPartnersAdded_Text.getText().contains(circle.noPartnersText));
            Assert.assertTrue(circle.addToCircles_Text.getText().contains(circle.addCirclesText));
            Assert.assertTrue(circle.addPartner_button.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("verify_Circles_PageUI");
        }
    }

    @And("browser close")
    public void browser_Close() {
        driver.close();
    }


    /* ----------------------Verify Circles add a partner-----------------------------------*/
    @And("Click on add a partner button")
    public void click_AddAPartner_Button() throws IOException {
        try {
            browser_explicit_wait(circle.addPartner_button, 6000);
            circle.addPartner_button.click();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("click_AddAPartner_Button");
        }
    }

    @And("type partner name on search {string}")
    public void type_partner_Name_Search(String search) throws IOException {
        try {
            circle.partner_search(search);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("type_partner_Name_Search");
        }
    }

    @And("Add a partner")
    public void add_Partner() throws IOException {
        try {
            browser_explicit_wait(circle.Partner, 4000);
            circle.Partner.click();
           // td_reader(driver);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenShot("add_Partner");
        }
    }

    @And("Verify the partner is added")
    public void verify_Partner_Added() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_Partner_Added");
        }
    }


}

