package com.epam.jdi.light.ui.html.interfaces.complex;

import com.epam.jdi.light.ui.html.base.BaseSelector;
import com.epam.jdi.light.ui.html.base.HasLabel;

import java.util.List;

// Implements TextField + Droplist
// https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_datalist
public interface MultiSelector extends BaseSelector, HasLabel {
    void check(String values);
    void check(String... values);
    <TEnum extends Enum> void check(TEnum... values);
    void check(int... values);

    void uncheck(String... values);
    <TEnum extends Enum> void uncheck(TEnum... values);
    void uncheck(int... indexes);
    String selected();

    List<String> checked();

}
