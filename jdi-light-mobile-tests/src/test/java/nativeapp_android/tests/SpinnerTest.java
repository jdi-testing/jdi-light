package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import nativeapp.android.apiDemos.IndexPage;
import nativeapp.android.apiDemos.SpinnerPage;
import nativeapp.android.apiDemos.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;


public class SpinnerTest extends ApiDemosTestInit {

    @Test
    public void openSpinnersTest() {
        IndexPage.viewsPage.click();
        AndroidScreen.scrollDown(3000);
        ViewsPage.spinnerPage.click();
        SpinnerPage.colorSpinner.is().displayed();
        SpinnerPage.colorSpinner.has().text("red");
        SpinnerPage.colorSpinner.tap();
        SpinnerPage.colorSpinner.select("yellow");
        SpinnerPage.colorSpinner.has().text("yellow");
        SpinnerPage.colorSpinner.tap();
        SpinnerPage.colorSpinner.select("violet");
        SpinnerPage.colorSpinner.has().text("violet");
    }

}
