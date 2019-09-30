package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class ButtonAddons extends Section {
    @Css("#button-addon1")
    public Button button1;
    @XPath("//*[@aria-describedby='button-addon1']")
    public TextField input1;
//    @UI("//*[@aria-describedby='button-addon2']")
//    public Text text2;
//    @UI("#button-addon2")
//    public Button button2;
}
