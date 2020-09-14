package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.android.Checkbox;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class CheckboxesPage {
    @MobileFindBy(id = "io.appium.android.apis:id/customAnimCB")
    public static Checkbox customAnimations;

    @MobileFindBy(id = "io.appium.android.apis:id/appearingCB")
    public static Checkbox in;

    @MobileFindBy(id = "io.appium.android.apis:id/disappearingCB")
    public static Checkbox out;

    @MobileFindBy(id = "io.appium.android.apis:id/changingAppearingCB")
    public static Checkbox changingIn;

    @MobileFindBy(id = "io.appium.android.apis:id/changingDisappearingCB")
    public static Checkbox changingOut;
}
