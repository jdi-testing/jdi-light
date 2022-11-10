package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.AlertAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import com.epam.jdi.light.vuetify.interfaces.HasStyledText;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class Alert extends UIBaseElement<AlertAssert> implements IsText, HasIcon, HasColor, HasTheme,
        IsDense, HasMeasurement, HasElevation, IsOutlined, HasRounded, IsShaped, IsTile, HasStyledText {

    private final String closeButton = "//button[contains(@class, 'v-alert__dismissible')]";
    private final String borderLocator = "v-alert--border";

    @JDIAction("Get '{name}' close button")
    public VuetifyButton closeButton() {
        return new VuetifyButton().setCore(VuetifyButton.class, core().find(closeButton));
    }
    @JDIAction("Check that '{name}' is dismissible")
    public boolean isDismissible() {
        return finds(closeButton).size() > 0;
    }

    @JDIAction("Check that '{name}' is prominent")
    public boolean isProminent() {
        return core().hasClass("v-alert--prominent");
    }

    @JDIAction("Check that '{name}' has border")
    public boolean hasBorder() {
        return core().hasClass(borderLocator);
    }

    @JDIAction("Get '{name}' border value")
    public String borderValue() {
        String alertBorderValueLocator = "v-alert--border-";
        return core().classes().stream()
                .filter(cls -> cls.contains(alertBorderValueLocator))
                .map(cls -> cls.replace(alertBorderValueLocator, ""))
                .findFirst()
                .orElse("");
    }

    @JDIAction("Check that '{name}' has colored border")
    public boolean hasColoredBorder() {
        return core().find(By.className(borderLocator))
                .finds(".v-alert__border--has-color").size() > 0;
    }

    @JDIAction("Get '{name}' border background color")
    public String borderBackGroundColor() {
        return core().find(By.className(borderLocator.replace("--", "__")))
                .css("border-color");
    }

    @JDIAction("Get '{name}' type")
    public String type() {
        List<String> types = Arrays.asList("success", "info", "warning", "error");
        return core().classes()
                .stream().filter(types::contains)
                .findFirst()
                .orElse("");
    }

    @Override
    public AlertAssert is() {
        return new AlertAssert().set(this);
    }
}
