package myProject.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {

    @Test

    public void softAssertTest(){

        //SoftAssert objesi oluştur.
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Satır 15");
        softAssert.assertEquals(5,5);

        System.out.println("Satır 17");
        softAssert.assertTrue("Java".contains("ı"));

        softAssert.assertTrue(true);
        System.out.println("Satır 19");

        System.out.println("Satır 21");
        softAssert.assertAll();//PASS yada FAIL larak assertionları işaretler.
    }
}
