package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.complex.Tabs;
import com.epam.jdi.light.vuetify.asserts.VueTabsAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Tabs web element please visit https://v2.vuetifyjs.com/en/components/tabs/
 */
// @todo #5324 refactor element. It should be an element with .v-tabs style in the name
public class VueTabs extends Tabs implements HasColor, HasTheme {
    private UIElement tabList() {
        return core().find("[role='tablist']");
    }
    private UIElement tabsSlider() {
        return core().find(".v-tabs-slider");
    }

    public SlideGroup slider() {
        return new SlideGroup().setCore(SlideGroup.class, core().find(".v-slide-group"));
    }

    public UIElement content() {
        return core().find(".v-tabs-bar__content");
    }

    @Override
    @JDIAction("Get '{name}' list of tabs")
    public WebList list() {
        return core().finds(".//*[@role='tab']");
    }

    @JDIAction("Get if '{name}' is selected")
    public boolean isSelected(int index) {
        return list().get(index).attr("aria-selected").equals("true");
    }

    @JDIAction("Get if '{name}' is fixed")
    public boolean isFixed() {
        return core().attr("class").contains("fixed-tabs");
    }

    @JDIAction("Get if '{name}' is grow")
    public boolean isGrow() {
        return core().attr("class").contains("grow");
    }

    @JDIAction("Get if '{name}' is right")
    public boolean isRight() {
        return core().attr("class").contains("right");
    }

    @JDIAction("Get if '{name}' is vertical")
    public boolean isVertical() {
        return core().attr("class").contains("vertical");
    }

    @JDIAction("Get if '{name}' is align with title")
    public boolean isAlignWithTitle() {
        return core().hasClass("v-tabs--align-with-title");
    }

    @Override
    @JDIAction("Get '{name}' color")
    public String color() {
        return tabList().css("color");
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return tabList().css("background-color");
    }

    @JDIAction("Get '{name}' theme")
    public int tabsSliderSize() {
        return Integer.parseInt(tabsSlider().css("tab-size"));
    }

    @JDIAction("Get '{name}' theme")
    public String tabsSliderColor() {
        return tabsSlider().css("color");
    }

    @JDIAction("Get if '{name}' tab '{0}' is disabled")
    public boolean isTabDisabled(int index) {
        return get(index).hasClass("v-tab--disabled");
    }

    @JDIAction("Get if '{name}' tab '{0}' has href")
    public boolean tabHasHref(int index) {
        return !getTabHref(index).isEmpty();
    }

    @JDIAction("Get '{name}' tab '{0}' href")
    public String getTabHref(int index) {
        return get(index).getAttribute("href");
    }

    @JDIAction("Get if '{name}' shows arrows on hover")
    public boolean showsArrows() {
        return tabList().hasClass("v-tabs-bar--show-arrows");
    }

    @Override
    public VueTabsAssert is() {
        return new VueTabsAssert().set(this);
    }

    @Override
    public VueTabsAssert has() {
        return is();
    }
}
