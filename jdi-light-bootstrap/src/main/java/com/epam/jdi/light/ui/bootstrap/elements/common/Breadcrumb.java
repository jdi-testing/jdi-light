package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.map.MultiMap;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Breadcrumb web element please visit https://getbootstrap.com/docs/4.3/components/breadcrumb/
 *
 * Created by Olga Ivanova on 16.09.2019
 * Email: olga_ivanova@epam.com
 */

//APPROVED
public class Breadcrumb extends WebList {
    @Override
    public MultiMap<String, UIElement> elements(int minAmount) {
        return $$(".breadcrumb-item", this).elements(minAmount);
    }
    @JDIAction(level = DEBUG) @Override
    public UIElement get(int index) {
        return elements(index+1).get(index).value;
    }
    @Override
    public String selected() {
        return first(el -> el.hasClass("active")).getText();
    }
    @Override
    public boolean selected(String option) {
        return selected().equals(option);
    }
    @Override
    public int size() {
        return elements(0).size();
    }
}
