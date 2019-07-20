import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ProductManagementTest extends BaseTestWithLogin {

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class)
    public void addToWishTest(String object, Method method) {
        extentTest = extentReports.createTest(method.getName());
        searchPage = homePage.searchObject(object);
        searchPage.addToWishList(object);
        Assert.assertTrue(searchPage.isObjectAddedToWishList(object));
        wishListPage = searchPage.goToWishList();
        Assert.assertTrue(wishListPage.verifyIfAt(object));

    }

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class)
    public void addToCartTest(String object, Method method){
        extentTest = extentReports.createTest(method.getName());
        extentTest.log(Status.INFO, "Buscando articulo " + object);
        searchPage = homePage.searchObject(object);
        searchPage.addToCart(object);
        Assert.assertTrue(searchPage.isObjectAddedToCart(object));
        cartProduct = searchPage.goToCartList();
        Assert.assertTrue(cartProduct.verifyIfAt(object));
    }

    @Test
    public void addToCartMenorPrecio(Method method){
        extentTest = extentReports.createTest(method.getName());
        searchPage = homePage.navegarAPhonesPDA();
        searchPage.addToCartMenosPrecio();
        cartProduct = searchPage.goToCartList();
        Assert.assertTrue(cartProduct.hayElementos());
        Assert.assertTrue(cartProduct.verifyIfAt(cartProduct.getProductName()));
    }

}
