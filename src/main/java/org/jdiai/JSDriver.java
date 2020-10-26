package org.jdiai;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static java.lang.String.format;
import static org.jdiai.GetTypes.dataType;
import static org.jdiai.JSTemplates.*;
import static org.jdiai.ListSearch.CHAIN;
import static org.jdiai.ListSearch.MULTI;
import static org.jdiai.WebDriverByUtils.getByLocator;

public class JSDriver {
    private final WebDriver driver;
    private final List<By> locators;
    public static boolean logQuery = false;
    public ListSearch strategy = CHAIN;
    public JSDriver(WebDriver driver, By... locators) {
        this(driver, newList(locators));
    }
    public JSDriver(WebDriver driver, List<By> locators) {
        if (driver == null)
            throw new JSException("JSDriver init failed: WebDriver == null");
        if (locators == null || locators.size() == 0)
            throw new JSException("JSDriver init failed: Require at least 1 locator");
        this.driver = driver;
        this.locators = copyList(locators);
    }
    public JSDriver multiSearch() {
        strategy = MULTI;
        return this;
    }

    protected Object jsExecute(String query) {
        if (logQuery)
            System.out.println(query);
        return ((JavascriptExecutor) driver).executeScript(query);
    }
    private String selector(By locator) {
        return getByLocator(locator).replaceAll("'", "\"");
    }


    private String getOneFromOne(String context, By locator) {
        return MessageFormat.format(dataType(locator).get, context, selector(locator));
    }
    private String getListFromOne(String context, By locator) {
        return MessageFormat.format(dataType(locator).getAll, context, selector(locator)) + ";\n";
    }
    private String getListFromOne(String context, By locator, String param) {
        GetData data = dataType(locator);
        return "elements = " + MessageFormat.format(data.getAll, context, selector(locator)) + ";\n"
                + format(GET_LIST, data.length, format(data.index, "i"), param);
    }
    private String getOneFromList(By locator) {
        return format(GET_ONE_FROM_LIST, MessageFormat.format(dataType(locator).get, "elements[i]", selector(locator)));
    }
    private String getListFromList(By locator, By prevLocator) {
        GetData prevData = dataType(prevLocator);
        GetData data = dataType(locator);
        return format(GET_LIST_FROM_LIST, prevData.length,
                MessageFormat.format(data.getAll, "elements[i]", selector(locator)),
                data.length, format(data.index, "j"));
    }
    private String getListFromList(By locator, By prevLocator, String param) {
        GetData prevData = dataType(prevLocator);
        GetData data = dataType(locator);
        return format(GET_LIST_FROM_LIST, prevData.length,
                MessageFormat.format(data.getAll, "elements[i]", selector(locator)),
                data.length, format(data.index, "j"))
                + format(GET_LIST, data.length, format(data.index, "i"), param);
    }
    protected String result(String query, String finalAction) {
        return query + finalAction;
    }

    public String getOne(String text) {
        if (locators.size() == 1) {
            String query = result("let element = " + getOneFromOne("document", last(locators)), "\nreturn element." + text);
            return (String) jsExecute(query);
        }
        switch (strategy) {
            case CHAIN: return getOneChain(text);
            case MULTI: return getOneMultiSearch(text);
        default: return getOneChain(text);
        }
    }

    public String getStyle(String style) {
        String query = result(getOneFromOne("document", last(locators)), "\nreturn getComputedStyle(element)." + style);
        return (String) jsExecute(query);
    }
    public List<String> getList(String text) {
        if (locators.size() == 1) {
            String query = result("let " + getListFromOne("document", last(locators), text),"\nreturn result");
            return (List<String>) jsExecute(query);
        }
        switch (strategy) {
            case CHAIN: return getListChain(text);
            case MULTI: return getListMultiSearch(text);
            default: return getListChain(text);
        }
    }
    private String chainQuery(List<By> locators, String context) {
        String query = "";
        String scope = context;
        for (By locator : locators) {
            query += "element = " + MessageFormat.format(dataType(locator).get, scope, selector(locator)) + ";\n";
            scope = "element";
        }
        return query;
    }
    public String getOneChain(String text) {
        if (locators.size() == 1) {
            return getOne(text);
        }
        String query = result(chainQuery(locators, "document"), "\nreturn element." + text);
        return (String) jsExecute(query);
    }

    public List<String> getListChain(String text) {
        if (locators.size() == 1) {
            return getList(text);
        }
        List<By> hyperList = listCopyUntil(locators, -1);
        By last = last(locators);
        String query = result("let elements; let result; let " + chainQuery(hyperList, "document")
                + getListFromOne("element", last, text), "\nreturn result;");
        return (List<String>) jsExecute(query);
    }

    public String getOneMultiSearch(String text) {
        if (locators.size() == 1) {
            return getOne(text);
        }
        By first = first(locators);
        By last = last(locators);
        String query = result("let result; let found; let element\nlet elements = " + getListFromOne("document", first)
            + iterateGetList(listCopy(locators, 1, -1), first)
            + getOneFromList(last),
     "\nreturn element." + text);
        return (String) jsExecute(query);
    }
    private String iterateGetList(List<By> locators, By prevLocator) {
        String query = "";
        By prev = prevLocator;
        for (By locator : locators) {
            query += getListFromList(locator, prev);
            prev = locator;
        }
        return query;
    }
    public List<String> getListMultiSearch(String text) {
        if (locators.size() == 1) {
            return getList(text);
        }
        By first = first(locators);
        By last = last(locators);
        String query = result("let result; let element;\nlet elements = " + getListFromOne("document", first)
            + iterateGetList(listCopy(locators, 1, -1), first)
            + getListFromList(last, listCopy(locators, -2, -2).get(0), text),
        ";\nreturn result");
        return (List<String>) jsExecute(query);
    }
}
