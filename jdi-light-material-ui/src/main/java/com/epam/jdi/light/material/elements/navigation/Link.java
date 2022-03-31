package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.navigation.LinkAssert;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

/**
 * Represents link MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/links/">Link MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Link extends Typography implements HasColor, HasClick {

    /**
     * Checks if the link is underlined or not.
     *
     * @return {@code true} if the link is underlined, otherwise {@code false}
     */
    @JDIAction("Is '{name}' underlined")
    public boolean isUnderlined() {
        return core().css("text-decoration-line").equals("underline");
    }

    /**
     * Checks if the link is underlined or not.
     *
     * @return {@code true} if the link is not underlined, otherwise {@code false}
     */
    @JDIAction("Is '{name}' not underlined")
    public boolean isNotUnderlined() {
        return !isUnderlined();
    }

    @Override
    public LinkAssert is() {
        LinkAssert linkAssert = new LinkAssert();
        linkAssert.set(this);
        return linkAssert;
    }

    @Override
    public LinkAssert assertThat() {
        return is();
    }

    @Override
    public LinkAssert has() {
        return is();
    }

    @Override
    public LinkAssert waitFor() {
        return is();
    }

    @Override
    public LinkAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public LinkAssert shouldBe() {
        return is();
    }

    @Override
    public LinkAssert verify() {
        assertSoft();
        return is();
    }
}
