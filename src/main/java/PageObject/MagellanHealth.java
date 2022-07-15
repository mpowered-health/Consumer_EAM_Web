package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagellanHealth {
    WebDriver driver;

        @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement magellanHealth_Link;



    //-----------------------------------------------------------------------------------------------------------------------
    public MagellanHealth(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
