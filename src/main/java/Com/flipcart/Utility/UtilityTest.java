package Com.flipcart.Utility;

import Com.flipcart.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UtilityTest extends BaseTest {
    public UtilityTest() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@role='button']")
    public WebElement closeButton;

    // Click on Element
    public void clickCloseButton() {
        closeButton.click();
    }
}
