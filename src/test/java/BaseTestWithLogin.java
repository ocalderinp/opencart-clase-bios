import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestWithLogin extends BaseTest {

    @BeforeMethod
    @Parameters({"userName", "password"})
    public void setupLogin(String userName, String password){
        logInPage = homePage.goLogInPage();
        homePage = logInPage.logInUser(userName, password);
    }
}
