package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import org.openqa.selenium.By;

public class RadioButtonsPage {

    @MobileFindBy(accessibilityId = "Clear")
    public static Button buttonClear;

    @MobileFindBy(id = "io.appium.android.apis:id/choice")
    public static TextField logChose;

    @MobileFindBy(className = "android.widget.RadioButton")
    public static Text radioButton;
}
