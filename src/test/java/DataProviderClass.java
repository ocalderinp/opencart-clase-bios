import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "CompleteRegister")
    public static Object[][] getDataFromDataProviderCompleteRegister(){
        return new Object[][]
                {
                        {       "Alberto","Alonso","alberto0918sd9@alonso.uy","094549888",
                                "23568899","Alonso Company",
                                "Avenida Italia 4422","No tiene","Montevideo",
                                "12440","Uruguay","Montevideo",
                                "password01","password01","YES","YES"
                        }

                };

    }
}
