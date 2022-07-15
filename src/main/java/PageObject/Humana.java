package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Humana {
    WebDriver driver;

    @FindBy(xpath = "//body/div[3]/div[3]/div[2]/div[2]/div[1]") public WebElement humana_link;

    @FindBy(xpath = "//button[@id='submitButton']") public WebElement allow_humana;
    @FindBy (xpath="//div[contains(text(),'Humana has been added as your partner')]") public WebElement humana_Added_Text;
    public String humanaText_Added="Humana has been added as your partner";
    @FindBy(xpath = "//p[contains(text(),'Humana')]") public WebElement humanaTile_text;



    //----------------------------------------------------------------------------------------------------------
    public Humana(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
}
