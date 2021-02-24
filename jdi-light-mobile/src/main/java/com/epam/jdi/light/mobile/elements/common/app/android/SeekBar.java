package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class SeekBar extends MobileAppBaseElement<TextAssert> implements HasTouchActions, IsText {
    @JDIAction("Set {0} as value of '{name}'")
    public void setSliderValue(String value) {
        core().sendKeys(value);
    }

    @JDIAction("Set the minimum value for '{name}'")
    public void setMinimumValue() {
        setSliderValue("0");
    }

    @JDIAction("Set the maximum value for '{name}'")
    public void setMaximumValue() {
        executeDriverMethod(PerformsTouchActions.class, (PerformsTouchActions driver) ->
            new TouchAction<>(driver)
                    .press(PointOption.point(getLocation().getX() + getSize().getWidth() - 1, getLocation().getY()))
                    .release()
                    .perform()
        );
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
