package org.jdiai;

import com.epam.jdi.tools.PrintUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.jdiai.GetTypes.dataType;
import static org.jdiai.WebDriverByUtils.getByLocator;

public class JSDriver {
    private final WebDriver driver;
    private final List<By> locators;
    public JSDriver(WebDriver driver, By... locators) {
        if (driver == null)
            throw new JSException("JSDriver init failed. WebDriver == null");
        if (locators == null || locators.length == 0)
            throw new JSException("JSDriver init failed. Require at least 1 locator");
        this.driver = driver;
        this.locators = asList(locators);
    }

    protected Object jsExecute(String text) { return ((JavascriptExecutor) driver).executeScript(text); }
    private String selector(By locator) {
        return getByLocator(locator).replaceAll("'", "\"");
    }

    final String getOneFromList = "[...elements].find(e=>%s != null);";
    final String getListFromList = "[...elements].flatMap(e=>[...%s])";
    private String getElement(String query) {
        return "element = " + query;
    }
    private String getElements(String query) {
        return "elements = " + query;
    }
    private String getOneFromOne(String context, By locator) {
        return format(dataType(locator).get, context, selector(locator));
    }
    private String getListFromOne(String context, By locator) {
        return format(dataType(locator).getAll, context, selector(locator));
    }
    private String getOneFromList(By locator) {
        return format(getOneFromList, format(dataType(locator).get, "e", selector(locator)));
    }
    private String getListFromList(By locator) {
        return format(getListFromList, format(dataType(locator).getAll, "e", selector(locator)));
    }

    public String getOne(String text) {
        String query = "return " + getOneFromOne("document", last(locators)) + "." + text;
        return (String) jsExecute(query);
    }

    public String getStyle(String style) {
        String query = "return getComputedStyle(" + getOneFromOne("document", last(locators)) + ")." + style;
        return (String) jsExecute(query);
    }

    public List<String> getList(String text) {
        String query = "return " + getListFromOne("document", last(locators)) + "." + text;
        return (List<String>) jsExecute(query);
    }
    private String chainQuery(List<By> locators, String context) {
        String query = context;
        for (By locator : locators) {
            query = format(dataType(locator).get, query, selector(locator));
        }
        return query;
    }
    public String getOneChain(String text) {
        if (locators.size() == 1) {
            return getOne(text);
        }
        String query = "return " + chainQuery(locators, "document") + "." + text;
        return (String) jsExecute(query);
    }

    public List<String> getListChain(String text) {
        if (locators.size() == 1) {
            return getList(text);
        }
        List<By> hyperList = listCopyUntil(locators, -1);
        By last = last(locators);
        String query = "return " + getListFromOne(chainQuery(hyperList, "document"), last) + "." + text;
        return (List<String>) jsExecute(query);
    }


    public String getOneMultiSearch(String text) {
        if (locators.size() == 1) {
            return getOne(text);
        }
        By first = first(locators);
        By last = last(locators);
        String query = "elements = " + getListFromOne("document", first)
            + print(map(listCopy(locators, 1, -1), this::getListFromList), ";")
            + "return" + getOneFromList(last) + "." + text;
        return (String) jsExecute(query);
    }
    public List<String> getListMultiSearch(String text) {
        if (locators.size() == 1) {
            return getList(text);
        }
        By first = locators.get(0);
        GetData data = dataType(first);
        String query = format(multiListQuery,
                format(data.getAll, selector(first)),
                multiSearchList(locators),
                text);
        return (List<String>) jsExecute(query);
    }

    private final String listQuery =
        "let results = [];\n"
        + "let query = document%s;\n"
        + "for (let i = 0; i < query%s; i++) {\n"
        + "  results.push(query%s.%s);\n"
        + "}"
        + "return results;";
    private final String multiSearch =
        "j = 0;"
        + "let newList = [];"
        + "while (j < elements.length) {"
        + " newList.push(...elements[j++]%s); "
        + "}";
    private final String multiListQuery =
        "let i, j;"
        + "let elements = document%s;"
        + "%s"
        + "let result = [];"
        + "for (i = 0; i < elements.length; i++) {"
        + " result.push(elements[i].%s); "
        + "}"
        + "return result";
    private String multiSearchOne(List<By> locators) {
        String query = "";
        for (int i = 0; i < locators.size(); i++) {
            By locator = locators.get(i);
            query += format(multiSearch, format(dataType(locator).getAll, selector(locator)));
            if (i < locators.size() - 1) {
                query += "elements = newList;";
            }
        }
        return query;
    }
    private String multiSearchList(List<By> locators) {
        String query = "";
        for (int i = 0; i < locators.size(); i++) {
            By locator = locators.get(i);
            query += format(multiSearch, format(dataType(locator).getAll, selector(locator)));
        }
        return query;
    }
    private String listQuery(By locator, String text) {
        GetData getData = dataType(locator);
        return listQuery(getData.getAll, locator, text);
    }
    private String listQuery(String chain, By locator, String text) {
        GetData getData = dataType(locator);
        return format(listQuery, format(chain, selector(locator)), getData.length, format(getData.index, "i"), text);
    }
    private String getListFunc(By locator) {
        GetData getData = dataType(locator);
        return format(getData.getAll, selector(locator));
    }
}
