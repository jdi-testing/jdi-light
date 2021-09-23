package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.AppBarAssert;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see an example of App Bar web element please visit https://vuetifyjs.com/en/components/app-bars
 *
 * The v-app-bar component is pivotal to any graphical user interface (GUI),
 * as it generally is the primary source of site navigation.
 *
 */

public class AppBar extends UIBaseElement<AppBarAssert> {

    @JDIAction("Get '{name}' 'checker' element")
    public UIElement getMenuButton() {
        return this.find(".mdi-menu");
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' title")
    public UIElement getChecker() {
        return this.find(".v-input__control");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getSearchButton() {
        return this.find(".mdi-magnify");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getHeartButton() {
        return this.find(".mdi-heart");
    }

    @JDIAction("Get '{name}' button")
    public UIElement getVerticalDotsButton() {
        return this.find(".mdi-dots-vertical");
    }

    @JDIAction("Get '{name}' text field")
    public UIElement getHeader() {
        return this.find("header");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getTabs() {
        return this.finds(".v-tab");
    }

    @JDIAction("Get '{name}' text field")
    public UIElement getNavigationMenu() {
        return this.find(".v-navigation-drawer__content");
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



//    @JDIAction("{name} has button")
//    public boolean hasButton() {
//        return getButton().isClickable();
//    }
//
    @JDIAction("{name} has icon")
    public boolean hasMenuButton() {
        return getMenuButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasTitle() {
        return getTitle().isVisible();
    }

    @JDIAction("{name} has icon")
    public boolean hasHiddenTitle() {
        return getTitle().isHidden();
    }

    @JDIAction("{name} has icon")
    public boolean hasChecker() {
        return getChecker().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasSearchButton() {
        return getSearchButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasHeartButton() {
        return getHeartButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasVerticalDotsButton() {
        return getVerticalDotsButton().isClickable();
    }

    @JDIAction("{name} has icon")
    public boolean hasTabs() {
        return getTabs().size() > 1;
    }

    @JDIAction("{name} has navigation menu")
    public boolean hasNavigationMenu() {
        return getNavigationMenu().isDisplayed();
    }








//    @JDIAction("{name} has buttons")
//    public boolean hasButtons() {
//        return getButtons().size()>1;
//    }
//






    private WebElement getScrollingContainer() {
        return this.find(".overflow-y-auto").core().getFast();
    }

    public void scrollPageToBottom() {
       jsExecute("window.scroll(0, document.body.scrollHeight)");
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
