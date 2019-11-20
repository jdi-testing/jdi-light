package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.common.TextTypes.TEXT;

/**
 * To see an example of Alert web element please visit https://getbootstrap.com/docs/4.3/components/alerts/
 */

public class Alert extends UIBaseElement<TextAssert> implements IsText, HasClick, IBaseElement {

    public String abLocator = "#dismissible-alert-close-button";
    public String getText() { return text(TEXT); }

    @Override
    public TextAssert is() { return new TextAssert().set(this); }


    public UIElement dismissButton() {
        return linked(abLocator, "alert button");
    }

//    @Css("#dismissible-alert-close-button") public static Button alertButton;

}