package ru.greatbit.seleniumtests.mainpage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.greatbit.seleniumtests.BaseTest;
import ru.greatbit.seleniumtests.elements.SearchPage;

import java.net.MalformedURLException;

public class GoogleMainPageTest extends BaseTest{

    private SearchPage searchPage;

    String BASE_URL = "https://google.com";

    @Before
    public void launchbrowser() throws MalformedURLException {
        searchPage = new SearchPage(driver);
    }

    @Test
    public void openGoogleTest() {
        driver.get(BASE_URL);
        searchPage.search("SomeRequest");
    }

    @After
    public void closeBrowser() {
         driver.quit();
    }
}
