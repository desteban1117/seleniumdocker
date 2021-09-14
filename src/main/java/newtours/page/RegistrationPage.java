package newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        wait.until(ExpectedConditions.visibilityOf(firstName));
        return this;
    }

    public RegistrationPage enterUserDetails(String firstname, String lastName) {
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterUserCredentials(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
        return this;
    }

    public void submit() {
        submitBtn.click();
    }
}
