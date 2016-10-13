package smart4aviation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestFailListener implements ITestListener {
    private static WebDriver webDriver;
    private String filePath = System.getProperty("user.dir") + File.separator + "target" +
            File.separator + "surefire-reports" + File.separator + "Smart4Aviation" + File.separator;

    public void setDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Error " + iTestResult.getName() + " test has failed.");
        String methodName = iTestResult.getName().toString().trim();
        takeScreenShot(methodName);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
            System.out.println("Placed screen shot in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}