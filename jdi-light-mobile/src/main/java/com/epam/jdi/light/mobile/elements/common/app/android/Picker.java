package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.asserts.PickerAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.common.MobileKeyboard.pressKey;
import static com.epam.jdi.light.mobile.elements.composite.MobileScreen.swipeToElement;

public class Picker extends MobileAppBaseElement<PickerAssert> implements IsInput, HasClick, HasTouchActions, IsButton, IsText {

    @Override
    public PickerAssert is() {
        return new PickerAssert().set(this);
    }

    @JDIAction(value = "Check that '{name}' is selected")
    public String getSelected(String selected) {
        return core().get().findElements(By.id("android:id/numberpicker_input")).stream()
                .filter(element -> element.getAttribute("text").equals(selected))
                .findFirst().get().getAttribute("text");
    }

    @JDIAction("Select {0} in '{name}'")
    public void select(String text) {
        List<WebElement> pickerList = getDriver().findElements(
                By.className("android.widget.RadialTimePickerView$RadialPickerTouchHelper"));
        for (WebElement element : pickerList) {
            if (element.getAttribute("content-desc").equals(text)) {
                element.click();

            }
        }
    }

    @JDIAction("Select time {0} in '{name}'")
    public void selectTimePicker(String time) {
        core().get().findElements(By.className("android.widget.RadialTimePickerView$RadialPickerTouchHelper"))
                .stream()
                .filter(element -> element.getAttribute("content-desc").equals(time))
                .findFirst().get().click();
    }

    @JDIAction("Select date {0} in '{name}'")
    public void selectDatePicker(String date) {
        core().get().findElements(By.className("android.view.View"))
                .stream()
                .filter(element -> element.getAttribute("content-desc").equals(date))
                .findFirst().get().click();
    }

    @JDIAction("Select year {0} in '{name}'")
    public void selectYearPicker(String value){
        WebElement list= getDriver().findElement(
                new MobileBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).resourceId(\"android:id/date_picker_year_picker\")).scrollIntoView(new UiSelector().text(\""+ value +"\"))"));

        getDriver().getPageSource();
        list.click();
    }

    @JDIAction("Swipe hour to {0} in '{name}'")
    public void swipeHour(String hour){

        WebElement hours=getDriver().findElements(By.id("android:id/numberpicker_input")).get(0);
        WebElement d = getDriver().
                findElements(By.className("android.widget.Button")).get(0);
        int hourInt = Integer.parseInt(hour);
        if (hourInt<=6){
            do {
                swipeToElement(hours,d);}
            while (!hours.getAttribute("text").equals(hour));
        } else {
            do {
                swipeToElement(d,hours);}
            while (!hours.getAttribute("text").equals(hour));
        }
    }

    @JDIAction("Swipe minutes to {0} in '{name}'")
    public void swipeMinute(String minute){

        WebElement minutes = getDriver().findElements(By.id("android:id/numberpicker_input")).get(1);
        WebElement next = getDriver().findElements(By.className("android.widget.Button")).get(2);
        int minuteInt = Integer.parseInt(minute);
        if (minuteInt<=30){
            do {
                swipeToElement(minutes,next);}
            while (!minutes.getAttribute("text").equals(minute));
        }
        else {
            do {
                swipeToElement(next,minutes);}
            while (!minutes.getAttribute("text").equals(minute));
        }
    }

    @JDIAction("Swipe interval to {0} in '{name}'")
    public void swipeInterval(String interval){

        WebElement intervals=getDriver().findElements(By.id("android:id/numberpicker_input")).get(2);
        WebElement next = getDriver().
                findElements(By.className("android.widget.Button")).get(4);
        if (!intervals.getAttribute("text").equals(interval)){
            do {
                swipeToElement(next,intervals);}
            while (!intervals.getAttribute("text").equals(interval));
        }
    }

    @JDIAction("Set hour to {0} in '{name}'")
    public void setHour() {
        core().get().findElements(By.id("android:id/numberpicker_input")).get(0).click();
    }

    @JDIAction("Set minute to {0} in '{name}'")
    public void setMinute() {
        core().get().findElements(By.id("android:id/numberpicker_input")).get(1).click();
    }

    @JDIAction("Set interval to {0} in '{name}'")
    public void setInterval(String interval) {
        core().get().findElements(By.id("android:id/numberpicker_input")).get(2).click();
        switch (interval){
            case "AM":
                pressKey(AndroidKey.A);
                pressKey(AndroidKey.M);
                pressKey(AndroidKey.ENTER);
                break;
            case "PM":
                pressKey(AndroidKey.P);
                pressKey(AndroidKey.M);
                pressKey(AndroidKey.ENTER);
                break;
            default:
                break;
        }
    }
}
