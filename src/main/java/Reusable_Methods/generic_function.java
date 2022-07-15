package Reusable_Methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Click;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class generic_function {
    protected WebDriver driver;
    File file = new File("src/main/resources/serenity.properties");
    Properties prop = new Properties();
    protected static String path,val;
    protected  String mainwindow,firefox= "geck",edge="msedge",chrome="chrome" ;

    String name,username,password,ele_username,ele_password,ele_loginButton;
    protected WebDriver browser_Init() throws IOException {
        FileInputStream fileInput;
        fileInput = new FileInputStream(file);
        prop.load(fileInput);
        path = getDriverPath().trim();
        if(path.contains(firefox))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (path.contains(edge)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        return driver;
    }
    /* Browser launching using driver that is specified in the config.properties file , navigating to Landing Welcome Page and returning driver object*/
    protected void Browser_Launch(WebDriver driver) throws FileNotFoundException,IOException {
        driver=browser_Init();
        driver.navigate().to(getURL());
        driver.manage().window().maximize();
    }

    /*Function will return the name of the browser*/
    protected  String browser_name() {
        path = getDriverPath().trim();
        if(path.contains(edge))
        {
            return edge;
        }
        if (path.contains(firefox)) {
            return firefox;
        }
        return chrome;
    }
    /* Reading chrome driver path from config.properties file */
    protected  String getDriverPath() {
        String driver= prop.getProperty("Browser");
        if(driver!=null) return driver ;
        else throw new RuntimeException ("Driver is not specified in the Config.properties");
    }

    /* Reading URL from config.properties file */
    protected  String getURL() {
        String URL= prop.getProperty("URL");
        if(URL!=null) return URL ;
        else throw new RuntimeException ("URL is not specified in the Config.properties");
    }

    /* Reading Excel file path  from config.properties   */
    protected  String getFilepath() {
        String filepath= prop.getProperty("Partnerlist_csv");
        if(filepath!=null) return filepath.trim() ;
        else throw new RuntimeException ("Filepath is not specified in the Config.properties");
    }

    /* To read test data value of a particular field name passing to this function from csv file */
    protected  CSVRecord td_reader(String fieldname) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(getcsv().trim()));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord csvRecord : csvParser) {
            String name=csvRecord.get(0);
            if(name.equalsIgnoreCase(fieldname))
            {
                return csvRecord;
            }
        }
        return null;
    }


    /* login to the partner website */
    protected void login_Partner(WebDriver driver,CSVRecord csvRecord) throws IOException {
        name = csvRecord.get(0);
        username = csvRecord.get(1);
        password = csvRecord.get(2);
        ele_username=csvRecord.get(3);
        ele_password=csvRecord.get(4);
        ele_loginButton=csvRecord.get(5);
       // driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
        browser_explicit_wait(driver.findElement(By.xpath(ele_username)),4000 );
        driver.findElement(By.xpath(ele_username)).sendKeys(username);
        driver.findElement(By.xpath(ele_password)).sendKeys(password);
        driver.findElement(By.xpath(ele_loginButton)).click();

    }


    protected  String getcsv() {
        path= prop.getProperty("Partnerlist_csv");
        if(path!=null) return path ;
        else throw new RuntimeException (" csv path is not specified in the Config.properties");
    }



    /*To get directory path of screenshots folder*/

    protected  String getDir() {
        String dirpath= prop.getProperty("Dirpath");
        if(dirpath!=null) return dirpath ;
        else throw new RuntimeException ("user Dir is not specified in the Config.properties");
    }


    //protected void login(WebDriver driver,String partner,);
    /* Click operation for a particular fieldname that is passing to this function through finding locator value of fieldname using OR_reader function*/
    protected  void click(WebElement element) throws IOException {
        element.click();
    }

    /* Refresh function to refresh the current URL opened in browser */
    protected  void browser_refresh() {
        driver.navigate().refresh();
    }

    /*Function for explicit wait */
    protected  WebElement browser_explicit_wait(WebElement ele,int time) throws IOException {
        WebElement wait=new WebDriverWait(driver, Duration.ofMillis(time)).until(ExpectedConditions.elementToBeClickable(ele));
        return wait;
    }

    /* To wait the browser till the time passed to this function */
    protected  void browser_wait(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
    }

    /*Function to clear the value in a particular field*/
    protected  void field_clear(WebElement element) throws IOException {
        element.clear();
    }
    /*To close the browser */
    protected  void browser_close() {
        driver.close();
    }

    /* Function to logout from mph web */
    protected void logOut(int time) throws IOException {
        browser_wait(3000);
        driver.findElement(By.xpath("//*[@id=\"side-nav-pwa-avatar\"]")).click();
        browser_explicit_wait(driver.findElement(By.xpath("//*[@id=\"item-name\"]")),time);
    }

    /*To quit the browser */
    protected  void driverquit() {
        driver.quit();
    }

    /*  Taking Screenshot of failed test cases  */
    protected   void takeScreenShot(String fileName) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
    }

    // to be deleted
    protected  String OR_reader(String fieldname) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(getFilepath().trim()));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord csvRecord : csvParser) {
            String name = csvRecord.get(0);
            System.out.println(name);
            String val = csvRecord.get(2);
            if(name.equalsIgnoreCase(fieldname))
            {
                return val;
            }
        }
        return null;
    }
}
