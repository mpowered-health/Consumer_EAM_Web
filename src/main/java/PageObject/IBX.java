package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IBX {
    
    WebDriver driver;

    @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement IBX_link;
    @FindBy (xpath = "//button[contains(text(),'Login')]") public WebElement ibxLogin;
    @FindBy (xpath="//p[contains(text(),'Independence Blue Cross')]") public WebElement IBXTile_text;


    //----------------------------------------------------------------------------------------------------------------------
    public IBX(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
