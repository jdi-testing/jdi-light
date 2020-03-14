package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.*;

/**
 * To see an example of Breadcrumb web element please visit https://getbootstrap.com/docs/4.3/components/breadcrumb/
 *
 * Created by Olga Ivanova on 16.09.2019
 * Email: olga_ivanova@epam.com
 */

public class Breadcrumb extends UIListBase<UISelectAssert<UISelectAssert<?,?>, WebList>> {
    @Override
    public WebList list() {
        return $$(".breadcrumb-item", this);
    }
    public String selected() {
        return list().first(el -> el.hasClass("active")).getText();
    }
    @Override
    public boolean selected(String option) {
        return selected().equals(option);
    }
}
