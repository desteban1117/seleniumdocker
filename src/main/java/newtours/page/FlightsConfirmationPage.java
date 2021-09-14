package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightsConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    public WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    public List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    public WebElement signOffLink;

    public FlightsConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(flightConfirmationHeader.getText());
        System.out.println(prices.get(1).getText());
        String price = prices.get(1).getText();
        signOffLink.click();
        return price;
    }
}
