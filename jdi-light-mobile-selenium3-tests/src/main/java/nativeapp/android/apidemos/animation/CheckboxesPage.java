package nativeapp.android.apidemos.animation;

import com.epam.jdi.light.mobile.elements.common.app.android.Checkbox;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class CheckboxesPage {

    @MobileFindBy(id = "io.appium.android.apis:id/customAnimCB")
    public static Checkbox customAnimationsCheckbox;

    @MobileFindBy(id = "io.appium.android.apis:id/appearingCB")
    public static Checkbox inCheckbox;

    @MobileFindBy(id = "io.appium.android.apis:id/disappearingCB")
    public static Checkbox outCheckbox;

    @MobileFindBy(id = "io.appium.android.apis:id/changingAppearingCB")
    public static Checkbox changingInCheckbox;

    @MobileFindBy(id = "io.appium.android.apis:id/changingDisappearingCB")
    public static Checkbox changingOutCheckbox;

}
