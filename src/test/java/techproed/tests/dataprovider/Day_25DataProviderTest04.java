package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day_25DataProviderTest04 {

    @Test(dataProvider = "customerDatas", dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String username, String password){

        System.out.println("Username : "+username+".  Password : "+password);
    }

    @Test(dataProvider = "customerServicesDatas", dataProviderClass = DataProviderUtils.class)
    public void customerServicesDatasTest(String username, String password){
        System.out.println(username+"   "+password);

    }
    @Test(dataProvider = "personalDatas", dataProviderClass = DataProviderUtils.class)
    public void personalDatasTest(String username, String password){
        System.out.println(username+"   "+password);
    }

    @Test(dataProvider = "getExcelDatas", dataProviderClass = DataProviderUtils.class)
    public void getExcelDatasTest(String username, String password){
        System.out.println(username+" ||  "+password);
    }
}
