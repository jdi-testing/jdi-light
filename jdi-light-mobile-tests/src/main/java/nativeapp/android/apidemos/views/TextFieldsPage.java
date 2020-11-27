package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TextFieldsPage {

    @MobileFindBy(id = "io.appium.android.apis:id/edit1")
    public static TextField hiddenInputTextField;

    @MobileFindBy(id = "io.appium.android.apis:id/edit1Text")
    public static TextField displayedInputTextField;

    @MobileFindBy(id = "io.appium.android.apis:id/edit2")
    public static TextField visibleTextField;

}
