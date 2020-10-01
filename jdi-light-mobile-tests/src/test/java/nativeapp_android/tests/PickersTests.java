package nativeapp_android.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import io.appium.java_client.MobileElement;
import nativeapp.ios.calendar.InboxPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

import java.net.SocketOption;

import static nativeapp.android.apiDemos.DateWidgetsPage.*;
import static nativeapp.android.apiDemos.IndexPage.*;
import static nativeapp.android.apiDemos.ViewsPage.*;
import static org.testng.Assert.assertEquals;

public class PickersTests extends ApiDemosTestInit {

    @Test
    public void radialTimePickerTest(){
        viewsPage.click();
        dateWidgetsPage.click();
        dialogPage.click();
        radialTimePickerButton.click();

        hoursHeader.click();
        radialPickerNumbers.select("7");
        hoursHeader.is().text("7");

        minutesHeader.click();
        radialPickerNumbers.select("35");
        minutesHeader.is().text("35");

        hoursHeader.click();
        radialPickerNumbers.selectPicker("6");
        hoursHeader.is().text("6");

        minutesHeader.click();
        radialPickerNumbers.selectPicker("30");
        minutesHeader.is().text("30");

        hoursHeader.click();
        radialPickerNumbers.selectPickerFinds("5");
        hoursHeader.is().text("5");

        minutesHeader.click();
        radialPickerNumbers.selectPickerFinds("25");
        minutesHeader.is().text("25");


    }

    @Test
    public void datePickerTest(){
        viewsPage.click();
        dateWidgetsPage.click();
        dialogPage.click();
        datePickerButton.click();
        datePickerNumbers.select("23 September 2020");
        datePickerNumbers.is().text("23 September 2020");

    }
}
