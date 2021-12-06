package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.material.elements.utils.Modal;

public class ModalPage extends WebPage {

    @UI("//*[@role='presentation' and not(@aria-hidden='true')]")
    public static Modal modal;

    @UI("button")
    public static MaterialButton buttonModal;
}
