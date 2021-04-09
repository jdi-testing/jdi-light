package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layouts.HiddenAssert;
import org.openqa.selenium.Dimension;

public class Hidden extends UIBaseElement<HiddenAssert> {
    @JDIAction("Get {name} width")
    public String getWidth(){
        String text = core().getText();
        return text.substring(15);
    }

    @JDIAction("Is {name} visible")
    public boolean isVisible(){
        return core().isDisplayed();
    }

    @JDIAction
    public void setHalfScreenWidthSize(){
        Dimension xy = WebDriverFactory.getDriver().manage().window().getSize();
        Dimension xy2 = new Dimension(xy.width / 2, xy.height );
        WebDriverFactory.getDriver().manage().window().setSize(xy2);
    }

    @Override
    public HiddenAssert is() {
        return new HiddenAssert().set(this);
    }
}
