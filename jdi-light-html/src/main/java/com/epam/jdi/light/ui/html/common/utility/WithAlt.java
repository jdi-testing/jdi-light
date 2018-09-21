package com.epam.jdi.light.ui.html.common.utility;

import com.epam.jdi.light.elements.base.BaseElement;

public interface WithAlt extends BaseElement {
    default String getAlt() { return getAttribute("alt"); }
}
