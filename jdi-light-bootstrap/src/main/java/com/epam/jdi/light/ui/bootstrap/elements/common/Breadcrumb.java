package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.tools.map.MapArray;


public class Breadcrumb extends UIBaseElement<UIAssert> implements IList<UIElement>, HasUIList, IClickable {
    @Css(".breadcrumb-item a") public WebList ancestorList;
    @Css(".breadcrumb-item.active") public UIElement currentItem;

    /**
     * Get all application elements
     *
     * @param minAmount
     */
    @Override
    public MapArray<String, UIElement> elements(int minAmount) {
        return null;
    }

    @Override
    public UIElement get(String value) {
        return null;
    }

    /**
     * @return Get value of Element
     */
    @Override
    public String getValue() {
        return null;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *                                       is not supported by this list
     */
    @Override
    public void clear() {

    }

    @Override
    public WebList list() {
        return null;
    }

    @Override
    public void click() {

    }
}
