package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day27_ListenersTest03 {

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test01(){
        System.out.println("PASS");
        Assert.assertTrue(true);

    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test02(){
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test03(){
        System.out.println("SKIPPED");
        throw new SkipException("Metotu atla");
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test04(){
        System.out.println("EXCEPTION");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.xpath("fdcdc"));
        // throw new NoSuchElementException("No SuchElementException");
    }
}
