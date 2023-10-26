package Com.flipcart.Pages;

import Com.flipcart.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightPage extends BaseTest {
    @FindBy(css = "label[for='ROUND_TRIP'] div[class='_1XFPmK']")
    WebElement roundTrip;

    @FindBy(css = "input[name='0-departcity']")
    WebElement cityFrom;

    @FindBy(css = "input[name='0-arrivalcity']")
    WebElement cityTo;
//    @FindBy(xpath = "//label[text()='Depart On']")
//    WebElement DepartOn;
//    @FindBy(xpath = "//label[text()='Return On']")
//    WebElement ReturnOn;
    @FindBy(xpath = "//button[text()='27']")
    WebElement DepartOnDate;
    @FindBy(xpath = "//button[text()='31']")
    WebElement ReturnDate;
//
//    @FindBy(xpath = "//button[@type='button']")
//    WebElement searchButton;

//    @FindBy(id = "departureCity")
//    WebElement departureCityInput;
//
//    @FindBy(id = "arrivalCity")
//    WebElement arrivalCityInput;
//
    @FindBy(id = "departureDate")
    WebElement departureDateInput;

    @FindBy(id = "returnDate")
    WebElement returnDateInput;

//    @FindBy(id = "searchResults")
//    WebElement searchResults;
//
//    @FindBy(id = "adultsCount")
//    WebElement adultsCountInput;
//
//    @FindBy(id = "cabinClass")
//    WebElement cabinClassDropdown;
//
//    @FindBy(id = "applyFilters")
//    WebElement applyFiltersButton;
//
//    @FindBy(id = "fastestFlight")
//    WebElement fastestFlightButton;

    @FindBy(id = "bookFlight")
    WebElement bookFlightButton;

    public FlightPage() {
        PageFactory.initElements(driver, this);
    }

    public void chooseRoundTrip() throws InterruptedException {
        Thread.sleep(3000);
        roundTrip.click();
    }

    public void setDepartureCity() throws InterruptedException {
        cityFrom.sendKeys(prop.getProperty("fromCity"));
        Thread.sleep(700);
        cityFrom.sendKeys(Keys.ARROW_DOWN);
        cityFrom.sendKeys(Keys.ENTER);
    }

    public void setArrivalCity() throws InterruptedException {
        cityTo.sendKeys(prop.getProperty("toCity"));
        Thread.sleep(700);
        cityTo.sendKeys(Keys.ARROW_DOWN);
        cityTo.sendKeys(Keys.ENTER);
    }
//    public void DepartOn() throws InterruptedException {
//        Thread.sleep(3000);
//        DepartOnDate.click();
//    }
//    public void ReturnOn() throws InterruptedException {
//        Thread.sleep(3000);
//        ReturnDate.click();
//    }
public void selectDepartureDate(String date) {
    // Click on the "Depart on" input field
    departureDateInput.click();

    // Wait for the calendar to appear
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ZEl_b_ CeQnEq _2ogGYG _23xUYh _3pAV4E']")));

    // Locate and click the desired date
    WebElement desiredDate = calendar.findElement(By.xpath("//button[text()='31']"));
    desiredDate.click();
}

    public void selectReturnDate(String date) {
        // Click on the "Return on" input field
        returnDateInput.click();

        // Wait for the calendar to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ZEl_b_ CeQnEq _2ogGYG _23xUYh _3pAV4E']")));

        // Locate and click the desired date
        WebElement desiredDate = calendar.findElement(By.xpath("//button[text()='31']"));
        desiredDate.click();
    }


//    public void enterDepartureDate(String departureDate) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(departureDateInput)).clear();
//        departureDateInput.sendKeys(departureDate);
//    }
//
//    public void enterReturnDate(String returnDate) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(returnDateInput)).clear();
//        returnDateInput.sendKeys(returnDate);
//    }
//
//    public void clickSearchButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
//    }
//
//    public void selectAdultCount(int count) {
//        adultsCountInput.clear();
//        adultsCountInput.sendKeys(String.valueOf(count));
//    }
//
//    public void selectCabinClass(String cabinClass) {
//        cabinClassDropdown.click();
//        driver.findElement(By.linkText(cabinClass)).click();
//    }
//
//    public void clickApplyFilters() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(applyFiltersButton)).click();
//    }
//
//    public void clickFastestFlight() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(fastestFlightButton)).click();
//    }
//
//    public void clickBookFlight() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(bookFlightButton)).click();
//    }
}
