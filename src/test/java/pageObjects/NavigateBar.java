package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class NavigateBar {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]//*[contains(text(),'My Account')]")
    WebElement btnMyAccount;

    @FindBy(how = How.XPATH, using = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")
    WebElement btnRegister;

    CurrencyMenu currencyMenu;
    MenuBar menuBar;

    @FindBy(name = "search")
    WebElement searchField;

    @FindBy(className = "fa-search")
    WebElement searchBttn;

    @FindBy(linkText = "Login")
    WebElement loginBttn;

    @FindBy(partialLinkText = "Wish List")
    WebElement wishListLink;

    @FindBy(partialLinkText = "Shopping Cart")
    WebElement cartListLink;

    @FindBy(className = "fa-user")
    WebElement userBttn;



    public NavigateBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        currencyMenu = new CurrencyMenu(driver);
        menuBar = new MenuBar(driver);
    }

    public RegisterPage clickInRegister() {
        SeleniumUtils.clickElement(btnMyAccount, wait);
        SeleniumUtils.clickElement(btnRegister, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));
        return new RegisterPage(driver);
    }

    public void selectMoneda(String moneda){
        currencyMenu.seleccionarMoneda(moneda);
    }

    public SearchPage searchObject(String objeto) {
        SeleniumUtils.clickElement(searchField, wait);
        SeleniumUtils.sendText(searchField, wait, objeto);
        SeleniumUtils.clickElement(searchBttn, wait);
        return new SearchPage(driver);
    }

    public LogInPage goLogInPage () {
        SeleniumUtils.clickElement(userBttn, wait);
        wait.until(ExpectedConditions.visibilityOf(loginBttn));
        SeleniumUtils.clickElement(loginBttn, wait);
        return new LogInPage(driver);
    }

    public WishListPage goToWishList(){
        wait.until(ExpectedConditions.elementToBeClickable(wishListLink));
        SeleniumUtils.clickElement(wishListLink, wait);
        return new WishListPage(driver);
    }

    public CartProduct goToCartList(){
        wait.until(ExpectedConditions.elementToBeClickable(cartListLink));
        SeleniumUtils.clickElement(cartListLink, wait);
        return new CartProduct(driver);
    }

    public SearchPage navegarSimple(String opcion){
        return menuBar.navegarSimple(opcion);
    }

}

