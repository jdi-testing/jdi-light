package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.bars.AppBarAssert;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see examples of App Bars web elements please visit https://vuetifyjs.com/en/components/app-bars
 *
 * The v-app-bar component is pivotal to any graphical user interface (GUI),
 * as it generally is the primary source of site navigation.
 *
 */

public class AppBar extends BasicBar<AppBar, AppBarAssert> {

    @JDIAction("Get '{name}' title")
    public UIElement getChecker() {
        return this.find(".v-input__control");
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String getCheckerStatus() {
        return getChecker().find("input").getAttribute("aria-checked");
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String getHeaderStatus() {
        return getHeader().getAttribute("class");
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String getHeaderStyle() {
        return getHeader().getAttribute("style");
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String getHeaderOpacity() {
        return getHeader().firstChild().getAttribute("style");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getTabs() {
        return this.finds(".v-tab");
    }

    @JDIAction("Get '{name}' text field")
    public UIElement getNavigationMenu() {
        return this.find(".v-navigation-drawer__content");
    }

    @JDIAction("{name} has icon")
    public boolean hasChecker() {
        Timer.waitCondition(this.getChecker()::isDisplayed);
        return getChecker().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasTabs() {
        Timer.waitCondition(this.getTabs()::isDisplayed);
        return getTabs().size() > 1;
    }

    @JDIAction("{name} has navigation menu")
    public boolean hasNavigationMenu() {
        Timer.waitCondition(this.getNavigationMenu()::isDisplayed);
        return getNavigationMenu().isDisplayed();
    }

    private WebElement getScrollingContainer() {
        return this.find(".overflow-y-auto").core().getFast();
    }

    public void scrollToBottom() {
        jsExecute("arguments[0].scroll(0, document.body.scrollHeight)", this.getScrollingContainer());
    }

    public void scrollToTop() {
        jsExecute("arguments[0].scroll(document.body.scrollHeight, 0)", this.getScrollingContainer());
    }

    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }

    public AppBarAssert has() {
        return this.is();
    }
}
