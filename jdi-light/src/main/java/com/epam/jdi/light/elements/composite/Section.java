package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

/**
 * Created by Roman Iovlev on 29.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Section extends UIBaseElement<TextAssert> implements PageObject, ICoreElement {
    public Section() {
        initElements(this);
    }
}
