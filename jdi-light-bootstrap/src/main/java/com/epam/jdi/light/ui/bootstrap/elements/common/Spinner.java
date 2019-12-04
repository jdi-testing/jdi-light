package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.bootstrap.asserts.SpinnerAssert;
import com.epam.jdi.tools.Timer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To see an example of Spinner web element please visit https://getbootstrap.com/docs/4.3/components/spinners/
 */

public class Spinner extends UIBaseElement<SpinnerAssert> {

    public Spinner disappearAfter(int timeoutSec) {
        assertThat().displayed();
        new Timer(timeoutSec * 1000).wait(() -> core().isHidden());
        assertThat().hidden();
        return this;
    }
    public String getColor(){
        String str = core().getAttribute("class");
        Pattern pattern = Pattern.compile("text-.+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? str.substring(matcher.start(), matcher.end()) : "";
    }

    @Override
    public SpinnerAssert is() {
        return new SpinnerAssert().set(this);
    }
}
