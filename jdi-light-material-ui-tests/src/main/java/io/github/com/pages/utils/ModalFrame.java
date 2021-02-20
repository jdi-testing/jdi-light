package io.github.com.pages.utils;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.material.elements.utils.Modal;

public class ModalFrame {

    @Css("#root > div > button")
    public Modal modal;
}
