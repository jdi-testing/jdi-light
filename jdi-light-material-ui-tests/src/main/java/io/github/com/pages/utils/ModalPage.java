package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class ModalPage extends WebPage {
    @UI("[id='simple-modal-description']")
    public static List<Text> modalTexts;
    @UI("button")
    public static List<Button> buttonModal;
}
