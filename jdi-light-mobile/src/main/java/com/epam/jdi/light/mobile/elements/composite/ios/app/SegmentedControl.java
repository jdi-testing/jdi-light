package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.mobile.asserts.SegmentedControlAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;

public class SegmentedControl extends MobileAppBaseElement<SegmentedControlAssert> implements PageObject, HasTouchActions {
    private Object pageObject = this;

    public SegmentedControl() {
        initElements(this);
    }

    @JDIAction(value = "Get '{name}' segment texts")
    public List<String> getSegmentTexts() {
        return core().get().findElements(By.xpath("*")).stream()
                .map(element -> element.getAttribute("name"))
                .collect(Collectors.toList());
    }

    @JDIAction(value = "Get '{name}' selected segment text")
    public String getSelectedSegmentText() {
        return core().get().findElements(By.xpath("*")).stream()
                .filter(element -> element.getText().equals("1"))
                .findFirst()
                .get().getAttribute("name");
    }

    @JDIAction(value = "Perform tap on '{name}' {0} segment")
    public void tapSegment(String segmentName) {
        HasTouchActions button = GET_BUTTON.execute(pageObject, segmentName);
        button.tap();
    }

    @Override
    public SegmentedControlAssert is() {
        return new SegmentedControlAssert().set(this);
    }
}
