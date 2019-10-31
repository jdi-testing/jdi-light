package com.epam.jdi.light.ui.bootstrap.elements.composite;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Form<T> extends com.epam.jdi.light.elements.composite.Form<T> {

    private final static String VALID_FEEDBACK_LOCATOR = "./following-sibling::*[contains(concat(' ',normalize-space(@class),' '),' valid-feedback ')]";
    private final static String INVALID_FEEDBACK_LOCATOR = "./following-sibling::*[contains(concat(' ',normalize-space(@class),' '),' invalid-feedback ')]";
    private final static String VALIDATED_ELEMENT_LOCATOR = "./descendant-or-self::input|./descendant-or-self::textarea|./descendant-or-self::select|./descendant-or-self::button";

    @JDIAction("Get invalid feedback elements for {0}")
    public WebList getInvalidFeedback(UIElement element) {
        return getFeedbackList(element, INVALID_FEEDBACK_LOCATOR);
    }

    @JDIAction("Get valid feedback elements for {0}")
    public WebList getValidFeedback(UIElement element) {
        return getFeedbackList(element, VALID_FEEDBACK_LOCATOR);
    }

    @JDIAction("Get invalid feedback elements for {0}")
    public WebList getInvalidFeedback(UIBaseElement element) {
        return getFeedbackList(element.core(), INVALID_FEEDBACK_LOCATOR);
    }

    @JDIAction("Get valid feedback elements for {0}")
    public WebList getValidFeedback(UIBaseElement element) {
        return getFeedbackList(element.core(), VALID_FEEDBACK_LOCATOR);
    }

    private WebList getFeedbackList(UIElement element, String locator) {
        UIElement validatedElement = element.find(VALIDATED_ELEMENT_LOCATOR);
        return validatedElement.finds(locator);
    }

    public boolean isBrowserValidation() {
        return !this.hasAttribute("novalidate");
    }


}
