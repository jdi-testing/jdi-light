package nativeapp_android.tests;

import nativeapp.android.apidemos.EspressoIndexPage;
import nativeapp.android.apidemos.app.EspressoAppPage;
import nativeapp_android.ApiDemosEspressoTestInit;
import org.testng.annotations.Test;

public class EspressoTests extends ApiDemosEspressoTestInit {

    @Test
    public void findElementWithAndroidDataMatcher() {
        EspressoIndexPage.appPage.is().displayed();
    }

    @Test
    public void clickElementWithAndroidDataMatcher() {
        EspressoIndexPage.appPage.is().enabled();
        EspressoIndexPage.appPage.click();
        EspressoAppPage.alarmPage.is().displayed();
    }
}
