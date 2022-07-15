package StepDefinition;

import PageObject.Anthem;
import PageObject.Circles;
import Reusable_Methods.generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class Verify_Anthem_as_a_partner extends generic_function {
    Circles circle;
    Anthem anthem;
    @Given("Initiate  the browser")
    public void initiate_Browser() throws IOException {
        try{
            Browser_Launch(driver);
            circle=new Circles(driver);
            anthem=new Anthem(driver);
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("initiate_Browser");
        }
    }

    @Then("Goto  Circles page")
    public void goto_Circles_Page() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("goto_Circles_Page");
        }
    }

    @And("add Anthem as a partner")
    public void add_Anthem_Partner() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("add_Anthem_Partner");
        }
    }

    @And("Verify Anthem as a partner")
    public void verify_Anthem_Partner() throws IOException {
        try{

        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("verify_Anthem_Partner");
        }
    }

    @And("Close  browser")
    public void close_Browser() throws IOException {
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
            takeScreenShot("close_Browser");
        }
    }
}
