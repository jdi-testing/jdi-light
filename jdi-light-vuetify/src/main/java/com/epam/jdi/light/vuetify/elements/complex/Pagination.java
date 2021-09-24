package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.List;

public class Pagination extends UIBaseElement<UISelectAssert<UISelectAssert<?,?>, JList<Button>>> implements IList<Button> {

    @UI(".v-pagination__navigation[1]")
    public Button leftNavigation;

    @UI(".v-pagination__navigation[2]")
    public Button rightNavigation;

    @UI(".v-pagination__item")
    public JList<Button> buttons;

    @Override
    public UISelectAssert<UISelectAssert<?,?>, JList<Button>> is() {
        return buttons.is();
    }

    @Override
    public boolean isEnabled() {
        return !core().hasClass("v-pagination--disabled");
    }

    @Override
    public List<Button> elements(int minAmount) {
        return buttons.elements(minAmount);
    }

    @Override
    public Button get(String value) {
        return buttons.get(value);
    }

    @Override
    public String getValue() {
        return buttons.getValue();
    }

    @Override
    public int getStartIndex() {
        return buttons.getStartIndex();
    }

    @Override
    public void setStartIndex(int i) {
        buttons.setStartIndex(i);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
