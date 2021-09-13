package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.IconAlert;

public class BasicAlerts {
    @UI(".success")
    public static IconAlert successAlert;
    @UI(".info")
    public static IconAlert infoAlert;
    @UI(".warning")
    public static IconAlert warningAlert;
    @UI(".error")
    public static IconAlert errorAlert;
}
