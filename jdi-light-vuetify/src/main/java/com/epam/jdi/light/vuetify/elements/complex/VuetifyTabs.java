package com.epam.jdi.light.vuetify.elements.complex;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.complex.Tabs;
import com.epam.jdi.light.vuetify.asserts.VuetifyTabsAssert;

/**
 * To see an example of Tabs web element please visit https://vuetifyjs.com/en/components/tabs/
 */

public class VuetifyTabs extends Tabs {

    private UIElement tabs() {
        return find(".v-tabs");
    }

    @Override
    public WebList list() {
        return finds("//*[@role='tab']");
    }

    public WebList menu() {
        return $$("[role='menu'] [role='menuitem']");
    }

    public WebList icons() {
        return finds(".v-icon");
    }

    public UIElement next() {
        return find(".v-slide-group__next");
    }

    public UIElement prev() {
        return find(".v-slide-group__prev");
    }

    public UIElement menuButton() {
        return find(".mdi-menu-down");
    }

    public boolean isSelected(int index) {
        return list().get(index).attr("aria-selected").equals("true");
    }

    public boolean isFixed() {
        return attr("class").contains("fixed-tabs");
    }

    public boolean isGrow() {
        return tabs().attr("class").contains("grow");
    }

    public boolean isRight() {
        return tabs().attr("class").contains("right");
    }

    public boolean isVertical() {
        return tabs().attr("class").contains("vertical");
    }

    @Override
    public VuetifyTabsAssert is() {
        return new VuetifyTabsAssert().set(this);
    }

    @Override
    public VuetifyTabsAssert has() {
        return is();
    }

}
