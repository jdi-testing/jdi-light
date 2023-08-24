package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.Ripple;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class RipplePage extends NewAngularPage {

    @UI("#ripple-centered-checkbox-input")
    public static Checkbox rippleCenteredCheckbox;
    @UI("#ripple-disabled-checkbox-input")
    public static Checkbox rippleDisabledCheckbox;
    @UI("#ripple-unbounded-checkbox-input")
    public static Checkbox rippleUnboundedCheckbox;

    public static Ripple rippleContainer;
}
