package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.complex.Spinner;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SpinnerPage {

    @MobileFindBy(id = "spinner1")
    public static Spinner colorSpinner;

    @MobileFindBy(id = "spinner2")
    public static Spinner planetSpinner;

}