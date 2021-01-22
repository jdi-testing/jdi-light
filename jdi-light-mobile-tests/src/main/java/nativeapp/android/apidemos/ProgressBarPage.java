package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.ProgressBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ProgressBarPage {

    @MobileFindBy(id = "io.appium.android.apis:id/progress_horizontal")
    public static ProgressBar progressBarLine;

    @MobileFindBy(id = "io.appium.android.apis:id/decrease")
    public static Button decreaseStandardButton;

    @MobileFindBy(id = "io.appium.android.apis:id/increase")
    public static Button increaseStandardButton;

    @MobileFindBy(id = "io.appium.android.apis:id/decrease_secondary")
    public static Button decreaseSecondaryButton;

    @MobileFindBy(id = "io.appium.android.apis:id/increase_secondary")
    public static Button increaseSecondaryButton;

}
