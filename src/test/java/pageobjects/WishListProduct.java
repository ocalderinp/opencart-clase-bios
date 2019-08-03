package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListProduct {
    WebElement element;

    public WishListProduct(WebElement element){
        this.element = element;
    }

    public String getName(){
        return element.findElement(By.cssSelector("td:nth-child(2)")).getText();
    }

    public void addToCart(){
        element.findElement(By.cssSelector("button[data-original-title='Add to Cart']")).click();
    }

    public void delete(){
        element.findElement(By.cssSelector("button[data-original-title='Remove']")).click();
    }


}
