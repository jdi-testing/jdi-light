package nativeapp.android.apidemos.pages;

import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.Switch;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SettingsPage {
    @MobileFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Close')]")
    public static Button closeButton;

    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'scaling')]")
    public static Button textScaling;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'direction')]")
    public static Button textDirection;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Locale')]")
    public static Button systemLocation;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Platform')]")
    public static Button platform;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Theme')]")
    public static Button theme;
    @MobileFindBy(xpath = "//android.widget.Switch[contains(@content-desc, 'Slow')]")
    public static Switch slowMotion;
}
