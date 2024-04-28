package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.PaginationPageAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;

// @todo #5421 PaginationPage is not a part of Vue, should be removed
/**
 * Class describes the Page displayed in Pagination element
 * https://v2.vuetifyjs.com/en/components/paginations/
 */
public class PaginationPage extends UIBaseElement<PaginationPageAssert> implements HasColor {
    public PaginationPageAssert is() {
        return new PaginationPageAssert().set(this);
    }

}
