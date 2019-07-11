package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordFiled;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitBttn;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public HomePage logInUser (String user, String password) {
        emailField.sendKeys(user);
        passwordFiled.sendKeys(password);
        submitBttn.click();
        return new HomePage(driver);
    }
}
