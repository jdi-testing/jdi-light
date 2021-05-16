package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsbuilder.JSTemplates.*;
import static com.jdiai.jsdriver.JSDriverUtils.selector;
import static com.jdiai.jsdriver.JSDriverUtils.selectorAll;
import static java.lang.String.format;

public class BuilderActions implements IBuilderActions {
    private IJSBuilder builder;
    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
    }
    public String oneToOne(String ctx, By locator) {
        return builder.registerVariable(builder.getElementName()) + format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get, ctx, selector(locator, builder)));
    }
    public String oneToList(String ctx, By locator) {
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }
    public String listToOne(By locator) {
        builder.registerVariables("found", "i", builder.getElementName());
        return format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get, "elements[i]", selector(locator, builder)));
    }
    public String listToList(By locator) {
        GetData data = dataType(locator);
        builder.registerVariable("list");
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, builder.getElementName(), selectorAll(locator, builder)));
    }
    public String doAction(String collector) {
        return collector;
    }
    public String getResult(String collector) {
        return collector.contains("return") ? collector : format(ONE_TO_RESULT, collector);
    }
    public String getResultList(String collector) {
        return collector.contains("return") ? collector : format(LIST_TO_RESULT, collector);
    }
}
