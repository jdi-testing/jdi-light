package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.AlertDialogPage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuAlertDialog;

public class IosButtonTest extends IosApplicationInit {

    @Test
    public void iosButtonTest() {
        menuAlertDialog.tap();

        AlertDialogPage.buttonShowAlert.tap();
        AlertDialogPage.alert.is().displayed();
    }

}
