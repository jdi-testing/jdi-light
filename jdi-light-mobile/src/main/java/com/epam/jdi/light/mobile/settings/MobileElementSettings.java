package com.epam.jdi.light.mobile.settings;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.common.UseSmartSearch;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.logger.HighlightStrategy;
import com.epam.jdi.light.mobile.elements.base.MobileTextTypes;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.UseSmartSearch.UI_AND_ELEMENTS;

public class MobileElementSettings {
    public JAction1<MobileUIElement> beforeSearch;
    public JFunc2<JDIBase, Object[], WebElement> getElementWithArgs;
    public ElementArea clickType;
    public MobileTextTypes getTextType;
    public SetTextTypes setTextType;
    public int startIndex = 1;
    public Pair<String, JFunc1<WebElement, Boolean>> searchRule;
    public String smartTemplate = "#%s";
    public Pair<String, JFunc1<String, String>> smartName
            = Pair.$("kebab-case", SMART_MAP_NAME_TO_LOCATOR.get("kebab-case"));
    public UseSmartSearch useSmartSearch = UI_AND_ELEMENTS;
    public JFunc1<MobileUIElement, String> listLabel = el -> el.getText().trim();
    public List<HighlightStrategy> highlight = new ArrayList<>();
}
