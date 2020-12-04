package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuAlertDialog;

public class IosButtonTest extends IosApplicationInit {

    @Test
    public void iosButtonTest(){
        menuAlertDialog.tap();
    }

}
