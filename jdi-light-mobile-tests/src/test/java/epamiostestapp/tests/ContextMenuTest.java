package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.ContextMenuPage.*;
import static nativeapp.ios.epamiostestapp.MainPage.menuContextMenu;

public class ContextMenuTest extends IosApplicationInit {

    @Test
    public void contextMenuTest(){
        menuContextMenu.tap();

        contextMenu.longPress();
        optionOne.tap();
        optionOne.is().displayed();

        contextMenu.longPress();
        optionTwo.tap();
        optionTwo.is().displayed();

        contextMenu.longPress(2);
        optionThree.tap();
        optionThree.is().displayed();
    }
}
