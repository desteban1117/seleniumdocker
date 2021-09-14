package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    public WebElement passengers;

    @FindBy(name = "findFlights")
    public WebElement submitBtn;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String noOfPassengers) {
        wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select = new Select(passengers);
        select.selectByValue(noOfPassengers);
    }

    public void goToFlightDetailsPage() {
        submitBtn.click();
    }
}
