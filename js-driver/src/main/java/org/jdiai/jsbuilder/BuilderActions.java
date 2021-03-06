package org.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static java.lang.String.format;
import static org.jdiai.jsbuilder.GetTypes.dataType;
import static org.jdiai.jsbuilder.JSTemplates.*;
import static org.jdiai.jsdriver.JSDriverUtils.selector;
import static org.jdiai.jsdriver.JSDriverUtils.selectorAll;

public class BuilderActions implements IBuilderActions {
    private IJSBuilder builder;
    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
    }
    public String oneToOne(String ctx, By locator) {
        return builder.registerVariable("element") + format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get, ctx, selector(locator, builder)));
    }
    public String oneToList(String ctx, By locator) {
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }
    public String listToOne(By locator) {
        builder.registerVariables("found", "i", "element");
        return format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get, "elements[i]", selector(locator, builder)));
    }
    public String listToList(By locator) {
        GetData data = dataType(locator);
        builder.registerVariable("list");
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, "element", selectorAll(locator, builder)));
    }
    public String getResult(String collector) {
        return collector.contains("return") ? collector : format(ONE_TO_RESULT, collector);
    }
    public String getResultList(String collector) {
        return collector.contains("return") ? collector : format(LIST_TO_RESULT, collector);
    }
}
