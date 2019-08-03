package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    List<ProductItem> resultados;
    boolean encontrado;

    public SearchPage(WebDriver driver) {super (driver);
        resultados = new ArrayList<>();
        encontrado = false;
        List<WebElement> listadoElementos = findElements(By.className("product-layout"));
        for(WebElement element : listadoElementos){
            resultados.add(new ProductItem(element));
        }
    }

    public void addToWishList(String object){
        for (ProductItem product : resultados){
            if (product.getName().equals(object)){
                product.addToWish();
                encontrado = true;
                break;
            }
        }
    }

    public boolean isObjectAddedToWishList(String object){
        if(!encontrado) {
            System.err.println("producto " + object + " no encontrado");
            return false;
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("div.alert-success"))));
            WebElement addToWishListSucces = findElement(By.cssSelector(("div.alert-success")));
            return addToWishListSucces.getText().contains("Success: You have added " + object + " to your wish list!");
        }
    }

    public void addToCart(String object){
        for(ProductItem product : resultados){
            if(product.getName().equals(object)){
                product.addToCart();
                break;
            }
        }
    }

    public boolean isObjectAddedToCart(String object){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("div.alert-success"))));
        WebElement addToCartSucces = findElement(By.cssSelector(("div.alert-success")));
        return addToCartSucces.getText().contains("Success: You have added " + object + " to your shopping cart!");
    }

    public void addToCartMenosPrecio() {
        int pos = -1;
        double menorPrecio = 999999;
        for(int i = 0; i < resultados.size(); i++){
            if(resultados.get(i).getPrecio() < menorPrecio){
                menorPrecio = resultados.get(i).getPrecio();
                pos = i;
            }
        }
        setProductName(resultados.get(pos).getName());
        resultados.get(pos).addToCart();
    }
}
