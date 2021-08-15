package com.jdiai.jsbuilder.jsfunctions;

import com.epam.jdi.tools.DataClass;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsdriver.JDINovaBuilderException;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.util.function.Supplier;
import java.util.regex.Matcher;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class BuilderFunctions extends DataClass<BuilderFunctions> {
    public Supplier<IJSBuilder> builder;
    public String oneToOne;
    public String oneToOneFilter;
    public String oneToList;
    public String oneToListFilter;
    public String listToOne;
    public String listToOneFilter;
    public String listToList;
    public String listToListFilter;
    public String result;
    public String listResult;
    public String action;
    public String listAction;

    public BuilderFunctions() {
        this.oneToOne = JSOneToOne.PURE_ONE_TO_ONE;
        this.oneToOneFilter = JSOneToOne.PURE_STRICT_ONE_TO_ONE;
        this.oneToList = JSOneToList.ONE_TO_LIST;
        this.oneToListFilter = JSOneToList.FILTER_ONE_TO_LIST;
        this.listToOne = JSListToOne.PURE_LIST_TO_ONE;
        this.listToOneFilter = JSListToOne.FILTER_LIST_TO_ONE;
        this.listToList = JSListToList.ONE_LIST_TO_LIST;
        this.listToListFilter = JSListToList.FILTER_ONE_LIST_TO_LIST;
        this.result = JSResults.ONE_TO_RESULT;
        this.listResult = JSResults.LIST_TO_RESULT;
        this.action = JSResults.ONE_TO_ACTION;
        this.listAction = JSResults.LIST_TO_ACTION;
    }

    public String oneToOne(String ctx, By locator) {
        return getScript(oneToOne, ctx, locator);
    }
    public String oneToOneFilter(String ctx, By locator) {
        return getScript(oneToOneFilter, ctx, locator);
    }

    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator)) {
            return oneToOne(ctx, locator);
        }
        return getScript(oneToList, ctx, locator);
    }
    public String oneToListFilter(String ctx, By locator) {
        if (isIFrame(locator)) {
            return oneToOneFilter(ctx, locator);
        }
        return getScript(oneToListFilter, ctx, locator);
    }

    public String listToOne(By locator) {
        return getScript(listToOne, null, locator);
    }
    public String listToOneFilter(By locator) {
        return getScript(listToOneFilter, null, locator);
    }

    public String listToList(By locator) {
        if (isIFrame(locator)) {
            return listToOne(locator);
        }
        return getScript(listToList, null, locator);
    }
    public String listToListFilter(By locator) {
        if (isIFrame(locator)) {
            return listToOneFilter(locator);
        }
        return getScript(listToListFilter, null, locator);
    }

    public String result(String collector) {
        return addStyles(collector) + formatCollector(collector, result);
    }

    public String listResult(String collector) {
        return addStyles(collector) + formatCollector(collector, listResult);
    }

    public String action(String collector) {
        return addStyles(collector) + formatCollector(collector, action);
    }

    public String listAction(String collector) {
        return addStyles(collector) + formatCollector(collector, listAction);
    }

    public String addStyles(String collector) {
        return collector.contains("styles.")
            ? "styles = " + builder.get().getElementName() + " ? getComputedStyle(" + builder.get().getElementName() + ") : undefined;\n"
            : "";
    }

    private String formatCollector(String collector, String result) {
        return collector.contains("return") ? collector : format(result, collector);
    }

    protected String getScript(String script, String ctx, By locator) {
        if (isBlank(script)) {
            throw new JDINovaBuilderException("Failed to build js expression. " + script + " can not be blank.");
        }
        if (script.contains("{{one}}")) {
            return script.replace("{{one}}", getElement(ctx, locator));
        }
        if (script.contains("{{list}}")) {
            return script.replace("{{list}}", getElements(ctx, locator));
        }
        Matcher matcher = compile("(.|\n)*\\{\\{one:(?<ctx>[a-zA-Z]+)}}(.|\n)*").matcher(script);
        if (matcher.matches()) {
            return script.replaceAll("\\{\\{one:[a-zA-Z]+}}", getElement(matcher.group("ctx"), locator));
        }
        matcher = compile("(.|\n)*\\{\\{list:(?<ctx>[a-zA-Z]+)}}(.|\n)*").matcher(script);
        if (matcher.matches()) {
            return script.replaceAll("\\{\\{list:[a-zA-Z]+}}", getElements(matcher.group("ctx"), locator));
        }
        throw new JDINovaBuilderException("Failed to build js expression. " + script + " should contains {{one}} or {{list}}");
    }

    protected String getElement(String ctx, By locator) {
        if (ctx == null)  {
            ctx = "element";
        }
        try {
            return MessageFormat.format(dataType(locator).get + iFrame(locator), ctx, selector(locator, builder.get()));
        } catch (Throwable ex) {
            builder.get().cleanup();
            throw new JDINovaBuilderException(ex.getMessage());
        }
    }

    protected String getElements(String ctx, By locator) {
        if (ctx == null)  {
            ctx = "element";
        }
        try {
            return MessageFormat.format(dataType(locator).getAll + iFrame(locator), ctx, selectorAll(locator, builder.get()));
        } catch (Throwable ex) {
            builder.get().cleanup();
            throw new JDINovaBuilderException(ex.getMessage());
        }
    }
}
