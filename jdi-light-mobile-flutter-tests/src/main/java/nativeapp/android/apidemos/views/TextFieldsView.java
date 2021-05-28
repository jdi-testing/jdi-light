package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.tools.Timer;
import nativeapp.android.keyboard.AsciiKeyTyper;

public class TextFieldsView {
    @MobileFindBy(xpath = "//android.widget.EditText[ends-with(@text, 'Name*')]")
    public static TextField name;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Dismiss')]")
    public static TextField phone;

    public static void typeText(TextField field, String text) {
        field.tap();
        new Timer(5 * 1000L)
                .wait(() -> MobileKeyboard.isKeyboardShown());
        AsciiKeyTyper.type(text);
    }
}
