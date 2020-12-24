package org.jdiai;

import org.jdiai.interfaces.IBuilderActions;
import org.jdiai.interfaces.IJSBuilder;
import org.openqa.selenium.By;

import java.text.MessageFormat;

import static java.lang.String.format;
import static org.jdiai.GetTypes.dataType;
import static org.jdiai.JSTemplates.*;
import static org.jdiai.WebDriverByUtils.selector;
import static org.jdiai.WebDriverByUtils.selectorAll;

public class BuilderActions implements IBuilderActions {
    private final IJSBuilder builder;
    public BuilderActions(IJSBuilder builder) {
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
