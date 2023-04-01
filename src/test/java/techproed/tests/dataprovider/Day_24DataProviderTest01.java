package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day_24DataProviderTest01 {



    //DATA PROVİDER
    @DataProvider(name = "smoke_test_data")
    public Object[][] urunler(){

            Object urunListesi[][] = {
            {"tesla"},
            {"bmw"},
            {"mercedes"},
            {"honda"},
            {"toyota"},
            {"volvo",}
        };

            return urunListesi;
    }

    @Test(dataProvider = "smoke_test_data")

    public void aramaTesti(String data) {

        /*
        Data Provider nedir?
        ***Veri Deposudur. Bir çok veriyi test case lere loop kullanmadan aktarmak için kullanılır.
        *** Data provider 2D(2 boyutlu) array return eder.
        ***Data provider TestNG den gelen bir özelliktir.
        Data Provider ne için kullanılır?
        ***Data provider DDT(Data Driven Testing) için kullanılır. Birden fazla datayı test caselerde kullanmak için kullanılır.
        ---Data Provider ı nasıl kullanırsın?
        ---@dataProvider annotasyonu ile veri havuzu oluşturulur.@Test method larına bu data havuzu bağlanır.
        ***Data Provider da 2 tane önemli parametre vardır.
        name:       metot ismini override etmek için, yani farklı bir isim ile datprovider ı cağırmak için kullanılır.
        parallel:   parallel test case ler oluşturmak için kullanılır.
         */

        System.out.println(data);

    }

   @Test(dataProvider = "smoke_test_data")
    public void googleAraması(String araclar) throws InterruptedException {
        Driver.getDriver().get("https://www.google.com");

        try{
            Driver.getDriver().findElement(By.xpath("(//div[@class'QS5gu sy4vM2'])[2]"));
        }catch (Exception e){

        }

        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar+ Keys.ENTER);

        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));

        Driver.closeDriver();
   }
}

