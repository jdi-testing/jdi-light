package com.epam.jdi.light.vuetify.elements.complex.bars;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import org.openqa.selenium.By;

public class IconSystemBar extends SystemBar {

    @JDIAction("Get '{name}'s 'Wi-Fi' icon")
    public Icon wiFiIcon() {
        return castToIcon(find(".mdi-wifi-strength-4"));
    }

    @JDIAction("Get '{name}'s 'signal' icon")
    public Icon signalIcon() {
        return castToIcon(find(".mdi-signal-cellular-outline"));
    }

    @JDIAction("Get '{name}'s 'battery' icon")
    public Icon batteryIcon() {
        return castToIcon(find(".mdi-battery"));
    }

    @JDIAction("Get '{name}'s span with time")
    public UIElement timeSpan() {
        return core().find(By.xpath("//span"));
    }

}
