package com.epam.jdi.light.ui.bootstrap.elements.composite;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.ReflectionUtils;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.tools.StringUtils.namesEqual;

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

    @JDIAction("Check valid feedback for {name}")
    public void checkValid(MapArray<String, Consumer<UIElement>> map) {

        List<String> checkedFields = new ArrayList<>();
        List<Field> allFields = allFields();

        if (allFields.size() == 0) {
            for (Pair<String, Consumer<UIElement>> pair : map) {
                UIElement element = new UIElement().setup(e->e
                        .setName(pair.key)
                        .setParent(this));
                WebList feedbackList = getValidFeedback(element);

                if (feedbackList.size() != 1) {
                    throw Exceptions.exception("Cant get valid feedback for field %s, founded %s feedback", pair.key, feedbackList.size());
                }

                UIElement feedback = feedbackList.get(1);

                pair.value.accept(feedback);
            }
            return;
        }

        for (Field field : allFields) {

            String fieldName = getElementName(field);

            Consumer<UIElement> check = map.firstValue((name, value) ->
                    namesEqual(name, fieldName));
            if (check == null) {
                continue;
            }

            checkedFields.add(fieldName);

            Object fieldObj = ReflectionUtils.getValueField(field, getPageObject());
            WebList feedbackList = null;
            if (fieldObj instanceof UIElement) {
                feedbackList = getValidFeedback((UIElement) fieldObj);
            } else if (fieldObj instanceof UIBaseElement) {
                feedbackList = getValidFeedback((UIBaseElement) fieldObj);
            } else {
                throw Exceptions.exception("Cant make checking against field %s because it is not %s or %s",
                        fieldName, UIElement.class.getName(), UIBaseElement.class.getName());
            }

            if (feedbackList.size() != 1) {
                throw Exceptions.exception("Cant get valid feedback for field %s, founded %s feedback", fieldName, feedbackList.size());
            }

            UIElement feedback = feedbackList.get(1);

            check.accept(feedback);

        }

        if(checkedFields.size() != map.keys().size()) {
            throw Exceptions.exception("Not all checks executed. All checks: {%s}, executed: {%s}", map.keys(), checkedFields);
        }

    }



    class ddd extends UIElement {
    }


}
