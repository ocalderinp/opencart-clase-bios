import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductManagementTest extends BaseTestWithLogin {

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class)
    public void addToWishTest(String object) {
        searchPage = homePage.searchObject(object);
        searchPage.addToWishList(object);
        Assert.assertTrue(searchPage.isObjectAddedToWishList(object));
        wishListPage = searchPage.goToWishList();
        Assert.assertTrue(wishListPage.verifyIfAt(object));

    }

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class)
    public void addToCartTest(String object){
        searchPage = homePage.searchObject(object);
        searchPage.addToCart(object);
        Assert.assertTrue(searchPage.isObjectAddedToCart(object));
        cartProduct = searchPage.goToCartList();
        Assert.assertTrue(cartProduct.verifyIfAt(object));
    }

}
