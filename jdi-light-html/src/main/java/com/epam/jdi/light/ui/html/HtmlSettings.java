package com.epam.jdi.light.ui.html;

import static com.epam.jdi.light.common.UIUtils.GET_BUTTON;
import static com.epam.jdi.light.common.UIUtils.GET_DEFAULT_BUTTON;
import static com.epam.jdi.light.common.UIUtils.getButtonByName;
import static com.epam.jdi.light.elements.init.InitActions.INIT_RULES;
import static com.epam.jdi.light.elements.init.InitActions.SETUP_RULES;
import static com.epam.jdi.light.elements.init.InitActions.isList;
import static com.epam.jdi.light.elements.init.InitActions.isPageObject;
import static com.epam.jdi.light.elements.init.rules.InitRule.iRule;
import static com.epam.jdi.light.elements.init.rules.SetupRule.sRule;
import static com.epam.jdi.light.settings.WebSettings.initialized;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.ReflectionUtils.getFieldsExact;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.util.Arrays.asList;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.annotations.FillValue;
import com.epam.jdi.light.ui.html.annotations.VerifyValue;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.base.HtmlCombobox;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.base.HtmlList;
import com.epam.jdi.light.ui.html.base.HtmlMultiDropdown;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.base.HtmlSelector;
import com.epam.jdi.light.ui.html.base.TextAreaElement;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.ColorPicker;
import com.epam.jdi.light.ui.html.common.DateTimeSelector;
import com.epam.jdi.light.ui.html.common.FileInput;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.Image;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.ui.html.common.Link;
import com.epam.jdi.light.ui.html.common.NumberSelector;
import com.epam.jdi.light.ui.html.common.ProgressBar;
import com.epam.jdi.light.ui.html.common.Range;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.DataList;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.Menu;
import com.epam.jdi.light.ui.html.complex.MultiDropdown;
import com.epam.jdi.light.ui.html.complex.MultiSelector;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class HtmlSettings {

    public static synchronized void init() {
        if (!initialized) {
            WebSettings.init();
            INIT_RULES.update("Selector", iRule(asList(Dropdown.class, MultiSelector.class),
                info -> new HtmlSelector()));
            INIT_RULES.update("UIElement", iRule(WebElement.class,
                info -> new HtmlElement()));
            INIT_RULES.update("WebList", iRule(f -> isList(f, WebElement.class) ||
                f.getType() == Menu.class, info -> new HtmlList()));
            INIT_RULES.addAll(asList(
                $("Combobox", iRule(f -> isInterface(f, DataList.class), info -> new HtmlCombobox())),
                $("Checklist", iRule(Checklist.class, info -> new HtmlChecklist())),
                $("RadioButtons", iRule(RadioButtons.class, info -> new HtmlRadioGroup())),
                $("MultiDropdown", iRule(MultiDropdown.class, info -> new HtmlMultiDropdown())),
                $("TextArea", iRule(TextArea.class, info -> new TextAreaElement())),
                $("Default", iRule(asList(Text.class, Button.class, FileInput.class, Icon.class,
                    Image.class, Link.class, TextArea.class, TextField.class,
                    Label.class,
                    Checkbox.class, ColorPicker.class, Range.class, ProgressBar.class,
                    DateTimeSelector.class, NumberSelector.class),
                        info -> new HtmlElement()))
            ));
            SETUP_RULES.update("PageObject",
                sRule(info -> isPageObject(info.instance.getClass()),
                    PageFactory::initElements));
            GET_BUTTON = (obj, buttonName) -> {
                List<Field> fields = getFieldsExact(obj, Button.class);
                if (fields.size() == 0)
                    fields = getFieldsExact(obj, WebElement.class, UIElement.class);
                switch (fields.size()) {
                    case 0:
                        return GET_DEFAULT_BUTTON.execute(obj, buttonName);
                    case 1:
                        return (BaseUIElement) getValueField(fields.get(0), obj);
                    default:
                        return getButtonByName(fields, obj, buttonName);
                }
            };

            Form.FILL_ACTION = (field, element, parent, setValue) -> {
                if (field != null) {
                    Method[] methods = field.getType().getDeclaredMethods();
                    Method setMethod = first(methods, m -> m.isAnnotationPresent(FillValue.class));
                    if (setMethod != null) {
                        setMethod.invoke(element, setValue);
                        return;
                    }
                }
                ((SetValue) element).setValue(setValue);
            };
            Form.GET_ACTION = (field, element, parent) -> {
                if (field != null) {
                    Method[] methods = field.getType().getDeclaredMethods();
                    Method getMethod = first(methods, m -> m.isAnnotationPresent(VerifyValue.class));
                    if (getMethod != null) {
                        return getMethod.invoke(element).toString();
                    }
                }
                return ((HasValue) element).getValue().trim();
            };
            UIList.GET_TITLE_FIELD_NAME = list -> {
                Field[] fields = list.classType.getFields();
                Field expectedField = first(fields, f -> f.isAnnotationPresent(Title.class));
                if (expectedField != null)
                    return expectedField.getName();
                List<Field> titles = filter(fields,
                    f -> f.getType() == Label.class);
                return titles.size() == 1
                        ? titles.get(0).getName()
                        : null;
            };
        }
    }
}
