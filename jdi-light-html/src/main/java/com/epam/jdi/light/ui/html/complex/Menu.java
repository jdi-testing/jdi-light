package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.elements.base.JDIElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.ui.html.base.HtmlElement;

import java.util.List;

public interface Menu extends IList<HtmlElement>, JDIElement {
    void select(String... value);
    <TEnum extends Enum> void select(TEnum... value);
    String selected();
    List<String> values();
}
