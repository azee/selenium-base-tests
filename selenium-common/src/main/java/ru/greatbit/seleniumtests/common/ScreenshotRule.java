package ru.greatbit.seleniumtests.common;

import io.qameta.allure.Attachment;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * Created by azee on 26.09.17.
 */
public class ScreenshotRule extends TestWatcher {

    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public Statement apply(Statement base, Description description) {
        return super.apply(base, description);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        captureScreenshot();
        super.failed(e, description);
    }

    @Override
    protected void finished(Description description) {
        if (driver != null){
            driver.quit();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] captureScreenshot() {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            // No need to crash the tests if the screenshot fails
            e.printStackTrace();
        }
        return null;
    }
}
