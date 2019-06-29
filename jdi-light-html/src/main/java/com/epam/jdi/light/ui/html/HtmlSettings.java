package com.epam.jdi.light.ui.html;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.common.UIUtils.*;
import static com.epam.jdi.light.settings.WebSettings.initialized;
import static com.epam.jdi.tools.LinqUtils.select;
import static com.epam.jdi.tools.ReflectionUtils.*;

public class HtmlSettings {

    public static synchronized void init() {
        if (!initialized) {
            WebSettings.init(); /*
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
                    PageFactory::initElements));*/
            GET_BUTTON = (obj, buttonName) -> {
                List<Field> fields = getFieldsExact(obj, Button.class);
                if (fields.size() == 0)
                    fields = getFieldsExact(obj, WebElement.class, UIElement.class);
                List<UIElement> buttons = select(fields, f -> {
                    Object value = getValueField(f, obj);
                    return isClass(value.getClass(), Button.class)
                        ? ((Button) value).core() : (UIElement) value;
                });
                switch (buttons.size()) {
                    case 0:
                        return GET_DEFAULT_BUTTON.execute(obj, buttonName);
                    case 1:
                        return buttons.get(0);
                    default:
                        return getButtonByName(buttons, obj, buttonName);
                }
            };
        }
    }
}
