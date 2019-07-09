package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateBar {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//*[contains(text(),'My Account')]")
    WebElement btnMyAccount;

    @FindBy(how = How.XPATH, using = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")
    WebElement btnRegister;

    CurrencyMenu currencyMenu;


    public NavigateBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        currencyMenu = new CurrencyMenu(driver);
    }

    public RegisterPage clickInRegister() {
        btnMyAccount.click();
        btnRegister.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));
        return new RegisterPage(driver);
    }

    public void selectMoneda(String moneda){
        currencyMenu.seleccionarMoneda(moneda);
    }
}
