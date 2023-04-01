package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] customerDatas(){
        Object[][] customerEntryDatas = {
                {"menejer1", "12345"},
                {"menejer2", "98765"},
                {"menejer3", "5678"}
        };
        return customerEntryDatas;
    }


    @DataProvider
    public Object[][] customerServicesDatas(){
        Object[][] customerServicesEntryDatas = {
                {"selam", "4536"},
                {"veli", "675675"},
                {"Jack", "b5675"}
        };
        return customerServicesEntryDatas;
    }




    @DataProvider
    public Object[][] personalDatas(){
        Object[][] personalEntryDatas = {
                {"mrEmin", "g567"},
                {"mssSnem", "rt5657"},
                {"Serkan", "srkn13"}
        };
        return personalEntryDatas;
    }

    @DataProvider
    public Object[][] getExcelDatas(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        Object[][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();

        return customerCredentials;
    }

}
