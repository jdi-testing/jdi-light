package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.bars.AppBarAssert;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see examples of App Bar web elements please visit https://vuetifyjs.com/en/components/app-bars
 */

public class AppBar extends BasicBar<AppBar, AppBarAssert> {

    private UIElement getChecker() {
        return this.find(".v-input__control");
    }

    @JDIAction("{name} has checker")
    public boolean hasChecker() {
        Timer.waitCondition(this.getChecker()::isDisplayed);
        return getChecker().isClickable();
    }

    @JDIAction("{name} has clickable tabs")
    public boolean hasClickableTabs() throws Exception {
        WebList tabs = this.finds(".v-tab");
        Timer.waitCondition(tabs::isDisplayed);
        if (tabs.size() > 0) {
            return tabs.stream().allMatch(UIElement::isClickable);
        } else throw new Exception("Bar does not have tabs");
    }

    @JDIAction("{name} has hidden header")
    public boolean hasHiddenHeader() {
        return this.getHeader().getAttribute("style").contains("translateY(-128px)");
    }

    @JDIAction("{name} has hidden header")
    public boolean hasVisibleHeader() {
        return this.getHeader().getAttribute("style").contains("translateY(0px)");
    }

    @JDIAction("Get {name} header's style")
    public String hasHeaderHeight() {
        return getHeader().getCssValue("height");
    }

    @JDIAction("Get {name} header's opacity")
    public Integer hasHeaderOpacity() {
        return Integer.valueOf(getHeader().firstChild().getCssValue("opacity"));
    }

    @JDIAction("{name} header has hidden shadow")
    public boolean hasHiddenHeaderShadow() {
        return this.getHeader().getCssValue("box-shadow").contains("0px 0px 0px 0px");
    }

    @JDIAction("{name} header has visible shadow")
    public boolean hasVisibleHeaderShadow() {
        return this.getHeader().getCssValue("box-shadow").contains("0px 4px 5px 0px");
    }

    @JDIAction("{name} has navigation menu")
    public boolean hasNavigationMenu() {
        UIElement navigationMenu = this.find(".v-navigation-drawer__content");
        Timer.waitCondition(navigationMenu::isDisplayed);
        return navigationMenu.isDisplayed();
    }

    @JDIAction("Get '{name}' checker")
    public boolean checkerChecked() {
        return Boolean.parseBoolean(getChecker().find("input").getAttribute("aria-checked"));
    }

    @JDIAction("Get '{name}' checker")
    public boolean checkerUnchecked() {
        return !checkerChecked();
    }

    public void checkerCheck() throws Exception {
        if(checkerUnchecked()) {
            Timer.waitCondition(this::checkerUnchecked);
            this.getChecker().click();
        } else throw new Exception("Checker is already checked");
    }

    public void checkerUncheck() throws Exception {
        if(checkerChecked()) {
            Timer.waitCondition(this::checkerChecked);
            this.getChecker().click();
        } else throw new Exception("Checker is already unchecked");
    }

    private WebElement getScrollingContainer() {
        return this.find(".overflow-y-auto").core().getFast();
    }

    public void scrollBarToBottom() {
        jsExecute("arguments[0].scroll(0, document.body.scrollHeight)", this.getScrollingContainer());
    }

    public void scrollBarToTop() {
        jsExecute("arguments[0].scroll(document.body.scrollHeight, 0)", this.getScrollingContainer());
    }

    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }

    public AppBarAssert has() {
        return this.is();
    }
}
