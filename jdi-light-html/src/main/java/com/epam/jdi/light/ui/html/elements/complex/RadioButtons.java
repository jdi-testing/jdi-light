package com.epam.jdi.light.ui.html.elements.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.common.TextTypes.LABEL;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RadioButtons extends UIListBase<UISelectAssert<UISelectAssert<?,?>, RadioButtons>> {
    public RadioButtons() {
        base().setLocator("input[type=radio]");
    }
    @Override
    public WebList list() {
        return super.list().setUIElementName(LABEL);
    }

    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void clickRadioButtonByValue(String value) {
        getRadioButtonByTagValue(value).click();
    }

    public UIElement getRadioButtonByTagValue(String value) {
        System.out.println(list());
        UIElement element = null;

        for (UIElement e : getRadioButtonsItems()) {
            if (e.find("input").attr("value").equals(value)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("Get '{name}' tabs")
    private WebList getRadioButtonsItems() {
        return this.finds(".mat-radio-button");
    }

}
