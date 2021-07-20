package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsbuilder.JSFilterTemplates.*;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static java.lang.String.format;

public class FilterBuilderActions extends BuilderActions {
    @Override
    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator)) {
            return oneToOne(ctx, locator);
        }
        builder.registerVariable("list");
        builder.registerFunction("filter", FILTER_FUNC);
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }

    @Override
    public String listToOne(By locator) {
        builder.registerVariables("found", "i", builder.getElementName(), "first");
        builder.registerFunction("filter", FILTER_FUNC);
        return format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get + iFrame(locator), "elements[i]", selector(locator, builder)));
    }

    @Override
    public String listToList(By locator) {
        if (isIFrame(locator)) {
            return listToOne(locator);
        }
        GetData data = dataType(locator);
        builder.registerVariables("list", "first");
        builder.registerFunction("filter", FILTER_FUNC);
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, builder.getElementName(), selectorAll(locator, builder)));
    }
}
