package org.jdiai.interfaces;

import org.openqa.selenium.By;

public interface IBuilderActions {
    String oneToOne(String ctx, By locator);
    String oneToList(String ctx, By locator);
    String listToOne(By locator);
    String listToList(By locator);
    String getResult(String collector);
    String getResultList(String collector);
}
