package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.AppBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Image;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see examples of App Bar web elements please visit <a href="https://v2.vuetifyjs.com/en/components/app-bars">...</a>
 */

public class AppBar extends BasicBar<AppBar, AppBarAssert> {
    private static final String IMAGE_LOCATOR = ".v-toolbar__image .v-image";
    private static final String OVERFLOW_WINDOW_LOCATOR = "//ancestor::div[contains(@class, 'v-card')]//div[contains" +
            "(@class, 'overflow-y-auto')]";
    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }

    private UIElement overflowWindow() {
        return core().find(OVERFLOW_WINDOW_LOCATOR);
    }

    @JDIAction("Get if '{name}' is scrolled")
    public boolean hasBackgroundImage() {
        return core().find(IMAGE_LOCATOR).isExist();
    }

    @JDIAction("Get '{name}' image")
    public Image backgroundImage() {
        if (hasBackgroundImage()) {
            return new Image().setCore(Image.class, core().find(IMAGE_LOCATOR));
        } else {
            throw runtimeException("Element doesn't have image");
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

    @JDIAction("Get if '{name}' is collapsible")
    public boolean isCollapsible() {
        return core().hasClass("v-toolbar--collapse");
    }

    @JDIAction("Get if '{name}' has image fading on scroll")
    public boolean hasImageFadingOnScroll() {
        return core().hasClass("v-app-bar--fade-img-on-scroll");
    }

    @JDIAction("Get if '{name}' is on top position")
    public boolean isOnTopPosition() {
        return !core().hasClass("v-app-bar--is-scrolled") || core().attr("style").contains(BarHeight.THRESHOLD.height);
    }

    @JDIAction("Get if '{name}' is on bottom position")
    public boolean isOnBottomPosition() {
        return core().attr("style").contains(BarHeight.SHORT.height);
    }

    @JDIAction("Get if '{name}' is prominent")
    public boolean isProminent() {
        return core().hasClass("v-toolbar--prominent");
    }

    @JDIAction("Get if '{name}' is elevate on scroll")
    public boolean isElevateOnScroll() {
        return core().hasClass("v-app-bar--elevate-on-scroll");
    }

    @JDIAction("Get if '{name}' is scrolled")
    public boolean isScrolled() {
        return core().hasClass("v-app-bar--is-scrolled");
    }

    @JDIAction("Get if '{name}' shrinks on scroll")
    public boolean isShrinkOnScroll() {
        return core().hasClass("v-app-bar--shrink-on-scroll");
    }

    @JDIAction("Get if '{name}' is short")
    public boolean isBarShort() {
        return core().attr("style").contains(BarHeight.SHORT.height);
    }

    @JDIAction("Get if '{name}' has usual size")
    public boolean isBarUsualSize() {
        return core().attr("style").contains(BarHeight.USUAL.height);
    }

    public enum BarHeight {

        USUAL("64px"),
        THRESHOLD("128px"),
        SHORT("56px");

        private final String height;

        BarHeight(String height) {
            this.height = height;
        }
    }
}
