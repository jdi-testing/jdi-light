package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TextFieldsView {
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Dismiss')]")
    public static TextField name;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Dismiss')]")
    public static TextField phone;

}
