package com.jdiai.jsbuilder.jsfunctions;

import com.epam.jdi.tools.DataClass;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsdriver.JDINovaBuilderException;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.util.regex.Matcher;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class BuilderFunctions extends DataClass<BuilderFunctions> {
    public final IJSBuilder builder;
    public String oneToOne;
    public String oneToList;
    public String listToOne;
    public String listToList;
    public String result;
    public String condition;
    public String listResult;
    public String listConditionResult;
    public String action;
    public String listAction;
    public String listConditionAction;
    public boolean lastIsElement;

    public BuilderFunctions(IJSBuilder builder) {
        this.builder = builder;
        this.oneToOne = JSOneToOne.PURE_ONE_TO_ONE;
        this.oneToList = JSOneToList.ONE_TO_LIST;
        this.listToOne = JSListToOne.PURE_LIST_TO_ONE;
        this.listToList = JSListToList.ONE_LIST_TO_LIST;
        this.result = JSResults.ONE_TO_RESULT;
        this.condition = JSResults.CONDITION;
        this.listResult = JSResults.LIST_TO_RESULT;
        this.listConditionResult = JSResults.PURE_CONDITION_LIST_TO_RESULT;
        this.action = JSResults.ONE_TO_ACTION;
        this.listAction = JSResults.LIST_TO_ACTION;
        this.listConditionAction = JSResults.PURE_CONDITION_LIST_TO_ACTION;
    }

    public String oneToOne(String ctx, By locator) {
        lastIsElement = true;
        return getScript(oneToOne, ctx, locator);
    }

    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator)) {
            return oneToOne(ctx, locator);
        }
        lastIsElement = false;
        return getScript(oneToList, ctx, locator);
    }

    public String listToOne(By locator) {
        lastIsElement = true;
        return getScript(listToOne, null, locator);
    }

    public String listToList(By locator) {
        if (isIFrame(locator)) {
            return listToOne(locator);
        }
        lastIsElement = false;
        return getScript(listToList, null, locator);
    }

    public String result(String collector) {
        String prefix = addStyles(collector);
        if (builder.hasConditions()) {
            prefix += condition;
        }
        return prefix + formatCollector(collector, result);
    }

    public String listResult(String collector) {
        if (builder.hasConditions()) {
            return addStyles(collector) + formatCollector(collector, listConditionResult);
        }
        return addStyles(collector) + formatCollector(collector, listResult);
    }

    public String action(String collector) {
        String prefix = addStyles(collector);
        if (builder.hasConditions()) {
            prefix += condition;
        }
        return prefix + formatCollector(collector, action);
    }

    public String listAction(String collector) {
        if (builder.hasConditions()) {
            return addStyles(collector) + formatCollector(collector, listConditionAction);
        }
        return addStyles(collector) + formatCollector(collector, listAction);
    }

    protected String addStyles(String collector) {
        return collector.contains("styles.")
            ? "styles = " + builder.getElementName() + " ? getComputedStyle(" + builder.getElementName() + ") : undefined;\n"
            : "";
    }

    private String formatCollector(String collector, String result) {
        return collector.contains("return") ? collector : format(result, collector);
    }

    protected String processResult(String collector, String result) {
        return collector.contains("return") ? collector : format(result, collector);
    }

    protected String getScript(String action, String ctx, By locator) {
        if (isBlank(action)) {
            throw new JDINovaBuilderException("Failed to build js expression. " + action + " can not be blank.");
        }
        if (action.contains("{{one}}")) {
            return action.replace("{{one}}", getElement(ctx, locator));
        }
        if (action.contains("{{list}}")) {
            return action.replace("{{list}}", getElements(ctx, locator));
        }
        Matcher matcher = compile("(.|\n)*\\{\\{one:(?<ctx>[a-zA-Z]+)}}(.|\n)*").matcher(action);
        if (matcher.matches()) {
            return action.replaceAll("\\{\\{one:[a-zA-Z]+}}", getElement(matcher.group("ctx"), locator));
        }
        matcher = compile("(.|\n)*\\{\\{list:(?<ctx>[a-zA-Z]+)}}(.|\n)*").matcher(action);
        if (matcher.matches()) {
            return action.replaceAll("\\{\\{list:[a-zA-Z]+}}", getElements(matcher.group("ctx"), locator));
        }
        throw new JDINovaBuilderException("Failed to build js expression. " + action + " should contains {{one}} or {{list}}");
    }

    protected String getElement(String ctx, By locator) {
        if (ctx == null)  {
            ctx = "element";
        }
        return MessageFormat.format(dataType(locator).get + iFrame(locator), ctx, selector(locator, builder));
    }

    protected String getElements(String ctx, By locator) {
        if (ctx == null)  {
            ctx = "element";
        }
        return MessageFormat.format(dataType(locator).getAll + iFrame(locator), ctx, selectorAll(locator, builder));
    }
}
