package com.jdiai.jsbuilder;

import org.openqa.selenium.By;

import java.util.function.Supplier;

public interface IBuilderActions {
    void setBuilder(Supplier<IJSBuilder> builder);
    String oneToOne(String ctx, By locator);
    String oneToOneFilter(String ctx, By locator, String filterName);
    String oneToList(String ctx, By locator);
    String oneToListFilter(String ctx, By locator, String filterName);
    String listToOne(By locator);
    String listToOneFilter(By locator, String filterName);
    String listToList(By locator);
    String listToListFilter(By locator, String filterName);
    String doAction(String collector);
    String doListAction(String collector);
    String preResult(String collector);
    String getResult(String collector);
    String getResultList(String collector);
}
