package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsbuilder.JSTemplates.*;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static java.lang.String.format;

public class BuilderActions implements IBuilderActions {
    protected IJSBuilder builder;

    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
    }

    public String oneToOne(String ctx, By locator) {
        return builder.registerVariable(builder.getElementName()) +
                format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get + iFrame(locator), ctx, selector(locator, builder)));
    }

    protected String iFrame(By locator) {
        return isIFrame(locator) ? ".contentWindow.document" : "";
    }

    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator)) {
            return oneToOne(ctx, locator);
        }
        builder.registerVariable("list");
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }

    public String listToOne(By locator) {
        builder.registerVariables("found", "i", builder.getElementName(), "first");
        return format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get + iFrame(locator), "elements[i]", selector(locator, builder)));
    }

    public String listToList(By locator) {
        if (isIFrame(locator)) {
            return listToOne(locator);
        }
        GetData data = dataType(locator);
        builder.registerVariables("list", "first");
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, builder.getElementName(), selectorAll(locator, builder)));
    }

    public String doAction(String collector) {
        return addBeforeReturn(collector) + collector;
    }

    private String processResult(String collector, String result) {
        return collector.contains("return") ? collector : format(result, collector);
    }

    public String getResult(String collector) {
        return addBeforeReturn(collector) + processResult(collector, ONE_TO_RESULT);
    }

    public String getResultList(String collector) {
        return addBeforeReturn(collector) + processResult(collector, LIST_TO_RESULT);
    }

    protected String addBeforeReturn(String collector) {
        return builder.condition() + addStyles(collector);
    }
    protected String addStyles(String collector) {
        return collector.contains("styles.")
                ? "const styles = " + builder.getElementName() + " ? getComputedStyle(" + builder.getElementName() + ") : undefined;\n"
                : "";
    }
}
