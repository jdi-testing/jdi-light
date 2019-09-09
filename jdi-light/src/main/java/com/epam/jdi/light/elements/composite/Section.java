package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IListBase;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

/**
 * Created by Roman Iovlev on 29.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Section extends UIBaseElement<UIAssert> implements PageObject, IListBase {
    public Section() {
        initElements(this);
    }
}
