package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected NavigateBar bar;

    public BasePage(WebDriver driver){
        this.driver = driver;
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
    public SearchPage searchObject(String object) {return bar.searchObject(object);}
    public WishListPage goToWishList(){ return bar.goToWishList();}
    public CartProduct goToCartList(){return bar.goToCartList();}
}
