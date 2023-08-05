package dataprovider;

import org.testng.annotations.DataProvider;

public class dataProvider {
    @DataProvider(name = "login-data")
    public static Object [][] getData(){
        Object [][] array;
        array = excelReader.getDataFromSheet("login");
        return array;
    }
}
