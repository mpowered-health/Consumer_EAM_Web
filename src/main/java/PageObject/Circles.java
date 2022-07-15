package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Circles {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='username']") public WebElement username;
    @FindBy (xpath="//input[@id='password']") public WebElement password;
    @FindBy (xpath = "//input[@id='kc-login']") public WebElement login;

    /*----------------------------------------------Circles Page-----------------------------------------------------*/
    @FindBy (xpath = "//span[contains(text(),'Access Your Records')]") public WebElement accessRecords;
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]/span[1]/div[1]") public WebElement circlesButton;
    @FindBy(xpath="//BUTTON[@class='MuiButtonBase-root MuiTab-root MuiTab-textColorInherit Mui-selected']") public WebElement myPartnerButton;
    @FindBy(xpath="//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/img[1]") public WebElement noPartnerImg;
    @FindBy(xpath = "//div[2]/div/div[3]/div[2]") public WebElement noPartnersAdded_Text;
    public final String noPartnersText="No Partners added";
    @FindBy(xpath = "//div[3]/p") public WebElement addToCircles_Text;
    public final String addCirclesText="Please click on the below button “ Add to circle “ to add a Partner to your circle";
    @FindBy(xpath = "//span[@class='MuiButton-label']") public WebElement addPartner_button;

    /*---------------------------------------- Add a partner -------------------------------------------------------------*/
    @FindBy (xpath = "//div[@class='jss206']") public WebElement partnerList;
    @FindBys ({
            @FindBy (xpath = "//div[@class='jss206']"),
            @FindBy(xpath="(//div[@class='jss189'])") })public List<WebElement> listOfPartners;
    @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement circle_Search;
    @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement Partner;

    @FindBy(xpath="//div[@class='jss189']") public WebElement sel_Partner;
    @FindBy (xpath="//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/button[1]") public WebElement addPartner;
    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]") public WebElement cmsOptions;
    @FindBy (xpath = "//li[contains(text(),'Delete')]") public WebElement cmsDeletePartner;
    @FindBy (xpath = "//span[contains(text(),'Skip')]") public WebElement skipButton;
    /*------------------------------------- Methods---------------------------------------------------------------------*/

    public Circles(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void Login(){
        username.sendKeys("Tester0183@mph.com");
        password.sendKeys("Test@123");
        login.click();
    }

    public void partner_search(String search){
        circle_Search.sendKeys(search);
    }
}
