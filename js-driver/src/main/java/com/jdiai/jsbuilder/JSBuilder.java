package com.jdiai.jsbuilder;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import com.jdiai.jsdriver.JDINovaException;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jsbuilder.RetryFunctions.DEFAULT_LIST_SCRIPT_EXECUTE;
import static com.jdiai.jsbuilder.RetryFunctions.DEFAULT_SCRIPT_EXECUTE;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JSBuilder implements IJSBuilder {
    public Integer logQuery = null;
    public Function<String, String> processResultFunc =
        result -> result.length() > 200
            ? result.substring(0, 195) + "..."
            : result;
    protected String query = "";
    protected String searchScript = "";
    protected Supplier<JavascriptExecutor> js;
    protected MapArray<String, String> useFunctions = new MapArray<>();
    protected String condition = null;
    protected String conditionFunc = null;
    protected String filter = null;
    protected IBuilderActions builderActions;

    public JSBuilder(Supplier<WebDriver> driver) {
        this(driver, null);
    }

    public JSBuilder(Supplier<WebDriver> driver, IBuilderActions builderActions) {
        this.js = () -> (JavascriptExecutor) driver.get();
        this.builderActions = builderActions != null
            ? builderActions
            : new BuilderActions();
        this.builderActions.setBuilder(this);
    }
    public JSBuilder setCondition(String condition) {
        this.condition = condition;
        return this;
    }
    public JSBuilder setCondition(String condition, String conditionFunc) {
        this.conditionFunc = actions().getResult(conditionFunc);
        return setCondition(condition);
    }


    public IJSBuilder setFilter(String filter) {
        if (isBlank(filter)) {
            this.filter = null;
            return this;
        }
        String filterBody = actions().getResult(filter);
        if (filterBody.endsWith("\n")) {
            filterBody = filterBody.substring(0, filterBody.length() - 1);
        }
        filterBody = "  " + filterBody.replace("\n", "\n  ");
        this.filter = "filter = function (element) {\n" + filterBody + "\n}\n";
        return this;
    }
    public JSBuilder setProcessResultFunc(Function<String, String> processResultFunc) {
        this.processResultFunc = processResultFunc;
        return this;
    }

    protected String elementName = "element";

    public IJSBuilder setElementName(String elementName) {
        this.elementName = elementName;
        return this;
    }

    public String getElementName() {
        return elementName;
    }

    public IBuilderActions actions() {
        return builderActions;
    }
    public IJSBuilder updateActions(IBuilderActions builderActions) {
        this.builderActions = builderActions;
        this.builderActions.setBuilder(this);
        return this;
    }
    public IJSBuilder registerFunction(String name, String function) {
        useFunctions.update(name, function);
        return this;
    }
    public String condition() {
        if (conditionFunc != null) {
            registerFunction("condition", "condition = function(element) {\n" + conditionFunc + "\n}\n");
        }
        return condition != null ? condition : "";
    }
    public boolean noFilter() {
        return filter == null;
    }
    public boolean hasFilter() {
        if (filter != null) {
            registerFunction("filter", filter);
            return true;
        }
        return false;
    }

    public IJSBuilder logQuery(int logLevel) {
        this.logQuery = logLevel;
        return this;
    }

    private int shouldLogQuery() {
        return logQuery != null ? logQuery : LOG_QUERY;
    }

    public boolean logScript() {
        return shouldLogQuery() > 0;
    }

    public boolean logResult() {
        return shouldLogQuery() == 2;
    }

    public static BiFunction<Object, String, Object> EXECUTE_SCRIPT = DEFAULT_SCRIPT_EXECUTE;

    public static Safe<String> lastScriptExecution = new Safe<>();

    public Object executeQuery() {
        lastScriptExecution.reset();
        String jsScript = getQuery();
        if (logScript()) {
            logger.info("Execute query:" + LINE_BREAK + jsScript);
        }
        Object result = getScriptResult(jsScript);
        lastScriptExecution.set(jsScript + "\n" + result);
        if (result != null && logResult()) {
            logger.info(">>> " + processResultFunc.apply(result.toString()));
        }
        return result;
    }

    private Object getScriptResult(String jsScript) {
        try {
            return EXECUTE_SCRIPT.apply(js.get(), jsScript);
        } finally {
            cleanup();
        }
    }

    public static BiFunction<Object, String, List<Object>> EXECUTE_LIST_SCRIPT = DEFAULT_LIST_SCRIPT_EXECUTE;

    private static boolean smartStringify = true;

    public static void switchOffStringify() { smartStringify = false; }

    public List<Object> executeAsList() {
        String jsScript = getQuery();
        if (logScript()) {
            logger.info("Execute query:" + LINE_BREAK + jsScript);
        }
        List<Object> result;
        try {
            result = EXECUTE_LIST_SCRIPT.apply(js.get(), jsScript);
        } finally {
            cleanup();
        }
        if (result != null && logResult()) {
            logger.info(">>> " + processResultFunc.apply(result.toString()));
        }
        return result;
    }

    public String getQuery(String result) {
        return getQuery() + "return " + result;
    }

    public IJSBuilder addJSCode(String code) {
        query += code;
        return this;
    }

    public IJSBuilder setSearchScript(String code) {
        searchScript += code;
        return this;
    }

    public IJSBuilder oneToOne(String ctx, By locator) {
        return addJSCode(builderActions.oneToOne(ctx, locator));
    }

    public IJSBuilder listToOne(By locator) {
        return addJSCode(builderActions.listToOne(locator));
    }

    public IJSBuilder oneToList(String ctx, By locator) {
        return addJSCode(builderActions.oneToList(ctx, locator));
    }

    public IJSBuilder listToList(By locator) {
        return addJSCode(builderActions.listToList(locator));
    }

    public IJSBuilder doAction(String collectResult) {
        return addJSCode(builderActions.doAction(collectResult));
    }

    public IJSBuilder getResult(String collectResult) {
        return addJSCode(builderActions.getResult(getCollector(collectResult)));
    }

    public IJSBuilder getResultList(String collectResult) {
        return addJSCode(builderActions.getResultList(getCollector(collectResult)));
    }

    public IJSBuilder trigger(String event) {
        return trigger(event,"'bubbles': true");
    }

    public IJSBuilder trigger(String event, String options) {
        return addJSCode("element.dispatchEvent(new Event('" + event + "', { " + options + " }));\n");
    }

    protected String getCollector(String collectResult) {
        if (collectResult == null) {
            return "";
        }
        if (smartStringify) {
            if (collectResult.trim().contains("return {") && collectResult.trim().contains("}")) {
                return collectResult.replace("return {", "return JSON.stringify({")
                    .replace("}", "})");
            }
            if (collectResult.trim().contains("return [") && collectResult.trim().contains("]")) {
                return collectResult.replace("return [", "return JSON.stringify([")
                    .replace("}", "})");
            }
            if (collectResult.trim().startsWith("{") && collectResult.trim().contains("}")) {
                return collectResult.replace("{", "JSON.stringify({")
                    .replace("}", "})");
            }
            if (collectResult.trim().startsWith("[") && collectResult.trim().contains("]")) {
                return collectResult.replace("[", "JSON.stringify([")
                    .replace("]", "])");
            }
        }
        return collectResult;
    }
    private String beforeScript() {
        return isNotBlank(searchScript)
            ? searchScript + "\n"
            : "";
    }
    public String getQuery() {
        if (ObjectUtils.isEmpty(useFunctions)) {
            return getScript();
        }
        String script = isNotEmpty(useFunctions) ? print(useFunctions.values(), "") : "";
        script += getScript().replace("\nreturn ''", "");
        if (!script.contains("%s")) {
            return script;
        }
        throw new JDINovaException("Failed to execute js script for template locator. Please replace %s before usage");
    }
    public String getScript() {
        return beforeScript() + query;
    }
    public void cleanup() {
        if (isBlank(searchScript)) {
            useFunctions.clear();
        }
        query = "";
    }
    public void updateFromBuilder(IJSBuilder builder) {
        if (!isClass(builder.getClass(), JSBuilder.class)) {
            return;
        }
        JSBuilder jsBuilder = (JSBuilder) builder;
        for (Pair<String, String> pair : jsBuilder.useFunctions) {
            if (!useFunctions.has(pair.key)) {
                useFunctions.add(pair);
            }
        }
    }
    public JSBuilder copy() {
        JSBuilder result = new JSBuilder(null, builderActions);
        result.searchScript = searchScript;
        result.js = js;
        result.useFunctions = useFunctions;
        result.condition = condition;
        result.filter = filter;
        result.logQuery = logQuery;
        return result;
    }
    // endregion
}
