package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    public WebElement firstSubmitBtn;

    @FindBy(name = "buyFlights")
    public WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage() {
        wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
        firstSubmitBtn.click();
    }

    public void goToOrderConfirmationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
        secondSubmitBtn.click();
    }
}
