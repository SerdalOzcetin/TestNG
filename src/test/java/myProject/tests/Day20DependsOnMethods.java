package myProject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20DependsOnMethods {
    @Test
    public void homeTest(){
        System.out.println("home Test");
        Assert.assertTrue(false);// fail
    }

    @Test(dependsOnMethods = "homeTest")
    public void searchTest(){
        System.out.println("search Test");
    }

    @Test(dependsOnMethods = "homeTest")
    public void paymentTest(){
        System.out.println("payment Test");
    }
}
/*
TestNG de tüm test methodları birbirinden bağımsız olarak çalışır,
 eğer methodları bağımlı hale getirmek istersen o drurumda "dependsOn" parametresi kullanılır.
 Buradaki örnektesearchTest methodunu homeTest methodununa bağımlı hale getirdik .
 Eğer seacrhTest methodu çalıştırılırsa searchTest inden önce homeTest çalışır.
 Eğer homeTest başarılı ise searchTest o zaman çalışır.
 Eğer  homeTest başarılı değilse searchTest ozaman çalışmaz.

 */