package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.apidemos.IndexPage.*;
import static nativeapp.android.apidemos.views.TextFieldsPage.*;
import static nativeapp.android.apidemos.views.ViewsPage.textFieldsPage;

public class TextFieldTests extends ApiDemosTestInit {

    @BeforeClass
    public void beforeClass() {
        logger.toLog("Run TextFieldTests");
    }

    @BeforeMethod
    public void initSteps() {
        viewsPage.click();
        AndroidScreen.scrollDown(3000);
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
