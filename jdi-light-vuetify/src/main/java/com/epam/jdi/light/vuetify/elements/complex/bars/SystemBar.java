package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> {

    @JDIAction("Get '{name}'s icons")
    public List<WebElement> icons () {
        return new ArrayList<>(core().findElements(By.cssSelector(".v-icon")));
    }

    @JDIAction("Get '{name}'s 'close' system bar content")
    public UIElement systemBar () {
        return core().find(".v-system-bar");
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }


}
