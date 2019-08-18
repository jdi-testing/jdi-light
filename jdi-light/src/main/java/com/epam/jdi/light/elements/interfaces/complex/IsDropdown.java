package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public interface IsDropdown extends ISelector, HasLabel, HasAssert<UISelectAssert> {

}
