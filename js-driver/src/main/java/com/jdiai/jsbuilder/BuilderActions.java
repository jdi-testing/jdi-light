package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static java.lang.String.format;

public class BuilderActions implements IBuilderActions {
    protected IJSBuilder builder;
    protected Boolean lastIsElement = null;
    protected Boolean noFilters = false;

    public void noFilters() {
        noFilters = true;
    }
    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
    }

    public String oneToOne(String ctx, By locator) {
        lastIsElement = true;
        return builder.registerVariable(builder.getElementName()) +
            format(JSTemplates.ONE_TO_ONE, MessageFormat.format(dataType(locator).get + iFrame(locator), ctx, selector(locator, builder)));
    }

    protected String iFrame(By locator) {
        return isIFrame(locator) ? ".contentWindow.document" : "";
    }

    public String oneToList(String ctx, By locator) {
        lastIsElement = false;
        if (isIFrame(locator)) {
            return oneToOne(ctx, locator);
        }
        builder.registerVariable("list");
        // boolean hasFilter = builder.hasFilter();
        // String script = hasFilter ? JSFilterTemplates.ONE_TO_LIST : JSTemplates.ONE_TO_LIST;
        return builder.registerVariable("elements") + format(JSTemplates.ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }

    public String listToOne(By locator) {
        lastIsElement = true;
        builder.registerVariables("found", "i", builder.getElementName(), "first");
        boolean hasFilter = builder.hasFilter();
        String script = hasFilter ? JSFilterTemplates.LIST_TO_ONE : JSTemplates.LIST_TO_ONE;
        return format(script, MessageFormat.format(dataType(locator).get + iFrame(locator), "elements[i]", selector(locator, builder)));
    }

    public String listToList(By locator) {
        lastIsElement = false;
        if (isIFrame(locator)) {
            return listToOne(locator);
        }
        GetData data = dataType(locator);
        builder.registerVariables("list", "first");
        // boolean hasFilter = builder.hasFilter();
        // String script = hasFilter ? JSFilterTemplates.LIST_TO_LIST : JSTemplates.LIST_TO_LIST;
        return format(JSTemplates.LIST_TO_LIST, MessageFormat.format(data.getAll, builder.getElementName(), selectorAll(locator, builder)));
    }

    public String doAction(String collector) {
        return addBeforeReturn(collector) + collector;
    }

    private String processResult(String collector, String result) {
        return collector.contains("return") ? collector : format(result, collector);
    }

    public String getResult(String collector) {
        return addBeforeReturn(collector) + processResult(collector, JSTemplates.ONE_TO_RESULT);
    }

    public String getResultList(String collector) {
        return addBeforeReturn(collector) + processResult(collector, JSTemplates.LIST_TO_RESULT);
    }

    protected String addBeforeReturn(String collector) {
        return validateElement() + addStyles(collector);
    }
    protected String validateElement() {
        if (noFilters || lastIsElement == null) {
            noFilters = false;
            return "";
        }
        if (lastIsElement) {
            lastIsElement = null;
            return builder.condition();
        } else {
            if (builder.hasFilter()) {
                lastIsElement = null;
                return JSFilterTemplates.LIST_TO_LIST_STRICT;
            }
        }
        lastIsElement = null;
        return "";
    }

    protected String addStyles(String collector) {
        return collector.contains("styles.")
            ? "styles = " + builder.getElementName() + " ? getComputedStyle(" + builder.getElementName() + ") : undefined;\n"
            : "";
    }
}
