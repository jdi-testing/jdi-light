package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.common.MobileKeyboard.pressKey;
import static nativeapp.android.apidemos.IndexPage.goToViewPage;
import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.DateWidgetsPage.*;
import static nativeapp.android.apidemos.views.PickerPage.picker;
import static nativeapp.android.apidemos.views.RadialPickerPage.*;
import static nativeapp.android.apidemos.views.ViewsPage.dateWidgetsPage;

public class PickersTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        MobileScreen.scrollToElementInList(goToViewPage);
        viewsPage.click();
        dateWidgetsPage.click();
        dialogPage.click();
    }

    @Test
    public void radialPickerTest(){
        radialTimePickerButton.click();
        hoursHeader.click();
        radialPicker.selectTimePicker("7");
        hoursHeader.is().text("7");
        minutesHeader.click();
        radialPicker.selectTimePicker("35");
        minutesHeader.is().text("35");
    }

    @Test
    public void swipePickerTest(){
        timePickerButton.click();
        picker.is().displayed();
        picker.swipeHour("7");
        picker.is().selected("7");
        picker.swipeMinute("20");
        picker.is().selected("20");
        picker.swipeInterval("PM");
        picker.is().selected("PM");
    }

    @Test
    public void typePickerTest(){
        timePickerButton.click();
        picker.is().displayed();
        picker.setHour();
        pressKey(AndroidKey.DIGIT_5);
        pressKey(AndroidKey.ENTER);
        picker.is().selected("5");
        picker.setMinute();
        pressKey(AndroidKey.DIGIT_5);
        pressKey(AndroidKey.ENTER);
        picker.is().selected("05");
        picker.setInterval("PM");
        picker.is().selected("PM");
    }
}
