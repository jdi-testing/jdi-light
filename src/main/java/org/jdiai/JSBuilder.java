package org.jdiai;

import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static org.jdiai.JSTemplates.XPATH_FUNC;
import static org.jdiai.JSTemplates.XPATH_LIST_FUNC;
import static org.jdiai.WebDriverByUtils.getByLocator;
import static org.jdiai.WebDriverByUtils.getByType;

public class JSBuilder implements IJSBuilder {
    private final List<String> variables = new ArrayList<>();
    private String query = "";
    private JavascriptExecutor js;
    public boolean logQuery = false;
    public static JAction1<String> logger = System.out::println;
    private MapArray<String, String> useFunctions = new MapArray<>();
    private IBuilderActions builderActions;
    private final String collectResult;

    public JSBuilder(WebDriver driver, String collectResult) {
        this(driver, null, collectResult);
    }
    public JSBuilder(WebDriver driver, IBuilderActions builderActions, String collectResult) {
        this.js = (JavascriptExecutor) driver;
        this.builderActions = builderActions != null ? builderActions : new BuilderActions(this);
        this.collectResult = collectResult;
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
        String jsScript = getScript() + "return " + collectResult;
        if (logQuery)
            logger.execute("Execute query:" + LINE_BREAK + jsScript);
        String result = (String) js.executeScript(jsScript);
        if (result != null && logQuery)
            logger.execute(">>> " + result);
        return result;
    }
    public List<String> executeAsList() {
        query += builderActions.collect(collectResult);
        String jsScript = getScript() + "return result;";
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

    public String selector(By locator) {
        String selector = getByLocator(locator).replaceAll("'", "\"");
        if (getByType(locator).equals("xpath"))
            registerFunction("xpath", XPATH_FUNC);
        return selector;
    }
    public String selectorAll(By locator) {
        String selector = getByLocator(locator).replaceAll("'", "\"");
        if (getByType(locator).equals("xpath"))
            registerFunction("xpathList", XPATH_LIST_FUNC);
        return selector;
    }
    public IJSBuilder getOneToOne(String ctx, By locator) {
        query += builderActions.oneToOne(ctx, locator);
        return this;
    }
    public IJSBuilder getListToOne(By locator) {
        query += builderActions.listToOne(locator);
        return this;
    }
    public IJSBuilder getOneToList(String ctx, By locator) {
        query += builderActions.oneToList(ctx, locator);
        return this;
    }
    public IJSBuilder getListToList(By locator) {
        query += builderActions.listToList(locator);
        return this;
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
    private String getScript() {
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
