package com.epam.jdi.light.ui.html.complex;

import com.epam.jdi.light.ui.html.base.BaseSelector;
import com.epam.jdi.light.ui.html.base.HasLabel;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface Dropdown extends BaseSelector, HasLabel {
    // TODO add Droplist<TEnum extends Enum>
    void select(String value);
    <TEnum extends Enum> void select(TEnum value);
    void select(int index);
    String selected();

}
