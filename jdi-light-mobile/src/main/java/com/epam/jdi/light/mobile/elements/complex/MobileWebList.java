package com.epam.jdi.light.mobile.elements.complex;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.tools.func.JAction1;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class MobileWebList extends WebList {

    public MobileWebList(By locator) {
        super(locator);
    }

    @Override
    public UIElement core() {
        return new MobileUIElement(base());
    }

    @Override
    public MobileWebList setup(JAction1<JDIBase> setup) {
        return setup(MobileWebList.class, setup);
    }

    @Override
    protected SearchContext getDefaultContext() {
        return driver();
    }
}
