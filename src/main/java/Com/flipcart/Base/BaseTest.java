package Com.flipcart.Base;

import Com.flipcart.ExtendReport.ExtentReportManager;
import Com.flipcart.Pages.AddToCartPage;
import Com.flipcart.Pages.ComparePage;
import Com.flipcart.Pages.HomePage;
import Com.flipcart.Pages.SearchPage;
import Com.flipcart.Utility.UtilityTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest extends ExtentReportManager {
    public static WebDriver driver;
    public static Properties prop;
    HomePage homePage;
    SearchPage searchPage;
    UtilityTest utilityTest;
    ComparePage comparePage;
    AddToCartPage addToCartPage;

    @BeforeTest
    public void setup()
    {
        Initialization();

        utilityTest = new UtilityTest();
        utilityTest.clickCloseButton();



    }

    @AfterTest
    public void teardown ()
    {
        extentReports.flush();
        closeDriver();
       // extentReports.flush();
    }




    public BaseTest() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/main/java/Com/flipcart/Config/Config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Initialization() {
        String browserName = prop.getProperty("browser");

        switch (browserName){
            case  "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                break;

            default:
                System.out.println("Unsupported browser: " + browserName);

        }
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            extentReports.flush();
        }
    }
    public boolean elementIsDisplayed(WebElement element){
        boolean value = false;

        try {
            value = element.isDisplayed();
        } catch (Exception e) {

        }
        System.out.println("Value"+value);
        return value;
    }
}
