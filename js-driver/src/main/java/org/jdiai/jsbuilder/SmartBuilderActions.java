package org.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.text.MessageFormat;

import static java.lang.String.format;
import static org.jdiai.jsbuilder.GetTypes.dataType;
import static org.jdiai.jsbuilder.JSSmartTemplates.*;
import static org.jdiai.jsbuilder.JSTemplates.ONE_TO_ONE;
import static org.jdiai.jsdriver.JSDriverUtils.*;

public class SmartBuilderActions implements IBuilderActions {
    private IJSBuilder builder;
    public void setBuilder(IJSBuilder builder) {
        this.builder = builder;
    }
    public String oneToOne(String ctx, By locator) {
        return builder.registerVariable(builder.getElementName()) + format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get + iFrame(locator), ctx, selector(locator, builder)));
    }
    private String iFrame(By locator) {
        return isIFrame(locator) ? ".contentWindow.document" : "";
    }
    public String oneToList(String ctx, By locator) {
        if (isIFrame(locator))
            return oneToOne(ctx, locator);
        builder.registerVariable("list");
        builder.registerFunction("filter", FILTER_FUNC);
        return builder.registerVariable("elements") + format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selectorAll(locator, builder)));
    }
    public String listToOne(By locator) {
        builder.registerVariables("found", "i", builder.getElementName(), "first");
        builder.registerFunction("filter", FILTER_FUNC);
        return format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get + iFrame(locator), "elements[i]", selector(locator, builder)));
    }
    public String listToList(By locator) {
        if (isIFrame(locator))
            return listToOne(locator);
        GetData data = dataType(locator);
        builder.registerVariables("list", "first");
        builder.registerFunction("filter", FILTER_FUNC);
        return format(LIST_TO_LIST, MessageFormat.format(data.getAll, builder.getElementName(), selectorAll(locator, builder)));
    }
    public String doAction(String collector) {
        return addBeforeReturn(collector) + collector;
    }
    public String getResult(String collector) {
        return addBeforeReturn(collector) +
            (collector.contains("return") ? collector : format(ONE_TO_RESULT, collector));
    }
    public String getResultList(String collector) {
        return addBeforeReturn(collector) +
            (collector.contains("return") ? collector : format(LIST_TO_RESULT, collector));
    }
    private String addBeforeReturn(String collector) {
        return collector.contains("styles.")
            ? "const styles = getComputedStyle(" + builder.getElementName() + ");\n" : "";
    }
}
