package ru.greatbit.seleniumtests.common;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

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
        captureScreenshot(UUID.randomUUID().toString());
        super.failed(e, description);
    }

    @Override
    protected void finished(Description description) {
        if (driver != null){
            driver.quit();
        }
    }

    private void captureScreenshot(String fileName) {
        try {
            new File("target" + File.separator +  "surefire-reports" + File.separator).mkdirs(); // Insure directory is there
            FileOutputStream out = new FileOutputStream("target" + File.separator + "surefire-reports"+ File.separator + "screenshot-" + fileName + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            // No need to crash the tests if the screenshot fails
            e.printStackTrace();
        }
    }
}
