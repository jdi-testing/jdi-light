package com.jdiai.jsbuilder;

import com.epam.jdi.tools.StringUtils;
import com.jdiai.jsbuilder.jsfunctions.BuilderFunctions;
import com.jdiai.jsdriver.JDINovaBuilderException;
import org.openqa.selenium.By;

import java.text.MessageFormat;
import java.util.function.Supplier;
import java.util.regex.Matcher;

import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsdriver.JSDriverUtils.*;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class BuilderActions implements IBuilderActions {
    protected BuilderFunctions functions;
    public Supplier<IJSBuilder> builder;

    public BuilderActions() { this(new BuilderFunctions()); }
    public BuilderActions(BuilderFunctions functions) {
        this.functions = functions;
    }

    public void setBuilder(Supplier<IJSBuilder> builder) {
        this.builder = builder;
    }

    public String oneToOne(String ctx, By locator) {
        return getScript(functions.oneToOne, ctx, locator);
    }

    public String oneToOneFilter(String ctx, By locator, String filterName) {
        return getScript(functions.oneToOneFilter.replace("{{filter}}", filterName),
                ctx,
                locator);
    }
    protected String processTry(String ctx,String script) {
        String prefix = script.startsWith("try") && ctx.equals("document")
            ? "let element;\n"
            : "";
        return prefix + script;
    }

    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator)) {
            return oneToOne(ctx, locator);
        }
        return getScript(functions.oneToList, ctx, locator);
    }

    public String oneToListFilter(String ctx, By locator, String filterName) {
        if (isIFrame(locator)) {
            return oneToOneFilter(ctx, locator, filterName);
        }
        return getScript(functions.oneToListFilter.replace("{{filter}}", filterName),
                ctx,
                locator);
    }

    public String listToOne(By locator) {
        return getScript(functions.listToOne, null, locator);
    }

    public String listToOneFilter(By locator, String filterName) {
        return getScript(functions.listToOneFilter.replace("{{filter}}", filterName),
                null,
                locator);
    }

    public String listToList(By locator) {
        if (isIFrame(locator)) {
            return listToOne(locator);
        }
        return getScript(functions.listToList, null, locator);
    }

    public String listToListFilter(By locator, String filterName) {
        if (isIFrame(locator)) {
            return listToOneFilter(locator, filterName);
        }
        return getScript(functions.listToListFilter.replace("{{filter}}", filterName),
                null,
                locator);
    }

    public String getResult(String collector) {
        return preResult(collector) + formatCollector(collector, functions.result);
    }

    public String getResultList(String collector) {
        if (collector.contains("styles")) {
            collector = collector.replace("styles", "getComputedStyle(element)");
        }
        return preResult(collector) + formatCollector(collector, functions.listResult);
    }

    public String doAction(String collector) {
        return preResult(collector) + formatCollector(collector, functions.action);
    }

    public String doListAction(String collector) {
        return preResult(collector) + formatCollector(collector, functions.listAction);
    }

    protected String addStyles(String collector) {
        return collector.contains("styles.")
            ? "styles = getComputedStyle(" + builder.get().getElementName() + ");\n"
            : "";
    }

    private String formatCollector(String collector, String result) {
        return collector.contains("return") ? collector : StringUtils.format(result, collector);
    }

    protected String getScript(String script, String ctx, By locator) {
        if (isBlank(script)) {
            throw new JDINovaBuilderException("Failed to build js expression. " + script + " can not be blank.");
        }
        script = processTry(ctx, script);
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

    public String preResult(String collector) {
        return addStyles(collector);
    }
}
