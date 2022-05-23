package com.qualitymuseum.framework.core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureReportListeners extends CommonTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment (value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.print("Test Failed: " + getTestMethodName(iTestResult));
        WebDriver driver = getDriver();

        if (driver instanceof WebDriver){
            System.out.print("Screenshot captured for test: " + getTestMethodName(iTestResult));
            saveScreenShot(driver);
            saveTextLog("ScreenShot captured for: " + getTestMethodName(iTestResult));
        }
    }

}
