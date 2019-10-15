package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.ui.bootstrap.asserts.ListGroupAssert;

/**
 * Created by Dmitrii Pavlov on 25.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class ListGroup extends UIListBase<ListGroupAssert> implements IsButton {

    @JDIAction("Check '{name}'")
    public void select() {
        uiElement.check();
    }

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return uiElement.isSelected();
    }

    @JDIAction("Select '{0}' in '{name}'")
    public UIElement get(int index) {
        return list().get(index);
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        list().select(index);
    }

    @Override
    public ListGroupAssert is() {
        return new ListGroupAssert().set(this);
    }
}
