package myProject.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart - Tum test caselerden önce bir kere çalısır : "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Tum test caselerden sonra bir kere çalısır : "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Her @Test ten önce bir kere çağrılır : "+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - sadece PASS olan testlerden sonra sadece bir kere çağrılır : "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure - sadece FAİL olan testlerden sonra sadece bir kere çağrılır : "+ result.getName());
        try {
            ReusableMethods.getScreenshot("Test-CAse-Fail-"+result.getName());
        } catch (IOException e) {
            e.printStackTrace();        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - sadece SKIP olan testlerden sonra sadece bir kere çağrılır : "+result.getName());
    }

}
