package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;

public class TextFieldPage extends WebPage {

    @UI("//*[@id=\"formProps\"]/div[1]/div[7]")
    public TextField standartTextField;
}
