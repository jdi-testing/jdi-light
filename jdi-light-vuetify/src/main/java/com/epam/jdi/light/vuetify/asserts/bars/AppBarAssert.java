package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert extends BasicBarAssert<AppBarAssert, AppBar> {
    @JDIAction(value = "Assert that '{name}' is collapsible", isAssert = true)
    public AppBarAssert collapsible() {
        jdiAssert(element().isCollapsible(), Matchers.is(true), "AppBar is not collapsible");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not collapsible", isAssert = true)
    public AppBarAssert notCollapsible() {
        jdiAssert(element().isCollapsible(), Matchers.is(false), "AppBar is collapsible");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has image fading on scroll", isAssert = true)
    public AppBarAssert imageFadingOnScroll() {
        jdiAssert(element().hasImageFadingOnScroll(), Matchers.is(true), "AppBar has no image fading " +
                "on scroll");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is on top position", isAssert = true)
    public AppBarAssert onTopPosition() {
        jdiAssert(element().isOnTopPosition(), Matchers.is(true), "AppBar is not on top position");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is on bottom position", isAssert = true)
    public AppBarAssert onBottomPosition() {
        jdiAssert(element().isOnBottomPosition(), Matchers.is(true), "AppBar is not on bottom position");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no image fading on scroll", isAssert = true)
    public AppBarAssert noImageFadingOnScroll() {
        jdiAssert(element().hasImageFadingOnScroll(), Matchers.is(false), "AppBar has image fading on scroll");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is prominent", isAssert = true)
    public AppBarAssert prominent() {
        jdiAssert(element().isProminent(), Matchers.is(true), "AppBar is not prominent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not prominent", isAssert = true)
    public AppBarAssert notProminent() {
        jdiAssert(element().isProminent(), Matchers.is(false), "AppBar is prominent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is elevate on scroll", isAssert = true)
    public AppBarAssert elevateOnScroll() {
        jdiAssert(element().isElevateOnScroll(), Matchers.is(true), "AppBar is not elevate on scroll");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not elevate on scroll", isAssert = true)
    public AppBarAssert notElevateOnScroll() {
        jdiAssert(element().isElevateOnScroll(), Matchers.is(false), "AppBar is elevate on scroll");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is scrolled", isAssert = true)
    public AppBarAssert scrolled() {
        jdiAssert(element().isScrolled(), Matchers.is(true), "AppBar is not scrolled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not scrolled", isAssert = true)
    public AppBarAssert notScrolled() {
        jdiAssert(element().isScrolled(), Matchers.is(false), "AppBar is scrolled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has background image", isAssert = true)
    public AppBarAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true), "AppBar has no background image");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no background image", isAssert = true)
    public AppBarAssert noBackgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(false), "AppBar has background image");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shrinks on scroll", isAssert = true)
    public AppBarAssert shrinkOnScroll() {
        jdiAssert(element().isShrinkOnScroll(), Matchers.is(true), "AppBar doesn't shrink on scroll");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' doesn't shrink on scroll", isAssert = true)
    public AppBarAssert notShrinkOnScroll() {
        jdiAssert(element().isShrinkOnScroll(), Matchers.is(false), "AppBar shrinks on scroll");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' bar is short", isAssert = true)
    public AppBarAssert isShort() {
        jdiAssert(element().isBarShort(), Matchers.is(true), "AppBar expected is not short");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' bar has usual size", isAssert = true)
    public AppBarAssert isUsualSize() {
        jdiAssert(element().isBarUsualSize(), Matchers.is(true), "AppBar expected doesn't have usual size");
        return this;
    }
}
