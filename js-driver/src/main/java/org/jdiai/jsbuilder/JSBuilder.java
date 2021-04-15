package org.jdiai.jsbuilder;

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.apache.commons.lang3.ObjectUtils;
import org.jdiai.jsdriver.JSException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static org.jdiai.jsbuilder.QueryLogger.logger;
import static org.jdiai.jsbuilder.RetryFunctions.DEFAULT_LIST_SCRIPT_EXECUTE;
import static org.jdiai.jsbuilder.RetryFunctions.DEFAULT_SCRIPT_EXECUTE;

public class JSBuilder implements IJSBuilder {
    protected List<String> variables = new ArrayList<>();
    protected String query = "";
    protected String ctxCode = "";
    protected Supplier<JavascriptExecutor> js;
    public static JFunc1<String, String> PROCESS_RESULT =
        result -> result.length() > 200  ? result.substring(0, 195) + "..." : result;
    public Integer logQuery = null;
    protected MapArray<String, String> useFunctions = new MapArray<>();
    protected IBuilderActions builderActions;

    public JSBuilder() { }
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
    protected String elementName = "element";
    public IJSBuilder setElementName(String elementName) {
        this.elementName = elementName;
        return this;
    }
    public String getElementName() {
        return elementName;
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
    public IJSBuilder logQuery(int LogLevel) {
        this.logQuery = LogLevel;
        return this;
    }
    public boolean logScript() {
        return (logQuery != null ? logQuery : LOG_QUERY) > 0;
    }
    public boolean logResult() {
        return (logQuery != null ? logQuery : LOG_QUERY ) == 2;
    }
    public static JFunc2<Object, String, Object> EXECUTE_SCRIPT = DEFAULT_SCRIPT_EXECUTE;
    public Object executeQuery() {
        String jsScript = getQuery();
        System.out.println("SCRIPT: " + jsScript);
        if (logScript()) {
            logger.info("Execute query:" + LINE_BREAK + jsScript);
        }
        Object result;
        try {
            result = EXECUTE_SCRIPT.execute(js.get(), jsScript);
        } finally {
            cleanup();
        }
        if (result != null && logResult())
            logger.info(">>> " + PROCESS_RESULT.execute(result.toString()));
        return result;
    }
    public static JFunc2<Object, String, List<String>> EXECUTE_LIST_SCRIPT = DEFAULT_LIST_SCRIPT_EXECUTE;
    private static boolean smartStringify = true;
    public static void switchOffStringify() { smartStringify = false; }
    public List<String> executeAsList() {
        String jsScript = getQuery();
        if (logScript())
            logger.info("Execute query:" + LINE_BREAK + jsScript);
        List<String> result;
        try {
            result = EXECUTE_LIST_SCRIPT.execute(js.get(), jsScript);
        } finally {
            cleanup();
        }
        if (result != null && logResult())
            logger.info(">>> " + PROCESS_RESULT.execute(result.toString()));
        return result;
    }
    public String getQuery(String result) {
        return getQuery() + "return " + result;
    }
    public IJSBuilder addJSCode(String code) {
        System.out.println("Query: " + query + "\nCode: " + code);
        query += code;
        return this;
    }
    public IJSBuilder addContextCode(String code) {
        ctxCode += code;
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

    // region private
    public void registerVariables(String... vars) {
        for (String variable : vars) {
            if (!variables.contains(variable))
                variables.add(variable);
        }
    }
    public String registerVariable(String variable) {
        if (!variables.contains(variable))
            variables.add(variable);
        return variable + " = ";
    }
    private String beforeScript() {
        return isNotBlank(ctxCode) ? ctxCode + "\n": "";
    }
    public String rawQuery() {
        return beforeScript() + query;
    }
    public String getQuery() {
        String script = getScript().replace("\nreturn ''", "");
        if (!script.contains("%s")) {
            return script;
        }
        throw new JSException("Failed to execute js script for template locator. Please replace %s before usage");
    }
    protected String getScript() {
        if (ObjectUtils.isEmpty(variables) && ObjectUtils.isEmpty(useFunctions)) {
            return query;
        }
        String jsScript = print(useFunctions.values(), "");
        String letVariables = variables.size() > 1
            ? print(variables, ", ") + ";\n"
            : "";
        return jsScript + "let " + letVariables + rawQuery();
    }
    public void cleanup() {
        useFunctions.clear();
        query = "";
        variables = new ArrayList<>();
        ctxCode = "";
    }
    public void updateFromBuilder(IJSBuilder builder) {
        if (!isClass(builder.getClass(), JSBuilder.class))
            return;
        JSBuilder jsBuilder = (JSBuilder) builder;
        for (Pair<String, String> pair : jsBuilder.useFunctions) {
            if (!useFunctions.has(pair.key)) {
                useFunctions.add(pair);
            }
        }
        for (String variable : jsBuilder.variables) {
            if (!variables.contains(variable)) {
                variables.add(variable);
            }
        }
    }
    public JSBuilder copy() {
        JSBuilder result = new JSBuilder();
        result.builderActions = builderActions;
        result.ctxCode = ctxCode;
        result.js = js;
        result.useFunctions = useFunctions;
        result.logQuery = logQuery;
        result.variables = variables;
        return result;
    }
    // endregion
}
