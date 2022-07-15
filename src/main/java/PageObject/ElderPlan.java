package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElderPlan {
    WebDriver driver;
    @FindBy (xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement elderPlan_link;
    @FindBy (xpath = "//button[contains(text(),'Authorize')]") public WebElement authorise_elderPlan;
    @FindBy (xpath="//p[contains(text(),'ElderPlan')]") public WebElement elderPlanTile_text;


    //----------------------------------------------------------------------------------------------------------------------
    public ElderPlan(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
