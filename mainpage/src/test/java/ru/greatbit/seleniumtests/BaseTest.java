package ru.greatbit.seleniumtests;

import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.isEmpty;


/**
 * Created by azee on 26.09.17.
 */
public class BaseTest {

    private final String WEBDRIVER_ENDPOINT_PLACEHOLDER = "webdriver.endpoint";
    private final String BASE_URL_PLACEHOLDER = "base.url";
    private final String BROWSER_PLACEHOLDER = "browser";
    private final String BROWSER_VERSION_PLACEHOLDER = "browser.version";

    protected String WEBDRIVER_ENDPOINT = setProperty("http://localhost:4444/wd/hub", WEBDRIVER_ENDPOINT_PLACEHOLDER);
    protected String BASE_URL = setProperty("https://google.com", BASE_URL_PLACEHOLDER);
    protected String BROWSER = setProperty("firefox", BROWSER_PLACEHOLDER);
    protected String VERSION = setProperty("latest", BROWSER_VERSION_PLACEHOLDER);

    protected WebDriver driver;

    @Before
    public void baseSetUp() throws MalformedURLException {
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName(BROWSER);
        browser.setVersion(VERSION);

        browser.setCapability("enableVNC", true);
        browser.setCapability("screenResolution", "1920x1080x24");

        driver = new RemoteWebDriver(
                URI.create(WEBDRIVER_ENDPOINT).toURL(),
                browser
        );

        // Puts an Implicit wait, Will wait for 10 seconds before throwing
        // exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1920, 1080));

    }

    private String setProperty(String defaultValue, String placeholder){
        return isEmpty(System.getProperty(placeholder)) ? defaultValue : System.getProperty(placeholder);
    }
}
