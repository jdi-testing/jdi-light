package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.ui.html.base.BaseSelector;

import java.util.List;

public interface Checklist extends BaseSelector {
    void check(String... values);
    <TEnum extends Enum> void check(TEnum... values);
    void check(int... values);

    void uncheck(String... values);
    <TEnum extends Enum> void uncheck(TEnum... values);
    void uncheck(int... indexes);
    void uncheckAll();

    void select(String... value);
    <TEnum extends Enum> void select(TEnum... value);
    void select(int... index);
    String selected();

    List<String> checked();
}
