package nativeapp_android.tests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.common.MobileKeyboard.pressKey;
import static nativeapp.android.apidemos.DateWidgetsPage.*;
import static nativeapp.android.apidemos.IndexPage.*;
import static nativeapp.android.apidemos.ViewsPage.*;
import static nativeapp.android.apidemos.RadialPickerPage.*;
import static nativeapp.android.apidemos.DatePickerPage.*;
import static nativeapp.android.apidemos.PickerPage.*;

public class PickersTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
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
    public void datePickerTest(){

        datePickerButton.click();

        yearPickerHeader.click();
        yearPicker.selectYearPicker("2018");
        yearPickerHeader.is().text("2018");

        nextMonth.click();
        datePicker.selectDatePicker("23 December 2018");
        datePickerHeader.is().text("Sun, Dec 23");
        yearPickerHeader.is().text("2018");
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
        pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        pressKey(new KeyEvent(AndroidKey.ENTER));
        picker.is().selected("5");

        picker.setMinute();
        pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        pressKey(new KeyEvent(AndroidKey.ENTER));
        picker.is().selected("05");

        picker.setInterval("PM");
        picker.is().selected("PM");

    }
}
