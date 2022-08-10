package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> {

    @JDIAction("Get '{name}'s icons")
    public List<UIElement> icons () {
        return core().findElements(By.cssSelector(".v-icon")).stream().map(UIElement::new).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}'s 'close' system bar content")
    public UIElement systemBar () {
        return core().find(By.xpath("//ancestor::div[contains(@class,'v-system-bar')]"));
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }


}
