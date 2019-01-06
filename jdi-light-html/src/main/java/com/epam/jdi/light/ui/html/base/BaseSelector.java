package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.SelectAssert;
import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.interfaces.SetValue;

import java.util.List;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface BaseSelector extends BaseElement, SetValue {
    void select(String value);
    <TEnum extends Enum> void select(TEnum value);
    void select(int index);
    List<String> values();
    List<String> listEnabled();
    List<String> listDisabled();

    SelectAssert is();
    SelectAssert assertThat();
}
