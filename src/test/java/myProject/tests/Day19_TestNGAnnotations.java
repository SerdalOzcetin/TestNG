package myProject.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.*;


public class Day19_TestNGAnnotations {

    /*
    @Test : test case oluşturmak için kullanılır.
    @Before ve @After : 5 Before ve 5 After anotatıonu var.
    Suıte > tests > grup > class > method
    -------------------------------------------------------------------------------------
    @BeforeSuite: her bir suitten önce bir sefer calışır.
    @AfterSuite : her bir suitten sonra bir sefer calışır.
    @BeforeTest : her bir testten önce (TEST CASE İLE KARIŞTIRLMAMALI) 1 SEFER CALIŞIR
    @AfterTest  : her bir testten sonra (TEST CASE İLE KARIŞTIRLMAMALI) 1 SEFER CALIŞIR
    @BeforeClass: her bir class dan önce 1 sefer calışır.
    @AfterClass : her bir class dan sonra 1 sefer calışır.
    @BeforeMethod: her bir @Test annotationundan önce 1 sefer çalışır.
    @AfterMethod : her bir @Test annotationundan sonra 1 sefer çalışır.
    --------------------------------------------------------------------------------------

    @Ignore : @Test caese leri(skip, ignore) atlamak için kullanılır.
    @Test (enabled = false): Test case leri kullanıma kapatmak için kullanılır.
    --------------------------------------------------------------------------------------
    TestNG de testler isim sırasına göre çaılışır.
    @Test(priority = 1): Test Case leri öncelemek için kullanılır.
    Note : Default priority nin değeri "0" a eşittir.

     */


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("beforeGroups");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(priority = 1,groups = "regression-tests")
    public void test07(){
        System.out.println("test 01");
    }
    @Test @Ignore
    public void test02(){
        System.out.println("test 02");
    }
    @Test (enabled = false,groups = "regression-tests")
    public void test03(){
        System.out.println("test 03");
    }
    @Test(priority = 3)
    public void test04(){
        System.out.println("test 04");
    }    @Test(priority = -5)
    public void test05(){
        System.out.println("test 05");
    }
    @Test(priority = 8)
    public void test06() {
        System.out.println("test 06");

    }

}
