package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.util.function.Supplier;

public interface IBuilderActions {
    void setBuilder(Supplier<IJSBuilder> builder);
    String oneToOne(String ctx, By locator);
    String oneToList(String ctx, By locator);
    String listToOne(By locator);
    String listToList(By locator);
    String doAction(String collector);
    String doListAction(String collector);
    String getResult(String collector);
    String getResultList(String collector);
    String conditionTemplate();
    String conditionFunc(String func);
}
