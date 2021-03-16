package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.SeekBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SeekBarPage {

    @MobileFindBy(id = "io.appium.android.apis:id/seek")
    public static SeekBar seekBar;

}
