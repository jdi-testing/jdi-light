package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.TextFieldsPage.displayedInputTextField;
import static nativeapp.android.apidemos.views.TextFieldsPage.hiddenInputTextField;
import static nativeapp.android.apidemos.views.TextFieldsPage.visibleTextField;
import static nativeapp.android.apidemos.views.ViewsPage.textFieldsPage;

public class TextFieldTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        viewsPage.click();
        MobileScreen.scrollToElementInList(textFieldsPage);
        textFieldsPage.click();
    }

    @Test
    public void textFieldTest(){
        visibleTextField.setValue("Test");
        visibleTextField.is().text("Test");
        visibleTextField.clear();
        visibleTextField.is().empty();
    }

    @Test
    public void hiddenInputFieldTest(){
        hiddenInputTextField.setValue("Test");
        hiddenInputTextField.is().text("••••");
        displayedInputTextField.is().text("Test");
        hiddenInputTextField.clear();
        hiddenInputTextField.is().empty();
        displayedInputTextField.is().empty();
    }
}
