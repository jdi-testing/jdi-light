package com.jditest.jsbuilder;

import org.openqa.selenium.By;

public interface IBuilderActions {
    void setBuilder(IJSBuilder builder);
    String oneToOne(String ctx, By locator);
    String oneToList(String ctx, By locator);
    String listToOne(By locator);
    String listToList(By locator);
    String doAction(String collector);
    String getResult(String collector);
    String getResultList(String collector);
}
