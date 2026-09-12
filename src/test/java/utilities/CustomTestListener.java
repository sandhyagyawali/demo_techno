package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override //@Override is a Java annotation. It tells the compiler that this method is overriding (replacing) a method from a parent class or interface.
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " +  result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished: " + context.getName());
    }
}
