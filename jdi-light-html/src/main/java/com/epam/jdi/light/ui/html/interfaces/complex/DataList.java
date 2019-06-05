package com.epam.jdi.light.ui.html.interfaces.complex;

import com.epam.jdi.light.ui.html.interfaces.common.TextField;

import java.util.List;

// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public interface DataList extends TextField {
    void select(String value);
    <TEnum extends Enum> void select(TEnum name);
    void select(int index);
    String selected();
    List<String> values();
    List<String> listEnabled();
    List<String> listDisabled();

}
