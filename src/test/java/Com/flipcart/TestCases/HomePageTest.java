package Com.flipcart.TestCases;

import Com.flipcart.Base.BaseTest;
import Com.flipcart.ExtendReport.ExtentReportManager;
import Com.flipcart.Pages.HomePage;
import Com.flipcart.Utility.UtilityTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportManager.class)
public class HomePageTest extends BaseTest {
    HomePage homePage;


//    @Test(priority = 1, description = "Verify various page elements")
//    public void verifyPageElements() {
//        startTest("Login With Valid User Details", "Rohan Aher", "Smoke Test");
//        try {
//
//        homePage.TitleIsCorrect();
//        homePage.LogoIsDisplayed();
//        homePage.SearchBarIsDisplayed();
//        homePage.SearchIconIsDisplayed();
//        homePage.ProductCatalogIsDisplayed();
//        homePage.NavigationButtonsAreDisplayed();
//        homePage.AllFooterLinksAreDisplayed();
//        } catch (Exception e) {
//        e.printStackTrace();
//    }
//    }

    @Test
    public void dryrunTest(){
        homePage = new HomePage();
       // elementIsDisplayed(homePage.discountAmount);

    }
    @Test(priority = 1)
    public void verifyHomePageTitle() {
        startTest("Verify Home Page Title", "Rohan Aher", "Smoke Test");

        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify the home page title is correct.");
            homePage.TitleIsCorrect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void verifyLogoIsDisplayed() {
        startTest("Verify Logo Is Displayed", "Rohan Aher", "Smoke Test");
        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify the logo is displayed.");
            homePage.LogoIsDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void verifySearchBarIsDisplayed() {
        startTest("Verify Search Bar Is Displayed", "Rohan Aher", "Smoke Test");

        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify the search bar is displayed.");
            homePage.SearchBarIsDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void verifySearchIconIsDisplayed() {
        startTest("Verify Search Icon Is Displayed", "Rohan Aher", "Smoke Test");

        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify the search icon is displayed.");
            homePage.SearchIconIsDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void verifyProductCatalogIsDisplayed() {
        startTest("Verify Product Catalog Is Displayed", "Rohan Aher", "Smoke Test");

        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify the product catalog is displayed.");
            homePage.ProductCatalogIsDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void verifyNavigationButtonsAreDisplayed() {
        startTest("Verify Navigation Buttons Are Displayed", "Rohan Aher", "Smoke Test");

        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify the navigation buttons are displayed.");
            homePage.NavigationButtonsAreDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void verifyAllFooterLinksAreDisplayed() {
        startTest("Verify All Footer Links Are Displayed", "Rohan Aher", "Smoke Test");

        try {
            homePage = new HomePage();
            extentTest.log(Status.INFO, "Verify all footer links are displayed.");
            homePage.AllFooterLinksAreDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}