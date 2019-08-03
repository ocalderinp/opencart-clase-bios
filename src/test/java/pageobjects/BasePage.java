package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

import java.util.List;


public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected NavigateBar bar;
    protected static String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
        bar = new NavigateBar(driver);
    }

    public RegisterPage clickInRegister(){
        return bar.clickInRegister();
    }
    public void seleccionarMoneda(String moneda){
        bar.selectMoneda(moneda);
    }
    public LogInPage goLogInPage () {return bar.goLogInPage();}
    public HomePage logout() { return bar.logout();}
    public SearchPage searchObject(String object) {return bar.searchObject(object);}
    public WishListPage goToWishList(){ return bar.goToWishList();}
    public CartProduct goToCartList(){return bar.goToCartList();}
    public SearchPage navegarAPhonesPDA(){ return bar.navegarSimple("Phones & PDAs");}
    public SearchPage navegarACameras(){ return bar.navegarSimple("Cameras");}

    public void clickElement(WebElement webElement){
        SeleniumUtils.clickElement(webElement, wait);
    }

    public void setText(WebElement webElement, String text){
        SeleniumUtils.sendText(webElement, wait, text);
    }

    public void selectByValue(WebElement webElement, String value){
        SeleniumUtils.selectByValue(webElement, value, wait);
    }

    public void selectByText(WebElement webElement, String text){
        SeleniumUtils.selectByText(webElement, text, wait);
    }

    public WebElement findElement(By locator){
        return SeleniumUtils.findElement(driver, locator);
    }

    public List<WebElement> findElements(By locator){
        return SeleniumUtils.findElements(driver, locator);
    }

    public void scrollIntoView(WebElement webElement){
        SeleniumUtils.scrollIntoView(driver, webElement);
    }
}
