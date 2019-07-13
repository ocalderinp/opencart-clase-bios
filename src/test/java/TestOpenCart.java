import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOpenCart extends BaseTest {


    @Test(dataProvider = "CompleteRegister",dataProviderClass = DataProviderClass.class)
    public void testRegistro(String nombre,String apellido,String mail,String tel,String faxx,String compania,String dire1,
                             String dire2,String ciudad,String codigopostal,String pais_nombre,String zona,String passw,
                             String confirmpassw,String suscribe,String agree) throws InterruptedException {


        registerPage = homePage.clickInRegister();
        registerOKPage = registerPage.registerNewUser(nombre,apellido,mail,tel,faxx,compania,dire1,dire2,ciudad,codigopostal,pais_nombre,zona,
                passw,confirmpassw,suscribe,agree);

        Assert.assertTrue(registerPage.textDisplayedRegister());

    }

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class )
    public void testLogin(String userName, String password){
        logInPage = homePage.goLogInPage();
        homePage = logInPage.logInUser(userName, password);
        Assert.assertTrue(homePage.verifyIsLogged());
    }

}
