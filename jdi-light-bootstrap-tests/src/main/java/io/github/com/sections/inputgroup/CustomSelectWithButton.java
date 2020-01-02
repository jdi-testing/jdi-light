package io.github.com.sections.inputgroup;

import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class CustomSelectWithButton extends Section {

    @UI("#inputGroupSelect03") public Selector selector;
    @UI("button") public Button button;

}
