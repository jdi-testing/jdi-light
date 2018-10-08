package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.ui.html.base.BaseSelector;

import java.util.List;

public interface Checklist extends BaseSelector {
    void check(String... values);
    <TEnum extends Enum> void check(TEnum... values);
    void uncheck(int... indexes);
    List<String> checked();

}
