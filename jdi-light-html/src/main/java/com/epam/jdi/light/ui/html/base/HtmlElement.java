package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.ui.html.common.*;

public class HtmlElement extends UIElement implements
    Text, Button, Checkbox, Image, Input, Link, ProgressBar, TextArea {
    public void check() {
        if (!isSelected())
            click();
    }
    public void uncheck() {
        if (isSelected())
            click();
    }
}
