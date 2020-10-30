package org.jdiai;

import org.openqa.selenium.By;

import java.util.List;

public interface IJSBuilder {
    IJSBuilder getOneToOne(String ctx, By locator);
    IJSBuilder getListToOne(By locator);
    IJSBuilder getOneToList(String ctx, By locator);
    IJSBuilder getListToList(By locator);
    String executeQuery();
    List<String> executeAsList();
    String selector(By locator);
    String selectorAll(By locator);
    IJSBuilder registerFunction(String name, String function);
    void registerVariables(String... vars);
    String registerVariable(String variable);
    String getQuery(String result);
    IJSBuilder logQuery();
}
