package com.epam.jdi.light.material.elements.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.navigation.LinkAssert;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.base.HasColor;

/**
 * To see an example of Links web element please visit
 * https://mui.com/components/links/
 */

public class Link extends Typography implements HasColor, HasClick {

    @JDIAction("Is '{name}' underlined")
    public boolean isUnderlined() {
        return css("text-decoration-line").equals("underline");
    }

    @JDIAction("Is '{name}' not underlined")
    public boolean isNotUnderlined() {
        return !isUnderlined();
    }

    @Override
    public LinkAssert assertThat() {
        return is();
    }

    @Override
    public LinkAssert is() {
        LinkAssert linkAssert = new LinkAssert();
        linkAssert.set(this);
        return linkAssert;
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
