package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Badge;
import com.epam.jdi.light.vuetify.interfaces.asserts.AlignmentAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge>
        implements AlignmentAssert<BadgeAssert, Badge>, ColorAssert<BadgeAssert, Badge>,
        ITextAssert<BadgeAssert>, ThemeAssert<BadgeAssert, Badge>,
        TileAssert<BadgeAssert, Badge>{

    @JDIAction("Assert that '{name}' badge has icon '{0}'")
    public BadgeAssert icon(String iconName) {
        jdiAssert(element().icon().hasClass(iconName), Matchers.is(true),
                String.format("Badge is not '%s' icon", iconName));
        return this;
    }

    @JDIAction("Assert that '{name}' is icon")
    public BadgeAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Badge is not icon");
        return this;
    }

    @JDIAction("Assert that '{name}' is not icon")
    public BadgeAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Badge is icon");
        return this;
    }

    @JDIAction("Assert that '{name}' badge is dot")
    public BadgeAssert dot() {
        jdiAssert(element().isDot(), Matchers.is(true), "Badge is not dot");
        return this;
    }

    @JDIAction("Assert that '{name}' badge is not dot")
    public BadgeAssert notDot() {
        jdiAssert(element().isDot(), Matchers.is(false), "Badge is dot");
        return this;
    }

    @JDIAction("Assert that '{name}' is bordered")
    public BadgeAssert bordered() {
        jdiAssert(element().isBordered(), Matchers.is(true), "Badge is not bordered");
        return this;
    }

    @JDIAction("Assert that '{name}' is not bordered")
    public BadgeAssert notBordered() {
        jdiAssert(element().isBordered(), Matchers.is(false), "Badge is bordered");
        return this;
    }

    @JDIAction("Assert that '{name}' is inline")
    public BadgeAssert inline() {
        jdiAssert(element().isInline(), Matchers.is(true), "Badge is not inline");
        return this;
    }

    @JDIAction("Assert that '{name}' is not inline")
    public BadgeAssert notInline() {
        jdiAssert(element().isInline(), Matchers.is(false), "Badge is inline");
        return this;
    }

    @JDIAction("Assert that '{name}' is bottom")
    public BadgeAssert bottom() {
        jdiAssert(element().isBottom(), Matchers.is(true), "Badge is not bottom");
        return this;
    }

    @JDIAction("Assert that '{name}' is not bottom")
    public BadgeAssert notBottom() {
        jdiAssert(element().isBottom(), Matchers.is(false), "Badge is bottom");
        return this;
    }

    @JDIAction("Assert that '{name}' is overlapped")
    public BadgeAssert overlap() {
        jdiAssert(element().isOverlap(), Matchers.is(true), "Badge is not overlapped");
        return this;
    }

    @JDIAction("Assert that '{name}' is overlapped")
    public BadgeAssert notOverlap() {
        jdiAssert(element().isOverlap(), Matchers.is(false), "Badge is overlapped");
        return this;
    }

    @JDIAction("Assert that '{name}' is avatar")
    public BadgeAssert avatar() {
        jdiAssert(element().isAvatar(), Matchers.is(true), "Badge is not avatar");
        return this;
    }

    @JDIAction("Assert that '{name}' has not avatar")
    public BadgeAssert notAvatar() {
        jdiAssert(element().isAvatar(), Matchers.is(false), "Badge is avatar");
        return this;
    }

    @Override
    public BadgeAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
