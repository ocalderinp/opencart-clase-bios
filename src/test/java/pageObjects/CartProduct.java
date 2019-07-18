package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartProduct extends BasePage {

    List<CartListProduct> productos;

    public CartProduct(WebDriver driver) {
        super(driver);
        productos = new ArrayList<>();
        WebElement tabla = findElement(By.cssSelector("div.table-responsive table tbody"));
        List<WebElement> filas = tabla.findElements(By.cssSelector("tr"));
        for(WebElement fila : filas){
            productos.add(new CartListProduct(fila));
        }
    }

    public boolean verifyIfAt(String object) {
        for(CartListProduct product : productos){
            if(product.getName().contains(object))
                return true;
        }
        return false;
    }

    public boolean hayElementos() {
        return productos.size() > 0;
    }
}
