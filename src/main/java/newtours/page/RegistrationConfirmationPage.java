package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(partialLinkText = "sign-in")
    public WebElement signinLink;

    @FindBy(linkText = "Flights")
    public WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(signinLink));
        flightsLink.click();
    }

}
