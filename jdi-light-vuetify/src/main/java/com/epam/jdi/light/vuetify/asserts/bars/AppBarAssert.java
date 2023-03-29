package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert extends BasicBarAssert<AppBarAssert, AppBar> {
    @JDIAction("Assert that '{name}' is collapsible")
    public AppBarAssert collapsible() {
        jdiAssert(element().isCollapsible(), Matchers.is(true), "Element is not collapsible");
        return this;
    }

    @JDIAction("Assert that '{name}' is not collapsible")
    public AppBarAssert notCollapsible() {
        jdiAssert(element().isCollapsible(), Matchers.is(false), "Element is collapsible");
        return this;
    }

    @JDIAction("Assert that '{name}' has image fading on scroll")
    public AppBarAssert imageFadingOnScroll() {
        jdiAssert(element().hasImageFadingOnScroll(), Matchers.is(true), "Element has no image fading " +
                "on scroll");
        return this;
    }

    @JDIAction("Assert that '{name}' is on top position")
    public AppBarAssert onTopPosition() {
        jdiAssert(element().isOnTopPosition(), Matchers.is(true), "Element is not scrolled on top");
        return this;
    }

    @JDIAction("Assert that '{name}' is on bottom position")
    public AppBarAssert onBottomPosition() {
        jdiAssert(element().isOnBottomPosition(), Matchers.is(true), "Element is not scrolled till bottom");
        return this;
    }

    @JDIAction("Assert that '{name}' has no image fading on scroll")
    public AppBarAssert noImageFadingOnScroll() {
        jdiAssert(element().hasImageFadingOnScroll(), Matchers.is(false), "Element has image fading on " +
                "scroll");
        return this;
    }

    @JDIAction("Assert that '{name}' is prominent")
    public AppBarAssert prominent() {
        jdiAssert(element().isProminent(), Matchers.is(true), "Element is not prominent");
        return this;
    }

    @JDIAction("Assert that '{name}' is not prominent")
    public AppBarAssert notProminent() {
        jdiAssert(element().isProminent(), Matchers.is(false), "Element is prominent");
        return this;
    }

    @JDIAction("Assert that '{name}' is elevate on scroll")
    public AppBarAssert elevateOnScroll() {
        jdiAssert(element().isElevateOnScroll(), Matchers.is(true), "Element is not elevate on scroll");
        return this;
    }

    @JDIAction("Assert that '{name}' is not elevate on scroll")
    public AppBarAssert notElevateOnScroll() {
        jdiAssert(element().isElevateOnScroll(), Matchers.is(false), "Element is elevate on scroll");
        return this;
    }

    @JDIAction("Assert that '{name}' is scrolled")
    public AppBarAssert scrolled() {
        jdiAssert(element().isScrolled(), Matchers.is(true), "Element is not scrolled");
        return this;
    }

    @JDIAction("Assert that '{name}' is not scrolled")
    public AppBarAssert notScrolled() {
        jdiAssert(element().isScrolled(), Matchers.is(false), "Element is scrolled");
        return this;
    }

    @JDIAction("Assert that '{name}' has background image")
    public AppBarAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true), "Element has no background image");
        return this;
    }

    @JDIAction("Assert that '{name}' has no background image")
    public AppBarAssert noBackgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(false), "Element has background image");
        return this;
    }

    @JDIAction("Assert that '{name}' shrinks on scroll")
    public AppBarAssert shrinkOnScroll() {
        jdiAssert(element().isShrinkOnScroll(), Matchers.is(true), "Element doesn't shrink on scroll");
        return this;
    }

    @JDIAction("Assert that '{name}' doesn't shrink on scroll")
    public AppBarAssert notShrinkOnScroll() {
        jdiAssert(element().isShrinkOnScroll(), Matchers.is(false), "Element shrinks on scroll");
        return this;
    }

    @JDIAction("Assert that '{name}' bar is short")
    public AppBarAssert isShort() {
        jdiAssert(element().isBarShort(), Matchers.is(true), "Current bar expected to be short!");
        return this;
    }

    @JDIAction("Assert that '{name}' bar has usual size")
    public AppBarAssert isUsualSize() {
        jdiAssert(element().isBarUsualSize(), Matchers.is(true), "Current bar expected to be usual size!");
        return this;
    }
}
