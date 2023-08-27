package techproed.tests.paralleltesting;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class Day26_SearchItems {
    @Test(priority = 0)
    public void googleSEarch(){
        /*

        WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
        ReusableMethods.waitFor(3);
        System.out.println("Google Title :"+ driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("porcelain teapot" + Keys.ENTER);
        driver.quit();

         */
        Driver.getDriver().get("https://www.google.com");
        ReusableMethods.waitFor(3);
        System.out.println("Google Title :"+ Driver.getDriver().getTitle());
        Driver.getDriver().findElement(By.name("q")).sendKeys("porcelain teapot" + Keys.ENTER);
        // Driver.getDriver().close(); bu şekilde kullanıldığında diğer @test deki driverin çalışması engelleniyor.
        Driver.closeDriver(); // şeklinde kullanınca sorun olmuyor.
    }

    @Test(priority = 1)
    public void amazonSearch(){
        /*
        WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        ReusableMethods.waitFor(3);
        System.out.println("Amazon Title :" +driver.getTitle());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER);
        driver.quit();

         */

        Driver.getDriver().get("https://www.amazon.com");
        ReusableMethods.waitFor(3);
        System.out.println("Amazon Title :" +Driver.getDriver().getTitle());
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER);
        Driver.getDriver().quit();

    }
}
