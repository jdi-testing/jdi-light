package org.jdiai;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static java.lang.String.format;
import static org.jdiai.GetTypes.dataType;
import static org.jdiai.JSTemplates.*;

public class BuilderActions implements IBuilderActions {
    private final JSBuilder builder;
    public BuilderActions(JSBuilder builder) {
        this.builder = builder;
    }
    public String oneToOne(String ctx, By locator) {
        return builder.registerVariable("element") + format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get, ctx, builder.selector(locator)));
    }
    public String oneToList(String ctx, By locator) {
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, builder.selectorAll(locator)));
    }
    public String listToOne(By locator) {
        builder.registerVariables("found", "i", "element");
        return format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get, "elements[i]", builder.selector(locator)));
    }
    public String listToList(By locator) {
        GetData data = dataType(locator);
        builder.registerVariable("result");
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, "element", builder.selectorAll(locator)));
    }
    public String collect(String collector) {
        builder.registerVariable("result");
        return format(LIST_TO_RESULT, collector);
    }
}
