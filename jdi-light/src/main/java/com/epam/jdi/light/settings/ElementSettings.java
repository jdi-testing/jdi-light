package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.common.UseSmartSearch;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.logger.HighlightStrategy;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.UseSmartSearch.UI_AND_ELEMENTS;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static java.lang.String.format;

public class ElementSettings {
    public JAction1<UIElement> beforeSearch;
    public JFunc2<JDIBase, Object[], WebElement> getElementWithArgs;
    public JFunc2<JDIBase, Object[], WebElement> getElementAndValidate;
    public ElementArea clickType;
    public TextTypes getTextType;
    public SetTextTypes setTextType;
    public int startIndex = 1;
    public Pair<String, JFunc1<WebElement, Boolean>> searchRule;
    public JFunc1<Field, String> name = field -> splitCamelCase(field.getName());
    public String smartTemplate = "[data-testid='%s']";
    public Pair<String, JFunc1<String, String>> smartName
        = Pair.$("kebab-case", SMART_MAP_NAME_TO_LOCATOR.get("kebab-case"));

    public JFunc1<IBaseElement, String> smartLocatorName = el -> smartName.value.execute(el.getName());
    public JFunc2<IBaseElement, String, By> smartLocator = (el, n) -> defineLocator(format(smartTemplate, n));
    public UseSmartSearch useSmartSearch = UI_AND_ELEMENTS;
    public JFunc1<UIElement, String> listLabel = el -> el.getText().trim();
    public List<HighlightStrategy> highlight = new ArrayList<>();
    public JFunc1<String, String> simplifyString =
            s -> s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    public JFunc2<String, String, Boolean> namesEqual =
            (s1, s2) -> simplifyString.execute(s1).equals(simplifyString.execute(s2));
}
