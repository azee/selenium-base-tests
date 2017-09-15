package ru.greatbit.seleniumtests.mainpage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class GoogleMainPageTest {
    public WebDriver driver;

    String BASE_URL = "https://google.com";

    @Before
    public void launchbrowser() throws MalformedURLException {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("60.0");

        browser.setCapability("enableVNC", true);
        browser.setCapability("screenResolution", "1920x1080x24");

        driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                browser
        );


        // Puts an Implicit wait, Will wait for 10 seconds before throwing
        // exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void openGoogleTest() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Some request");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        driver.findElement(By.xpath("//input[@class='appbar']"));
    }

    @After
    public void closeBrowser() {
         driver.quit();
    }
}
