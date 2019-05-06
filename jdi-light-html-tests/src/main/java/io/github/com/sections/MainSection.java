package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.TextField;
import io.github.com.pages.BasePage;
import org.openqa.selenium.WebElement;

public class MainSection extends BasePage {
    @UI("#name")
    TextField name;

    @UI("#last-name")
    public TextField lastName;

    @UI("#position")
    public static TextField position;

    @UI(".dropdown.salad")
    public WebElement wather;

    @UI("#passport")
    public static  WebElement passport;

    @UI("#religion")
    WebElement religion;


}
