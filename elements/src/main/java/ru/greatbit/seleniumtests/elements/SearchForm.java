package ru.greatbit.seleniumtests.elements;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by azee on 19.09.17.
 */

@Name("Search form")
@FindBy(xpath = "//form")
public class SearchForm extends HtmlElement {

    @Name("Search request input")
    @FindBy(id = "lst-ib")
    private TextInput requestInput;

    @Name("Search button")
    @FindBy(name = "btnK")
    private Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}
