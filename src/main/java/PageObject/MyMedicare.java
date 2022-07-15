package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyMedicare {
    WebDriver driver;

    public String pagetitle="Medicare.gov";
    /*------------------------------------------- My medicare login-----------------------------------------------*/
    @FindBy(xpath = "//input[@id='username-textbox']") public WebElement CMS_username;
    @FindBy(xpath = "//input[@id='password-textbox']") public WebElement CMS_password;
    @FindBy(xpath = "//button[@id='login-button']") public WebElement CMS_login;

    /*---------------------------------------My medicare login page ---------------------------------------------------*/
    @FindBy(xpath = "//h1[contains(text(),'Mpowered Health has asked for some of your data.')]") public WebElement cms_text;
    @FindBy (xpath = "//input[@id='approve']") public WebElement cms_allow;

    /*--------------------------------------- Add partner page-----------------------------------------------------------*/
    @FindBy(xpath = "//div[contains(text(),'My Medicare has been added as your partner')]") public WebElement cmsAdded;
    public String cmsAdded_msg="My Medicare has been added as your partner";
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]") public WebElement MymedicareTile;
    @FindBy(xpath = "//body[@style='margin: 0px;']/div[@id='root']/div/div[@class='jss1']/div[@class='jss5']/div[@class='jss156']/div[@class='jss158']/div/div/div[@class='jss182']/div[9]/div[1]/div[1]/img[1]") public WebElement myMedicareLogo;
    @FindBy(xpath="//p[contains(text(),'My Medicare')]") public WebElement myMedicareText;
    public String myMedicare_TextTile="My Medicare";

    @FindBy(xpath = "//div[contains(text(),'My Medicare has been removed from My Partner')]") public WebElement cmsRemove;

    /*------------------------------------- Methods---------------------------------------------------------------------*/

    public MyMedicare(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

}
