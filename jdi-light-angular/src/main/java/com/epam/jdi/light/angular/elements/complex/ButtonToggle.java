package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ButtonToggleAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

public class ButtonToggle extends UIBaseElement<ButtonToggleAssert> {

    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void clickButtonByValue(String value){
        getButtonByTagValue(value).click();
    }

    public void getButtonToggleClass(String value){
        System.out.println(getButtonByTagValue(value).attr("class"));
        getButtonByTagValue(value).attr("class");
    }

    public boolean isButtonToggleSelected(String value){
       return getButtonByTagValue(value).attr("class").contains("checked");
    }

    @JDIAction("Get '{name}' tabs")
    private WebList getButtonToggleItems() {
        return this.finds(".mat-button-toggle");
    }

    private UIElement getButtonByTagValue(String value) {
        UIElement element = null;
        for (UIElement e : getButtonToggleItems()) {
            if (e.attr("value").equals(value)) {
                element = e;
            }
        }
        return element;
    }

    @Override
    public ButtonToggleAssert is() {
        return new ButtonToggleAssert().set(this);
    }


//    div.example-selected-value"


}
