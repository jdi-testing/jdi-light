package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.jdiai.tools.HasStartIndex;

/**
 * Represents an element that has an {@link DropdownExpand}
 */
public interface IsDropdown extends ISelector, HasLabel, HasAssert<DropdownAssert>, HasStartIndex {

    default UIElement value() {
        return core();
    }

    boolean isExpanded();

    boolean isCollapsed();
}
