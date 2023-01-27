package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.complex.Tabs;
import com.epam.jdi.light.vuetify.asserts.VuetifyTabsAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Tabs web element please visit https://vuetifyjs.com/en/components/tabs/
 */

public class VuetifyTabs extends Tabs implements HasColor, HasTheme {
    private UIElement tabList() {
        return find("[role='tablist']");
    }
    private UIElement tabs() {
        return find(".v-tabs");
    }
    private UIElement tabContent() {
        return find(".v-card__text");
    }
    private UIElement tabsSlider() {
        return tabs().find(".v-tabs-slider");
    }

    @Override
    @JDIAction("Get '{name}' list of tabs")
    public WebList list() {
        return finds("//*[@role='tab']");
    }

    @JDIAction("Get '{name}' list of menu items")
    public WebList menu() {
        return $$("[role='menu'] [role='menuitem']");
    }

    @JDIAction("Get '{name}' list of icons")
    public List<Icon> icons() {
        return finds(".v-icon").stream()
                .map((e) -> new Icon().setCore(Icon.class, e))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' next button")
    public SlideGroup navigation() {
        return new SlideGroup().setCore(SlideGroup.class, tabs().find(".v-slide-group"));
    }

    @JDIAction("Get '{name}' menu buttons")
    public List<VuetifyButton> menuButton() {
        return finds(".mdi-menu-down").stream()
                .map((e) -> new VuetifyButton().setCore(VuetifyButton.class, e))
                .collect(Collectors.toList());
    }

    @JDIAction("Get if '{name}' is selected")
    public boolean isSelected(int index) {
        return list().get(index).attr("aria-selected").equals("true");
    }

    @JDIAction("Get if '{name}' is fixed")
    public boolean isFixed() {
        return attr("class").contains("fixed-tabs");
    }

    @JDIAction("Get if '{name}' is grow")
    public boolean isGrow() {
        return tabs().attr("class").contains("grow");
    }

    @JDIAction("Get if '{name}' is right")
    public boolean isRight() {
        return tabs().attr("class").contains("right");
    }

    @JDIAction("Get if '{name}' is vertical")
    public boolean isVertical() {
        return tabs().attr("class").contains("vertical");
    }

    @JDIAction("Get if '{name}' is align with title")
    public boolean isAlignWithTitle() {
        return tabs().hasClass("v-tabs--align-with-title");
    }

    @JDIAction("Get '{name}' tab text content")
    public String getTabTextContent() {
        return tabContent().getText();
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        return tabList().css("color");
    }

    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return tabList().css("background-color");
    }

    @JDIAction("Get '{name}' theme")
    public String theme() {
        return tabs().classLike("theme--");
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

    @JDIAction("Check that '{name}' tab '{0}' has href")
    public boolean tabHasHref(int index) {
        return !getTabHref(index).isEmpty();
    }

    @JDIAction("Get '{name}' tab '{0}' href")
    public String getTabHref(int index) {
        return get(index).getAttribute("href");
    }

    @JDIAction("Check that '{name}' shows arrows on hover")
    public boolean showsArrows() {
        return tabList().hasClass("v-tabs-bar--show-arrows");
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
