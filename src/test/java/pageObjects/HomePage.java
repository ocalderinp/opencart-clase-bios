package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(), 'My Account')]")
    WebElement myAccountLabel;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean verificarCambioMoneda(String moneda){
        String simbolo = obtenerSimboloMoneda(moneda);
        boolean monedaOK = true;
        List<WebElement> listadoElementos = findElements(By.className("product-layout"));
        List<ProductItem> listadoProductos = new ArrayList<>();
        for(WebElement element : listadoElementos){
            listadoProductos.add(new ProductItem(element));
        }
        for (ProductItem productItem : listadoProductos){
            if(!productItem.getTaxes().contains(simbolo))
                monedaOK = false;
        }
        return monedaOK;
    }

    public String obtenerSimboloMoneda(String moneda){
        String monedaSimbolo="";

        if(moneda.equalsIgnoreCase("USD")){
            monedaSimbolo="$";
        }else if(moneda.equalsIgnoreCase("EUR")){
            monedaSimbolo="€";
    }else   if(moneda.equalsIgnoreCase("GBP")) {
            monedaSimbolo = "£";
        }
        return monedaSimbolo;

    }


    public boolean verifyIsLogged() {
        return myAccountLabel.isDisplayed();
    }
}