package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.AppBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Image;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see examples of App Bar web elements please visit <a href="https://vuetifyjs.com/en/components/app-bars">...</a>
 */

public class AppBar extends BasicBar<AppBar, AppBarAssert> {
    private static final String IMAGE_LOCATOR = ".v-toolbar__image .v-image";
    private static final String OVERFLOW_WINDOW_LOCATOR = "//ancestor::div[contains(@class, 'v-card')]//div[contains" +
            "(@class, 'overflow-y-auto')]";
    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }

    private UIElement overflowWindow() {
        return find(OVERFLOW_WINDOW_LOCATOR);
    }

    @JDIAction("Check that '{name}' is scrolled")
    public boolean hasBackgroundImage() {
        return find(IMAGE_LOCATOR).isExist();
    }

    @JDIAction("Get '{name}' image")
    public Image backgroundImage() {
        if (hasBackgroundImage()) {
            return new Image().setCore(Image.class, find(IMAGE_LOCATOR));
        } else {
            throw new RuntimeException("Element doesn't have image");
        }
    }

    @JDIAction("Scroll '{name}' to bottom")
    public void scrollBarToBottom() {
        jsExecute("arguments[0].scroll(0, document.body.scrollHeight)", overflowWindow().getFast());
    }

    @JDIAction("Scroll '{name}' to top")
    public void scrollBarToTop() {
        jsExecute("arguments[0].scroll(document.body.scrollHeight, 0)", overflowWindow().getFast());
    }

    @JDIAction("Check that '{name}' is collapsible")
    public boolean isCollapsible() {
        return hasClass("v-toolbar--collapse");
    }

    @JDIAction("Check that '{name}' has image fading on scroll")
    public boolean hasImageFadingOnScroll() {
        return hasClass("v-app-bar--fade-img-on-scroll");
    }

    @JDIAction("Check that '{name}' is prominent")
    public boolean isProminent() {
        return hasClass("v-toolbar--prominent");
    }

    @JDIAction("Check that '{name}' is elevate on scroll")
    public boolean isElevateOnScroll() {
        return hasClass("v-app-bar--elevate-on-scroll");
    }

    @JDIAction("Check that '{name}' is scrolled")
    public boolean isScrolled() {
        return hasClass("v-app-bar--is-scrolled");
    }

    @JDIAction("Check that '{name}' shrinks on scroll")
    public boolean isShrinkOnScroll() {
        return hasClass("v-app-bar--shrink-on-scroll");
    }
}
