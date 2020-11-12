package nativeapp.android.apiDemos;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class RadioButtonPage {

    @MobileFindBy(id = "io.appium.android.apis:id/snack")
    public static UIElement radioButtonSnack;

    @MobileFindBy(id = "io.appium.android.apis:id/breakfast")
    public static UIElement radioButtonBreakfast;

    @MobileFindBy(xpath = "io.appium.android.apis:id/lunch")
    public static UIElement radioButtonLunch;

    @MobileFindBy(id = "io.appium.android.apis:id/dinner")
    public static UIElement radioButtonDinner;

    @MobileFindBy(id = "io.appium.android.apis:id/all")
    public static UIElement radioButtonAll;

    @MobileFindBy(id = "io.appium.android.apis:id/choice")
    public static UIElement logChose;

    @MobileFindBy(className = "android.widget.RadioGroup")
    public static UIElement allItemsInMenu;
}
