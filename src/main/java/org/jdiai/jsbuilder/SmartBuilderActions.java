package org.jdiai.jsbuilder;

import org.jdiai.GetData;
import org.openqa.selenium.By;

import java.text.MessageFormat;

import static java.lang.String.format;
import static org.jdiai.GetTypes.dataType;
import static org.jdiai.WebDriverByUtils.*;
import static org.jdiai.jsbuilder.JSSmartTemplates.*;
import static org.jdiai.jsbuilder.JSTemplates.ONE_TO_ONE;

public class SmartBuilderActions implements IBuilderActions {
    private IJSBuilder builder;
    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
    }
    public String oneToOne(String ctx, By locator) {
        String jsScript = builder.registerVariable("element") + format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get, ctx, selector(locator, builder)));
        return isIFrame(locator) ? jsScript + ".contentWindow.document" : jsScript;
    }
    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator))
            return oneToOne(ctx, locator);
        builder.registerVariable("list");
        builder.registerFunction("filter", FILTER_FUNC);
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }
    public String listToOne(By locator) {
        builder.registerVariables("found", "i", "element", "first");
        builder.registerFunction("filter", FILTER_FUNC);
        String jsScript = format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get, "elements[i]", selector(locator, builder)));
        return isIFrame(locator) ? jsScript + ".contentWindow.document" : jsScript;
    }
    public String listToList(By locator) {
        if (isIFrame(locator))
            return listToOne(locator);
        GetData data = dataType(locator);
        builder.registerVariables("list", "first");
        builder.registerFunction("filter", FILTER_FUNC);
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, "element", selectorAll(locator, builder)));
    }
    public String getResult(String collector) {
        return collector.contains("return") ? collector : format(ONE_TO_RESULT, collector);
    }
    public String getResultList(String collector) {
        return collector.contains("return") ? collector : format(LIST_TO_RESULT, collector);
    }
}
