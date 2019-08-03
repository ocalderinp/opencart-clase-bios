package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class CurrencyMenu {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.CLASS_NAME, using = "dropdown-toggle")
    private WebElement listMOnedas;

    @FindBy (how = How.NAME, using = "EUR")
    private WebElement eur;

    @FindBy (how = How.NAME, using = "GBP")
    private WebElement gbp;

    @FindBy (how = How.NAME, using = "USD")
    private WebElement usd;

    private int timeout = 10;

    public CurrencyMenu(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        PageFactory.initElements(driver, this);
    }

    public void seleccionarMoneda(String moneda) {
        SeleniumUtils.clickElement(listMOnedas, wait);
        if (moneda.equalsIgnoreCase("USD")) {
            SeleniumUtils.clickElement(usd, wait);
        } else if (moneda.equalsIgnoreCase("EUR")) {
            SeleniumUtils.clickElement(eur, wait);
        } else if (moneda.equalsIgnoreCase("GBP")) {
            SeleniumUtils.clickElement(gbp, wait);
        }
    }
}
