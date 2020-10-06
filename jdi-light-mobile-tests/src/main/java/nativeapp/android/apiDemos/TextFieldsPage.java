package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TextFieldsPage {
    @MobileFindBy(id = "io.appium.android.apis:id/edit2")
    public static TextField textFieldTwo;

}
