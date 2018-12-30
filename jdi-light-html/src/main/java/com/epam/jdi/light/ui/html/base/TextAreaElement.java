package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.common.TextArea;
import org.openqa.selenium.WebElement;

public class TextAreaElement extends HtmlElement implements TextArea {

    public TextAreaElement() { }
    public TextAreaElement(WebElement el) { super(el); }

    @JDIAction
    @Override
    public String getText() { return getAttribute("value"); }
}
