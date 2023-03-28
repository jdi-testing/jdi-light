package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.Picker;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class PickerPage {

    @MobileFindBy(id = "android:id/timePickerLayout")
    public static Picker picker;

}
