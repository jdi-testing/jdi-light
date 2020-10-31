package org.jdiai;

import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.map.MapArray;
import org.jdiai.interfaces.IBuilderActions;
import org.jdiai.interfaces.IJSBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

public class JSBuilder implements IJSBuilder {
    protected final List<String> variables = new ArrayList<>();
    protected String query = "";
    protected JavascriptExecutor js;
    public static boolean LOG_QUERY = false;
    public boolean logQuery = LOG_QUERY;
    public static JAction1<String> logger = System.out::println;
    protected MapArray<String, String> useFunctions = new MapArray<>();
    protected IBuilderActions builderActions;

    public JSBuilder(WebDriver driver) {
        this(driver, null);
    }
    public JSBuilder(WebDriver driver, IBuilderActions builderActions) {
        this.js = (JavascriptExecutor) driver;
        this.builderActions = builderActions != null
            ? builderActions
            : new BuilderActions(this);
    }
    public IJSBuilder registerFunction(String name, String function) {
        useFunctions.update(name, function);
        return this;
    }
    public IJSBuilder logQuery() {
        this.logQuery = true;
        return this;
    }
    public String executeQuery() {
        String jsScript = getScript();
        if (logQuery)
            logger.execute("Execute query:" + LINE_BREAK + jsScript);
        String result = (String) js.executeScript(jsScript);
        if (result != null && logQuery)
            logger.execute(">>> " + result);
        return result;
    }
    public List<String> executeAsList() {
        String jsScript = getScript();
        if (logQuery)
            logger.execute("Execute query:" + LINE_BREAK + jsScript);
        List<String> result = (List<String>) js.executeScript(jsScript);
        if (result != null && logQuery)
            logger.execute(">>> " + result);
        return result;
    }
    public String getQuery(String result) {
        return getScript() + "return " + result;
    }
    public String getQuery() {
        return getScript();
    }
    public IJSBuilder addJSCode(String code) {
        query += code;
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
        return collectResult.trim().startsWith("{")
            ? "JSON.stringify(" + collectResult + ")"
            : collectResult;
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
    protected String getScript() {
        String jsScript = print(useFunctions.values(), "");
        if (variables.size() == 1)
            return jsScript + "let " + query;
        for (String variable : variables) {
            jsScript += "let " + variable + "; ";
        }
        return jsScript + "\n" + query;
    }
    // endregion
}
