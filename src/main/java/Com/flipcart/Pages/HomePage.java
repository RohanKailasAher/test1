package Com.flipcart.Pages;

import Com.flipcart.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BaseTest {
    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@class='aqQN50']")
    WebElement flipkartLogo;

    @FindBy(xpath = "//input[@class='Pke_EE']")
    WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")

    WebElement searchIcon;

    @FindBy(xpath = "//div[@class='_3sdu8W emupdz']")

    WebElement productCatalog;

    @FindBy(xpath = "//button[@title='Previous Slide']")

    WebElement previousButton;

    @FindBy(xpath = "//button[@title='Next Slide']")

    WebElement nextButton;

    @FindBy(xpath = "//div[@class='_1HSe4t']//a")
    java.util.List<WebElement> footerLinks;
    @FindBy(xpath = "//img[@alt='Flights']")
    WebElement clickOnFlightLink;

    @FindBy(xpath = "//div[text()='Discount']/parent::div/following::div/span/span")
    public WebElement discountAmount;

    public void dryRun(){
       boolean Displayed= discountAmount.isDisplayed();
        System.out.println(Displayed);

    }

    public void TitleIsCorrect() {
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: [" + actualTitle + "]");
        System.out.println("Expected Title: [" + expectedTitle + "]");
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected.");
    }

    public void LogoIsDisplayed() {
        boolean isLogoDisplayed = isLogoDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Logo is not displayed.");
    }

    public boolean isLogoDisplayed() {
        return flipkartLogo.isDisplayed();
    }

    public void SearchBarIsDisplayed() {
        boolean isSearchBarDisplayed = isSearchBarDisplayed();
        Assert.assertTrue(isSearchBarDisplayed, "Search bar is not displayed.");
    }

    public boolean isSearchBarDisplayed() {
        return searchBar.isDisplayed();
    }

    public void SearchIconIsDisplayed() {
        boolean isSearchIconDisplayed = isSearchIconDisplayed();
        Assert.assertTrue(isSearchIconDisplayed, "Search icon is not displayed.");
    }

    public boolean isSearchIconDisplayed() {
        return searchIcon.isDisplayed();
    }


    public void ProductCatalogIsDisplayed() {
        boolean isProductCatalogDisplayed = isProductCatalogDisplayed();
        Assert.assertTrue(isProductCatalogDisplayed, "Product catalog is not displayed.");
    }

    public boolean isProductCatalogDisplayed() {
        return productCatalog.isDisplayed();
    }


    public void NavigationButtonsAreDisplayed() {
        Assert.assertTrue(isPreviousButtonDisplayed() && isNextButtonDisplayed(), "Navigation buttons are not displayed.");
    }

    public boolean isPreviousButtonDisplayed() {
        return previousButton.isDisplayed();
    }

    public boolean isNextButtonDisplayed() {
        return nextButton.isDisplayed();
    }

    public void AllFooterLinksAreDisplayed() {
        for (WebElement link : footerLinks) {
            Assert.assertTrue(link.isDisplayed(), "Footer link is not displayed.");
        }
    }
    public void goToFlightPage() throws InterruptedException {
        Thread.sleep(3000);
        clickOnFlightLink.click();

    }


}