import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderClass {

    @DataProvider(name = "CompleteRegister")
    public static Object[][] getDataFromDataProviderCompleteRegister() {
        return new Object[][]
                {
                        {       "Alberto", "Alonso", "albddertdo0918sd9@alonso.uy", "094549888",
                                "23568899", "Alonso Company",
                                "Avenida Italia 4422", "No tiene", "Montevideo",
                                "12440", "Uruguay", "Montevideo",
                                "password01", "password01", "YES", "YES"
                        }

                };

    }

    @DataProvider(name = "WishListDataProvider")
    public static Object[][] getDataFromDataProviderWishListAddition(Method method) {
        Object[][] datos = null;
        if (method.getName().equalsIgnoreCase("addToWishTest") ||
                method.getName().equalsIgnoreCase("addToCartTest")) {
            datos = new Object[][]
                    {
                            {
                                "iMac"
                            }

                    };
        } else if (method.getName().equalsIgnoreCase("testLogin")) {
            datos = new Object[][]
                    {
                            {       "alberto0918sd9@alonso.uy",
                                    "password01"
                            }

                    };
        }

        return datos;
    }
}
