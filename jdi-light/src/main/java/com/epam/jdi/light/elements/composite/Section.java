package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBase;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

/**
 * Created by Roman Iovlev on 29.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Section extends UIBase<UIAssert> implements PageObject {
    public Section() {
        initElements(this);
    }
}
