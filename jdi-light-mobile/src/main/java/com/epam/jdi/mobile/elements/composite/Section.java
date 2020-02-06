package com.epam.jdi.mobile.elements.composite;

import com.epam.jdi.mobile.asserts.generic.UIAssert;
import com.epam.jdi.mobile.elements.base.UIBaseElement;
import com.epam.jdi.mobile.elements.interfaces.base.IListBase;
import com.epam.jdi.mobile.elements.interfaces.composite.PageObject;

import static com.epam.jdi.mobile.elements.init.PageFactory.initElements;

/**
 * Created by Roman Iovlev on 29.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Section extends UIBaseElement<UIAssert> implements PageObject, IListBase {
    public Section() {
        initElements(this);
    }
}
