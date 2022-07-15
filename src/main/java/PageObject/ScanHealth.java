package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScanHealth {
    WebDriver driver;

    @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement Scanhealth_link;
    @FindBy (xpath = "//button[contains(text(),'Login')]") public WebElement scanHealth_Login;
    @FindBy (xpath="//p[contains(text(),'Independence Blue Cross')]") public WebElement scanHealth_Tile_text;


    //----------------------------------------------------------------------------------------------------------------------
    public ScanHealth(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
