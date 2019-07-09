package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyMenu {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.CLASS_NAME, using="dropdown-toggle")
    private WebElement listMOnedas;

    @FindBy (how = How.NAME, using="EUR")
    private WebElement eur;

    @FindBy (how = How.NAME, using="GBP")
    private WebElement gbp;

    @FindBy (how = How.NAME, using="USD")
    private WebElement usd;

    public CurrencyMenu(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void seleccionarMoneda(String moneda){
        listMOnedas.click();
        if(moneda.equalsIgnoreCase("USD")){
            usd.click();
        }else if(moneda.equalsIgnoreCase("EUR")){
            eur.click();
        }else if(moneda.equalsIgnoreCase("GBP")){
            gbp.click();

        }
    }
}
