package pageObjects;

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
        List<WebElement> listadoElementos = driver.findElements(By.className("product-layout"));
        for(WebElement element : listadoElementos){
            resultados.add(new ProductItem(element));
        }
    }

    public void addToWishList(String object){
//        WebElement wishListBttn = driver.findElement(By.xpath(("//a[contains(text(),'" + object + "')]/ancestor::div[contains(@class,'product-layout')]")));
//        wishListBttn.findElement(By.cssSelector(".fa-heart")).click();
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
            WebElement addToWishListSucces = driver.findElement(By.cssSelector(("div.alert-success")));
            return addToWishListSucces.getText().contains("Success: You have added " + object + " to your wish list!");
        }
    }

}
