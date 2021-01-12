package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.ToolBarPage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuToolBarPage;
import static nativeapp.ios.epamiostestapp.ToolBarPage.testi;

public class ToolBarTests extends IosApplicationInit {

    @Test
    public void toolbarTest(){
        menuToolBarPage.tap();

        testi();
        ToolBarPage.toolBar.tapButton("Add");

    }
}
