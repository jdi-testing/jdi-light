package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.ToolBarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.init.MobileAppFactory.sizeOfList;
import static nativeapp.ios.epamiostestapp.MainPage.menuToolBarPage;

public class ToolBarTest extends IosApplicationInit {

    private int INITIAL_VALUE_OF_STRING = 5;

    @Test
    public void toolbarTest() {
        menuToolBarPage.tap();

        Assert.assertEquals(sizeOfList(ToolBarPage.listOfStrings), INITIAL_VALUE_OF_STRING);
        ToolBarPage.toolBar.tapButton("Add");
        Assert.assertEquals(sizeOfList(ToolBarPage.listOfStrings), INITIAL_VALUE_OF_STRING + 1);

        ToolBarPage.toolBar.tapButton("Delete All");
        ToolBarPage.toolBar.tapButton("Add");
        Assert.assertEquals(sizeOfList(ToolBarPage.listOfStrings), 1);

    }
}
