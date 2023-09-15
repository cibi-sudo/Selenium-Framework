package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "login-data")
    public static Object [][] getData(){
        Object [][] array;
        array = ExcelReader.getDataFromSheet("login");
        return array;
    }
}
