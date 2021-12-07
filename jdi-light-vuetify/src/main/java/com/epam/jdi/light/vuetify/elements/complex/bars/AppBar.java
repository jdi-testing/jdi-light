package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.bars.AppBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see examples of App Bar web elements please visit https://vuetifyjs.com/en/components/app-bars
 */

public class AppBar extends BasicBar<AppBar, AppBarAssert> {

    @JDIAction("Get '{name}'s checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(".v-input__control"));
    }

    @JDIAction("Does '{name}' have clickable tabs")
    public boolean hasClickableTabs() {
        WebList tabs = finds(".v-tab");
        if (tabs.size() > 0) {
            return tabs.stream().allMatch(UIElement::isClickable);
        } else {
            throw exception("Bar does not contain tabs");
        }
    }

    @JDIAction("Does '{name}' have hidden header")
    public boolean hasHiddenHeader() {
        return getHeader().getAttribute("style").contains("translateY(-128px)");
    }

    @JDIAction("Does '{name}' have visible header")
    public boolean hasVisibleHeader() {
        return getHeader().getAttribute("style").contains("translateY(0px)");
    }

    @JDIAction("Get '{name}'s header's height")
    public String getHeaderHeight() {
        return getHeader().getCssValue("height");
    }

    @JDIAction("Get '{name}'s header's opacity")
    public Integer getHeaderOpacity() {
        return Integer.valueOf(getHeader().firstChild().getCssValue("opacity"));
    }

    @JDIAction("Does '{name}'s header have hidden shadow")
    public boolean hasHiddenHeaderShadow() {
        return getHeader().attr("class").contains("hide-shadow");
    }

    @JDIAction("Does '{name}'s header have visible shadow")
    public boolean hasVisibleHeaderShadow() {
        return getHeader().attr("class").contains("elevate-on-scroll") &&
                getHeader().attr("class").contains("is-scrolled");
    }

    @JDIAction("Does '{name}' have navigation menu")
    public boolean hasNavigationMenu() {
        UIElement navigationMenu = find(".v-navigation-drawer__content");
        return navigationMenu.isDisplayed();
    }

    private WebElement getScrollingContainer() {
        return find(".overflow-y-auto").core().getFast();
    }

    @JDIAction("Scroll '{name}' to bottom")
    public void scrollBarToBottom() {
        jsExecute("arguments[0].scroll(0, document.body.scrollHeight)", getScrollingContainer());
    }

    @JDIAction("Scroll '{name}' to top")
    public void scrollBarToTop() {
        jsExecute("arguments[0].scroll(document.body.scrollHeight, 0)", getScrollingContainer());
    }

    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }
}
