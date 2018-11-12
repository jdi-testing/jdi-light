package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.ui.html.base.HtmlElement;

import java.util.List;

public interface Menu extends IList<HtmlElement> {
    void select(String... value);
    <TEnum extends Enum> void select(TEnum value);
    String isSelected();
    List<String> values();
}
