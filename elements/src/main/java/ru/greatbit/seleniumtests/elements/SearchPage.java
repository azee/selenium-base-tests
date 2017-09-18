package ru.greatbit.seleniumtests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by azee on 19.09.17.
 */
public class SearchPage {

    private SearchForm searchForm;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void search(String request) {
        searchForm.search(request);
    }

}
