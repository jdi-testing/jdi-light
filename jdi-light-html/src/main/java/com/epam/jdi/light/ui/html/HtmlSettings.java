package com.epam.jdi.light.ui.html;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.elements.init.rules.InitRule;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.base.*;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.DataList;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.GET_BUTTON;
import static com.epam.jdi.light.common.UIUtils.getButtonByName;
import static com.epam.jdi.light.elements.init.InitActions.*;
import static com.epam.jdi.light.elements.init.rules.InitRule.iRule;
import static com.epam.jdi.light.elements.init.rules.SetupRule.sRule;
import static com.epam.jdi.light.settings.WebSettings.initialized;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;

public class HtmlSettings {

    public static synchronized void init() {
        if (!initialized) {
            WebSettings.init();
            MapArray<String, InitRule> newRules = map(
                $("Combobox", iRule(f -> isInterface(f, DataList.class), info -> new Combobox())),
                $("Checklist", iRule(f -> isInterface(f, Checklist.class), info -> new HtmlChecklist())),
                $("RadioButtons", iRule(f -> isInterface(f, RadioButtons.class), info -> new HtmlRadioGroup())),
                $("BaseSelector", iRule(f -> isInterface(f, BaseSelector.class), info -> new HtmlSelector())),
                $("TextArea", iRule(f -> isInterface(f, TextArea.class), info -> new TextAreaElement()))
            );
            INIT_RULES.update("Selector",
                iRule(f -> isInterface(f, BaseSelector.class), info -> new HtmlSelector()));
            INIT_RULES.update("UIElement",
                iRule(f -> isInterface(f, BaseElement.class) || isInterface(f, WebElement.class),
                    info -> new HtmlElement()));
            INIT_RULES = newRules.merge(INIT_RULES);
            SETUP_RULES.update("PageObject",
                sRule(info -> isPageObject(info.instance.getClass()),
                    PageFactory::initElements));
            GET_BUTTON = (obj, buttonName) -> {
                List<Field> fields = getFieldsExact(obj, Button.class);
                if (fields.size() == 0)
                    fields = getFields(obj, WebElement.class);
                switch (fields.size()) {
                    case 0:
                        throw exception("Can't find any buttons on form '%s.", obj);
                    case 1:
                        return (UIElement) getValueField(fields.get(0), obj);
                    default:
                        return getButtonByName(fields, obj, buttonName);
                }
            };

            Form.FILL_ACTION = (field, parent, setValue) -> {
                Method[] methods = field.getType().getDeclaredMethods();
                Object fieldValue = getValueField(field, parent);
                Method setMethod = first(methods, m -> m.isAnnotationPresent(FillValue.class));
                if (setMethod != null) {
                    setMethod.invoke(fieldValue, setValue);
                    return;
                }
                ((SetValue) getValueField(field, parent)).setValue(setValue);
            };
            Form.GET_ACTION = (field, parent) -> {
                Method[] methods = field.getType().getDeclaredMethods();
                Object fieldValue = getValueField(field, parent);
                Method getMethod = first(methods, m -> m.isAnnotationPresent(VerifyValue.class));
                if (getMethod != null) {
                    return getMethod.invoke(fieldValue).toString();
                }
                return ((HasValue) getValueField(field, parent)).getValue().trim();
            };
        }
    }
}
