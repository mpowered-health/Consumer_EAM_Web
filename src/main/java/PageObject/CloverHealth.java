package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Clock;

public class CloverHealth {
    WebDriver driver;
    @FindBy (xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement cloverHealthLink;
    @FindBy (xpath = "//body/div[@id='branded-container']/div[1]/div[2]/div[1]/form[1]/input[4]") public WebElement cloverHealth_agree;
    @FindBy (xpath = "//p[contains(text(),'Clover Health')]") public WebElement cloverHealthTile_text;


    //-----------------------------------------------------------------------------------------------------------------------
    public CloverHealth(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
