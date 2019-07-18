package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItem {

    WebElement element;

    public ProductItem(WebElement main) {
        this.element = main;
    }

    public String getName(){
        return element.findElement(By.tagName("h4")).getText();
    }

    public String getTaxes(){
        return element.findElement(By.className("price-tax")).getText().replace("Ex Tax: ", "");
    }

    public void addToWish() {
        element.findElement(By.cssSelector("i.fa-heart")).click();
    }

    public void addToCart(){
        element.findElement(By.className("fa-shopping-cart")).click();
    }

    public double getPrecio() {
        String precio = element.findElement(By.className("price")).getText().substring(1, element.findElement(By.className("price")).getText().indexOf("\n"));
        return Double.valueOf(precio);
    }
}
