import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductManagementTest extends BaseTest {

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class)
    public void addToWishTest(String userName, String password, String object) {
        logInPage = homePage.goLogInPage();
        homePage = logInPage.logInUser(userName, password);
        searchPage = homePage.searchObject(object);
        searchPage.addToWishList(object);
        Assert.assertTrue(searchPage.isObjectAddedToWishList(object));
        wishListPage = searchPage.goToWishList();
        Assert.assertTrue(wishListPage.verifyIfAt(object));

    }

}
