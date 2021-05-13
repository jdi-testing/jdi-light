package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import com.epam.jdi.light.mobile.interfaces.IMenu;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class Menu extends MobileAppBaseElement<TextAssert> implements PageObject, IsText, HasTouchActions, IMenu {

    public Menu() {
        initElements(this);
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
