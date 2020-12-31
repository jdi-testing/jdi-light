package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.init.MobileAppFactory.$;
import static nativeapp.ios.epamiostestapp.MainPage.menuLabelView;
import static nativeapp.ios.epamiostestapp.LabelViewPage.label;

public class LabelsTest extends IosApplicationInit {
    @Test
    public void iosLabelsTest() {
        menuLabelView.tap();
        $(label, "Label1").is().displayed();
        $(label, "Label2").is().displayed();
        $(label, "Label1").isDisplayed();//or that one
    }

    @Test
    public void iosTextUnderTheLabelsTest() {
        menuLabelView.tap();

    }
}
