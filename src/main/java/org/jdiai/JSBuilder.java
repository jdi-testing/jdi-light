package org.jdiai;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;
import static org.jdiai.GetTypes.dataType;
import static org.jdiai.JSTemplates.*;
import static org.jdiai.WebDriverByUtils.getByLocator;

public class JSBuilder {
    List<String> variables = new ArrayList<>();
    String query = "";
    JavascriptExecutor js;
    public boolean logQuery = false;

    public JSBuilder(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    public JSBuilder logQuery() {
        this.logQuery = true;
        return this;
    }
    public String executeQuery(String result) {
        String jsScript = getScript() + "return " + result;
        if (logQuery)
            System.out.println("Execute query:" + LINE_BREAK + jsScript);
        return (String) js.executeScript(jsScript);
    }
    public List<String> executeAsList(String result) {
        String jsScript = getScript() + "return " + result;
        if (logQuery)
            System.out.println("Execute query:" + LINE_BREAK + jsScript);
        return (List<String>) js.executeScript(jsScript);
    }
    public String getQuery(String result) {
        return getScript() + "return " + result;
    }

    private String selector(By locator) {
        return getByLocator(locator).replaceAll("'", "\"");
    }
    public JSBuilder getOneFromOne(String context, By locator) {
        query += register("element") + MessageFormat.format(dataType(locator).get, context, selector(locator));
        return this;
    }
    public JSBuilder getOneFromList(By locator) {
        register("found");
        register("i");
        query += register("element") +
            format(GET_ONE_FROM_LIST, MessageFormat.format(dataType(locator).get, "elements[i]", selector(locator)));
        return this;
    }
    public JSBuilder getListFromOne(String context, By locator) {
        query += register("elements") +
            MessageFormat.format(dataType(locator).getAll, context, selector(locator)) + ";\n";
        return this;
    }
    public JSBuilder getListFromOne(String context, By locator, String param) {
        GetData data = dataType(locator);
        register("result");
        query += register("elements") +
            MessageFormat.format(data.getAll, context, selector(locator)) + ";\n" +
            format(GET_LIST, data.length, format(data.index, "i"), param);
        return this;
    }
    public JSBuilder getListFromList(By locator, By prevLocator) {
        register("elements");
        register("result");
        GetData prevData = dataType(prevLocator);
        GetData data = dataType(locator);
        query += format(GET_LIST_FROM_LIST, prevData.length,
            MessageFormat.format(data.getAll, "elements[i]", selector(locator)),
            data.length, format(data.index, "j"));
        return this;
    }
    public JSBuilder getListFromList(By locator, By prevLocator, String param) {
        register("elements");
        register("result");
        GetData prevData = dataType(prevLocator);
        GetData data = dataType(locator);
        query += format(GET_LIST_FROM_LIST, prevData.length,
            MessageFormat.format(data.getAll, "elements[i]", selector(locator)),
            data.length, format(data.index, "j"))
            + format(GET_LIST, data.length, format(data.index, "i"), param);
        return this;
    }

    // region private
    private String register(String variable) {
        if (!variables.contains(variable))
            variables.add(variable);
        return variable + " = ";
    }
    private String getScript() {
        String jsScript = "";
        if (variables.size() == 1)
            return "let " + query + ";\n";
        for (String variable : variables) {
            jsScript += "let " + variable + ";\n";
        }
        return jsScript + query;
    }
    // endregion
}
