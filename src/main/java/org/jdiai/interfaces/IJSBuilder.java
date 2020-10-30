package org.jdiai.interfaces;

import org.openqa.selenium.By;

import java.util.List;

public interface IJSBuilder {
    IJSBuilder oneToOne(String ctx, By locator);
    IJSBuilder listToOne(By locator);
    IJSBuilder oneToList(String ctx, By locator);
    IJSBuilder listToList(By locator);
    IJSBuilder getResult(String collector);
    IJSBuilder getResultList(String collector);
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
