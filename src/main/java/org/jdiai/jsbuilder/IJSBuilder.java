package org.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.util.List;

public interface IJSBuilder {
    IJSBuilder addJSCode(String code);

    IJSBuilder oneToOne(String ctx, By locator);
    IJSBuilder listToOne(By locator);
    IJSBuilder oneToList(String ctx, By locator);
    IJSBuilder listToList(By locator);
    IJSBuilder getResult(String collector);
    IJSBuilder getResultList(String collector);
    IJSBuilder trigger(String event);
    IJSBuilder trigger(String event, String options);
    Object executeQuery();
    List<String> executeAsList();
    IJSBuilder registerFunction(String name, String function);
    void registerVariables(String... vars);
    String registerVariable(String variable);
    String getQuery();
    IJSBuilder setTemplate(String replaceTo);
    IJSBuilder logQuery();
}
