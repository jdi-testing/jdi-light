package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.asserts.PaginationAssert;

/**
 * Created by Dmitrii Pavlov on 26.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class Pagination extends UIListBase<PaginationAssert> {

    @JDIAction("Check '{name}'")
    public void click() {
        uiElement.check();
    }

    @JDIAction("Select '{0}' in '{name}'")
    public UIElement get(int index) {
        return list().get(index - 1);
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void click(int index) {
        list().select(index - 1);
    }

    @Override
    public PaginationAssert is() {
        return new PaginationAssert().set(this);
    }
}
