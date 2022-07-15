package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BCBS {


    WebDriver driver;

    @FindBy (xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]") public WebElement bcbs_link;
    @FindBy (xpath = "//div[@id='MEDICARE']") public WebElement medicareAdvMember_Role;
    @FindBy (xpath = "//div[@id='MEDICAID']") public WebElement minnesotaHealthCareMember_Role;
    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]") public WebElement BCBS_TC_Agree;
    @FindBy (xpath = "//button[contains(text(),'I Agree')]") public WebElement bcbs_Agree;
    @FindBy (xpath = "//button[contains(text(),'I Disagree')]") public WebElement bcbs_Disagree;

    @FindBy (xpath = "//p[contains(text(),'Blue Cross and Blue Shield of Minnesota')]") public WebElement bcbs_TileText;

    //----------------------------------------------------------------------------------------------------------
    public BCBS(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
