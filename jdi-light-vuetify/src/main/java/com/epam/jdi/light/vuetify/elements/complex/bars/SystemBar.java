package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see examples of System Bar web elements please visit https://v2.vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> implements HasTheme, HasMeasurement {

    @JDIAction("Get '{name}' icons")
    public List<Icon> icons() {
        return core().finds(".v-icon").stream().map(this::castToIcon).collect(Collectors.toList());
    }

    @JDIAction("Get if '{name}' is lights out")
    public boolean isLightsOut() {
        return core().attr("class").contains("--lights-out");
    }

    @JDIAction("Get if '{name}' is window")
    public boolean isWindow() {
        return core().hasClass("v-system-bar--window");
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }


}
