package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class ButtonAddons extends Section {
// Button addons locators
    @Css("#button-addon1")
    public Button button1;
    @XPath("//*[@aria-describedby='button-addon1']")
    public TextField input1;
//
    @XPath("//*[@aria-describedby='button-addon2']")
    public TextField input2;
    @Css("#button-addon2")
    public Button button2;
//
    @Css("#button-addon3 > button")
    public ListGroup anyButtons;
    @XPath("//*[@aria-describedby='button-addon3']")
    public TextField input3;
//
    @XPath("//*[@aria-describedby='button-addon4']")
    public TextField input4;
    @Css("#button-addon4 > button")
    public ListGroup nextButtons;
}
