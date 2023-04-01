package techproed.tests.excelautomation;

import com.sun.source.tree.TryTree;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRental_HomaPage;
import techproed.pages.BlueRental_LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {
    BlueRental_HomaPage blueRental_homaPage;
    BlueRental_LoginPage blueRental_loginPage;

    ExcelUtils excelUtils;
    List<Map<String,String>> excelDatas;

    public void login(){
        //sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCar_Url"));

        //home page linkine tıkla
        blueRental_homaPage = new BlueRental_HomaPage();
        blueRental_loginPage = new BlueRental_LoginPage();



        //  -----------SADECE İLK GİRİS----------------
        //Loginlink butonu sadece ilk giriste sayfada görünür
        //2. ve 3. girislerde görünmeyeceginden NOSUCHELEMENT exception alınır.
        //Biz bu exception u try catch yapara yakalrız ve test case çalışmaya devam eder.

        try {
            blueRental_homaPage.LoginLink.click();
            ReusableMethods.waitFor(1);//1 Saniye bekle
        } catch (Exception e) {

        }

        //---------------SONRAKİ GİRİŞLER----------------------
        try {
        //Kullanıcı ID sine tıkla --->>> try catch
        blueRental_homaPage.userID.click();
            ReusableMethods.waitFor(1);

        //Logout linline tıkla      --->>> try catch
        blueRental_homaPage.LogOut.click();
            ReusableMethods.waitFor(1);

        //OK  e tıkla               --->>> try catch
        blueRental_homaPage.OK.click();
            ReusableMethods.waitFor(1);

        //home page login e tıkla   --->>> try catch
        blueRental_homaPage.LoginLink.click();
            ReusableMethods.waitFor(1);

        }
        catch (Exception e){

        }
    }

    @Test
    public void customerLogin() throws IOException {

        String path = "C:\\Users\\asus\\IdeaProjects\\testNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";

        //Data ları excel utils kullanarak bu sayfaya çağıracaz.
        excelUtils = new ExcelUtils(path, sayfa);

        excelDatas = excelUtils.getDataList();


        for(Map<String,String> data : excelDatas){
            login();
            ReusableMethods.waitFor(1);
            blueRental_loginPage.emailBox.sendKeys(data.get("username"));

            ReusableMethods.waitFor(1);
            blueRental_loginPage.passwordBox.sendKeys(data.get("password"));

            ReusableMethods.waitFor(1);
            blueRental_loginPage.loginButton.click();

            ReusableMethods.verifyElementDisplayed(blueRental_homaPage.userID);
            ReusableMethods.getScreenshot("EkranGörüntüsü");
        }
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }
}
/*
username	                    password
sam.walker@bluerentalcars.com	c!fas_art
kate.brown@bluerentalcars.com	tad1$Fas
raj.khan@bluerentalcars.com	v7Hg_va^
pam.raymond@bluerentalcars.com	Nga^g6!

------------ILK GIRIS-------------------
HOME PAGE DEYİZ
home page login e tıkla--->>> try catch

LOGİN PAGEDEYİZ
kullanıcı adını gir(excelden al)
kullanıcı şifresini gir(excelden al)
login butonuna tıkla

------------2. GIRIS---------------
HOME PAGE DEYİZ
Kullanıcı ID sine tıkla   --->>> try catch
Logout linline tıkla      --->>> try catch
OK  e tıkla               --->>> try catch
home page login e tıkla   --->>> try catch

LOGİN PAGEDEYİZ
kullanıcı adını gir(excelden al)
kullanıcı şifresini gir(excelden al)
login butonuna tıkla


------------3. GIRIS---------------
HOME PAGE DEYİZ
Kullanıcı ID sine tıkla
Logout linline tıkla
OK  e tıkla
home page login e tıkla

LOGİN PAGEDEYİZ
kullanıcı adını gir(excelden al)
kullanıcı şifresini gir(excelden al)
login butonuna tıkla


-----------4. GIRIS--------------------
HOME PAGE DEYİZ
Kullanıcı ID sine tıkla
Logout linline tıkla
OK  e tıkla
home page login e tıkla

LOGİN PAGEDEYİZ
kullanıcı adını gir(excelden al)
kullanıcı şifresini gir(excelden al)
login butonuna tıkla



HOME PAGE DEYİZ
Kullanıcı ID sine tıkla
Logout linline tıkla
OK  e tıkla
home page login e tıkla

LOGİN PAGEDEYİZ
kullanıcı adını gir(excelden al)
kullanıcı şifresini gir(excelden al)
login butonuna tıkla
 */