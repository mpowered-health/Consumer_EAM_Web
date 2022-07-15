package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UHC {
    WebDriver driver;

        @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement uhc_link;

    //-----------------------------------------------------------------------------------------------------------------------
    public UHC(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
