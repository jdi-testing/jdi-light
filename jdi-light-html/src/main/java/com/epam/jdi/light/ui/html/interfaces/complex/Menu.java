package com.epam.jdi.light.ui.html.interfaces.complex;

import com.epam.jdi.light.asserts.IHasAssert;
import com.epam.jdi.light.asserts.SelectAssert;
import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.light.elements.base.JDIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.ui.html.base.HtmlElement;

import java.util.List;

public interface Menu extends IList<HtmlElement>, JDIElement, IBaseElement, IHasAssert<SelectAssert> {
    void select(String... value);
    void select(String value);
    <TEnum extends Enum> void select(TEnum... value);
    <TEnum extends Enum> void select(TEnum value);
    void select(int... value);
    void select(int value);
    String selected();
    List<String> values();
    void hoverAndClick(String... values);
    void hoverAndClick(String values);
}
