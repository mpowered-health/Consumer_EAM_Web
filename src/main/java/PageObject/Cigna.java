package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cigna {

    WebDriver driver;

    public  String cignaPageTitle="myCigna - Auth Flow";
    @FindBy (xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement cigna_link;
    /*-----------------------------------------CIGNA LOGIN--------------------------------------------------------------*/
    @FindBy(xpath="//input[@id='username']") public WebElement cignaUsername;
    @FindBy(xpath = "//input[@id='password']") public WebElement cignaPassword;
    @FindBy(xpath = "//button[contains(text(),'Log In')]") public WebElement cignaLogin;
    @FindBy (xpath = "//span[@class='checkmark']") public WebElement cignaTermsConditions;
    @FindBy(xpath = "//button[contains(text(),'Download Data')]") public WebElement allowData;

    /*---------------------------------------CIGNA tile-----------------------------------------------------------------*/
    @FindBy(xpath="//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]") public WebElement cignaTile;
    @FindBy(xpath="//p[contains(text(),'Cigna')]") public WebElement cignaText;
    public String cignaText_tile="Cigna";
    @FindBy(xpath="//img[@class='jss160']") public WebElement cignaLogo;

    @FindBy(xpath = "//div[@class='MuiAlert-message']") public WebElement partner_addedLogo;
    /*------------------------------------- Methods---------------------------------------------------------------------*/
    public Cigna(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

}
