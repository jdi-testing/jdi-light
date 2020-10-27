package org.jdiai;

import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
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
    private final List<String> variables = new ArrayList<>();
    private String query = "";
    private JavascriptExecutor js;
    public boolean logQuery = false;
    public static JAction1<String> logger = System.out::println;

    public JSBuilder(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    public JSBuilder logQuery() {
        this.logQuery = true;
        return this;
    }
    public String executeQuery(String getResult) {
        String jsScript = getScript() + "return " + getResult;
        if (logQuery)
            logger.execute("Execute query:" + LINE_BREAK + jsScript);
        String result = (String) js.executeScript(jsScript);
        if (result != null && logQuery)
            logger.execute(">>> " + result);
        return result;
    }
    public List<String> executeAsList(String getResult) {
        String jsScript = getScript() + "return " + getResult;
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

    private String selector(By locator) {
        return getByLocator(locator).replaceAll("'", "\"");
    }

    public JFunc2<String, By, String> oneToOne = (ctx, locator) ->
        format(ONE_TO_ONE, MessageFormat.format(dataType(locator).get, ctx, selector(locator)));
    public JSBuilder getOneToOne(String ctx, By locator) {
        query += register("element") + oneToOne.execute(ctx, locator);
        return this;
    }
    public JFunc1<By, String> listToOne = locator ->
        format(LIST_TO_ONE, MessageFormat.format(dataType(locator).get, "elements[i]", selector(locator)));

    public JSBuilder getListToOne(By locator) {
        query += listToOne.execute(locator);
        return this;
    }
    public JFunc2<String, By, String> oneToList = (ctx, locator) ->
            format(ONE_TO_LIST, MessageFormat.format(dataType(locator).getAll, ctx, selector(locator)));
    public JSBuilder getOneToList(String ctx, By locator) {
        query += register("elements") + oneToList.execute(ctx, locator);
        return this;
    }

    public JFunc1<By, String> listToList = (locator) -> {
        GetData data = dataType(locator);
        return format(LIST_TO_LIST,
            MessageFormat.format(data.getAll, "element", selector(locator)),
            data.length, format(data.index, "j"));
    };
    public JSBuilder getListToList(By locator) {
        query += listToList.execute(locator);
        return this;
    }

    public JSBuilder collect(By locator, String collector) {
        GetData data = dataType(locator);
        query += format(LIST_TO_RESULT, data.length, collector.replaceAll("element", "elements" + format(data.index, "i")));
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
            return "let " + query;
        for (String variable : variables) {
            jsScript += "let " + variable + ";\n";
        }
        return jsScript + query;
    }
    // endregion
}
