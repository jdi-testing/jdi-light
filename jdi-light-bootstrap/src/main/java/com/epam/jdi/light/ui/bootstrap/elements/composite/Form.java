package com.epam.jdi.light.ui.bootstrap.elements.composite;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.tools.ReflectionUtils;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.epam.jdi.light.common.UIUtils.getMapFromObject;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.tools.StringUtils.namesEqual;

public class Form<T> extends com.epam.jdi.light.elements.composite.Form<T> {

    private final static String VALID_FEEDBACK_LOCATOR = "./following-sibling::*[contains(concat(' ',normalize-space(@class),' '),' valid-feedback ')]";
    private final static String INVALID_FEEDBACK_LOCATOR = "./following-sibling::*[contains(concat(' ',normalize-space(@class),' '),' invalid-feedback ')]";
    private final static String ANY_FEEDBACK_LOCATOR = "./following-sibling::*[contains(concat(' ',normalize-space(@class),' '),' invalid-feedback ') or contains(concat(' ',normalize-space(@class),' '),' valid-feedback ')]";
    private final static String SUBMITTED_ELEMENT_LOCATOR = "./descendant-or-self::input|./descendant-or-self::textarea|./descendant-or-self::select|./descendant-or-self::button[@type='submit']";


    private UIElement getSubmittedElement(UIElement element) {
        return element.find(SUBMITTED_ELEMENT_LOCATOR);
    }


    @JDIAction("Get feedback elements for {0}")
    public WebList getFeedbacks(UIElement element) {
        return getFeedbackList(element, ANY_FEEDBACK_LOCATOR);
    }

    private WebList getFeedbackList(UIElement element, String locator) {
        UIElement validatedElement = getSubmittedElement(element);
        return validatedElement.finds(locator);
    }

    public boolean isBrowserValidation() {
        return !this.hasAttribute("novalidate");
    }

    public boolean isValid() {
        Object res = core().js().executeScript ("return arguments[0].checkValidity()", core().get());
        return (Boolean)res;
    }

    @JDIAction("Get all feedback elements")
    public Map<String, UIElement> getAllFeedbackElements() {
        return getFeedbackMap(ANY_FEEDBACK_LOCATOR);
    }

    @JDIAction("Get valid feedback text")
    public Map<String, String> getValidFeedback() {
        return getFeedback(VALID_FEEDBACK_LOCATOR);
    }

    @JDIAction("Get invalid feedback text")
    public Map<String, String> getInvalidFeedback() {
        return getFeedback(INVALID_FEEDBACK_LOCATOR);
    }

    private Map<String, String> getFeedback(String locator) {
        Map<String, UIElement> elementMap = getFeedbackMap(locator);
        Map<String, String> feedbacks = new HashMap<>();
        for(String name : elementMap.keySet()) {
            UIElement el = elementMap.get(name);
            String text = el.getText();
            feedbacks.put(name, text);
        }
        return feedbacks;
    }

    private Map<String, UIElement> getFeedbackMap(String locator) {

        Map<String, UIElement> feedbackMap = new HashMap<>();

        List<Field> allFields = allFields();

        for (Field field : allFields) {

            String fieldName = getElementName(field);
            Object fieldObj = ReflectionUtils.getValueField(field, getPageObject());
            WebList feedbackList = null;
            if (fieldObj instanceof UIElement) {
                feedbackList = getFeedbackList((UIElement) fieldObj, locator);
            } else if (fieldObj instanceof UIBaseElement) {
                feedbackList = getFeedbackList(((UIBaseElement) fieldObj).core(), locator);
            } else {
                throw Exceptions.exception("Cant make checking against field %s because it is not %s or %s",
                        fieldName, UIElement.class.getName(), UIBaseElement.class.getName());
            }

            if (feedbackList.size() > 1) {
                throw Exceptions.exception("Cant get feedback for field %s, founded %s feedback", fieldName, feedbackList.size());
            } else if (feedbackList.size() == 1) {
                feedbackMap.put(fieldName, feedbackList.get(1));
            }

        }

        return feedbackMap;
    }


    /**
     * Return elements that are listed in the form.elements APIs.
     * @return
     */
    private List<WebElement> getFormListedElements() {
        List<WebElement> elementList = new ArrayList<>();
        Object elListObj = core().js().executeScript ("return arguments[0].elements", core().get());
        List elList = (List)elListObj;
        for(Object elObj : elList) {
            WebElement el = (WebElement) elObj;
            elementList.add(el);
        }
        return elementList;
    }


}
