package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp.ios.messages.NewMessagePage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import static nativeapp.android.apiDemos.IndexPage.viewsPage;
import static nativeapp.android.apiDemos.TextFieldsPage.*;
import static nativeapp.android.apiDemos.ViewsPage.textFieldsPage;

public class TextFieldTests extends ApiDemosTestInit {

    @Test
    public void textFieldTest(){
        viewsPage.click();
        AndroidScreen.scrollDown(3000);
        textFieldsPage.click();
        textFieldTwo.setValue("Test");
        textFieldTwo.is().text("Test");
        textFieldTwo.clear();
        textFieldTwo.is().empty();
    }
}
