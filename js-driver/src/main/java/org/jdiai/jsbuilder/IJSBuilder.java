package org.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.util.List;

public interface IJSBuilder {
    IJSBuilder addJSCode(String code);
    IJSBuilder addContextCode(String code) ;

    IJSBuilder oneToOne(String ctx, By locator);
    IJSBuilder listToOne(By locator);
    IJSBuilder oneToList(String ctx, By locator);
    IJSBuilder listToList(By locator);

    IJSBuilder doAction(String collectResult);
    IJSBuilder getResult(String collectResult);
    IJSBuilder getResultList(String collectResult);

    IJSBuilder trigger(String event);
    IJSBuilder trigger(String event, String options);
    Object executeQuery();
    List<String> executeAsList();
    IJSBuilder registerFunction(String name, String function);
    void registerVariables(String... vars);
    String registerVariable(String variable);
    String rawQuery();
    String getQuery();
    IJSBuilder setTemplate(String replaceTo);
    IJSBuilder logQuery(int queryLevel);
    void cleanup();
    void updateFromBuilder(IJSBuilder builder);
    IJSBuilder copy();
    IJSBuilder updateActions(IBuilderActions builderActions);
    IJSBuilder setElementName(String elementName);
    String getElementName();
}
