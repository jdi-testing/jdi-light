package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.func.*;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.NameToLocator.*;
import static com.epam.jdi.light.common.UseSmartSearch.*;

public class ElementSettings {
    public JAction1<UIElement> beforeSearch;
    public JFunc2<JDIBase, Object[], WebElement> getElementWithArgs;
    public ElementArea clickType;
    public TextTypes getTextType;
    public SetTextTypes setTextType;
    public Pair<String, JFunc1<WebElement, Boolean>> searchRule;
    public String smartTemplate = "#%s";
    public Pair<String, JFunc1<String, String>> smartName
        = Pair.$("kebab-case", SMART_MAP_NAME_TO_LOCATOR.get("kebab-case"));
    public UseSmartSearch useSmartSearch = UI_AND_ELEMENTS;
}
