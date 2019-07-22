package pageObjects;

import org.openqa.selenium.By;
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
        setText(emailField, user);
        setText(passwordFiled, password);
        clickElement(submitBttn);
        return new HomePage(driver);
    }
}
