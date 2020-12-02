package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.ContextMenuPage.contextMenu;
import static nativeapp.ios.epamiostestapp.ContextMenuPage.popUpMenu;
import static nativeapp.ios.epamiostestapp.MainPage.menuContextMenu;

public class ContextMenuTest extends IosApplicationInit {

    @Test
    public void contextMenuTest(){
        menuContextMenu.tap();
        contextMenu.longPress();
        popUpMenu.tapBarButton("one");

        contextMenu.is().text("one");
    }
}
