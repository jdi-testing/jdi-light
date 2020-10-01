package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;


import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsButton;

import com.epam.jdi.light.elements.interfaces.common.IsText;

import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;


import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

import java.util.List;

public class Picker extends MobileAppBaseElement<TextAssert> implements HasTouchActions, IsButton, IsText {

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }


   public WebList getPickers(){
        return this.finds(By.className("android.widget.RadialTimePickerView$RadialPickerTouchHelper"));
    }

    public void selectPickerFinds(String text){

        for (UIElement element : getPickers()) {
            if (element.attr("content-desc").equals(text)) {
                element.click();
            }
        }
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

    @JDIAction("Select {0} in '{name}'")
    public void selectPicker(String text){
        WebList wl = $$(new By.ByClassName("android.widget.RadialTimePickerView$RadialPickerTouchHelper"));

        System.out.println(wl.size());
        for (int i=1; i< wl.size(); i++){
            if(wl.get(i).getAttribute("content-desc").equals(text)){
                wl.get(i).click();
            }
        }
    }
}
