package org.jdiai;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.last;
import static com.epam.jdi.tools.LinqUtils.listCopyUntil;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.jdiai.GetTypes.getDataType;
import static org.jdiai.WebDriverByUtils.getByLocator;

public class JSDriver {
    private final WebDriver driver;
    private final List<By> locators;
    public JSDriver(WebDriver driver, By... locators) {
        this.driver = driver;
        this.locators = asList(locators);
    }

    protected Object jsExecute(String text) { return ((JavascriptExecutor) driver).executeScript(text); }

    private final String listQuery =
        "let results = [];\n"
        + "let query = document%s;\n"
        + "for (let i = 0; i < query.%s; i++) {\n"
        + "  results.push(query%s.%s);\n"
        + "}"
        + "return results;";
    private final String multiSearch =
        "j = 0;"
        + "var newList = [];"
        + "while (j < results.length) {"
        + "  newList.push(...results[j++].%s;"
        + "}"
        + "result = newList;";
    private final String multiListQuery =
        "let i, j;"
        + "let elements = [];"
        + "var first = document.querySelectorAll(locators[0]);"
        + "for (i = 0; i < first.length; i++) {"
        + "  elements.push(first[i]);"
        + "}"
        + "%s"
        + "let result = [];"
        + "for (i = 0; i < elements.length; i++) {"
        + "  result.push(elements[i].%s);"
        + "}"
        + "return result";

    private String multiSearch(List<By> locators) {
        String query = "";
        for (int i = 0; i < locators.size(); i++) {
            By locator = locators.get(i);
            query += format(multiSearch, format(getDataType(locator).getAll, getByLocator(locator)));
        }
        return query;
    }
    private String listQuery(By locator, String text) {
        GetData getData = getDataType(locator);
        return listQuery(getData.getAll, locator, text);
    }
    private String listQuery(String chain, By locator, String text) {
        GetData getData = getDataType(locator);
        return format(listQuery, chain, getData.length, getData.index, text);
    }
    private String getFunc(By locator) {
        GetData getData = getDataType(locator);
        return format(getData.get, getByLocator(locator));
    }
    private String getListFunc(By locator) {
        GetData getData = getDataType(locator);
        return format(getData.getAll, getByLocator(locator));
    }
    public String getOne(String text) {
        return (String) jsExecute("return document" + getFunc(locators.get(0)) + "." + text);
    }
    public List<String> getList(String text) {
        return (List<String>) jsExecute(listQuery(locators.get(0), text));
    }
    private String chainQuery(List<By> locators) {
        String query = "";
        for (By locator : locators) {
            query += getFunc(locator);
        }
        return query;
    }
    public String getFirstChain(String text) {
        return (String) jsExecute("return document" + chainQuery(locators) + "." + text);
    }
    public List<String> getListChain(String text) {
        List<By> hyperList = listCopyUntil(locators, -1);
        By last = last(locators);
        String chain = chainQuery(hyperList) + "." + last;
        return (List<String>) jsExecute(listQuery(chain, last, text));
    }
    public List<String> getFirstMultiple(String text) {
        By first = locators.get(0);
        GetData data = getDataType(first);
        String query = format(multiListQuery,
            format(data.getAll, getByLocator(first)),
            data.length,
            format(data.index, "i"),
            locators.size(),
            multiSearch(listCopyUntil(locators, -1)),
            text);
        return (List<String>) jsExecute(query);
    }
}
