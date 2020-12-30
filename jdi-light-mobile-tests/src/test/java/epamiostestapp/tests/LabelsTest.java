package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.AlertDialogPage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuLabelView;

public class LabelsTest extends IosApplicationInit {
    @Test
    public void iosLabelsTest() {
        menuLabelView.tap();

    }
}
