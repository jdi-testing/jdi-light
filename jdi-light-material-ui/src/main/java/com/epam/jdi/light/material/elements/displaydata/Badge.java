package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * To see an example of Badge web element please visit
 * https://mui.com/components/badges/
 */

public class Badge extends UIBaseElement<BadgeAssert> implements HasColor, IsText {

    @JDIAction("Get '{name}'s value")
    public String getCounterValue() {
        return text();
    }

    @JDIAction("Is '{name}' a dot")
    public boolean isDot() {
        return attr("class").contains("MuiBadge-dot");
    }

    @JDIAction("Is '{name}' invisible")
    public boolean isInvisible() {
        return attr("class").contains("invisible");
    }

    @JDIAction("Get '{name}'s position")
    public String getPosition() {
        return Arrays.stream(attr("class").split("[^a-zA-Z0-9]"))
                .filter(s -> s.startsWith("anchor")).collect(Collectors.joining());
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }
}
