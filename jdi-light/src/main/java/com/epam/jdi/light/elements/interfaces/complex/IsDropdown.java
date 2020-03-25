package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsDropdown extends ISelector, HasLabel, HasAssert<UISelectAssert<?,?>> {
    default UIElement value() { return core(); }
}
