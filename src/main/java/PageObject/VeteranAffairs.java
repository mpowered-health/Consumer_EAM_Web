package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VeteranAffairs {
    WebDriver driver;

    @FindBy (xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement VA_link;
    @FindBy (xpath = "//body/div[1]/div[3]/div[2]/div[1]/a[2]") public WebElement VA_IDme;
    @FindBy (xpath = "//button[contains(text(),'Continue')]") public WebElement VA_continue;
    @FindBy (xpath = "//p[contains(text(),'Veterans Affairs')]") public WebElement VATile_text;

    //----------------------------------------------------------------------------------------------------------------------
    public VeteranAffairs(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
