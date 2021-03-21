package org.jdiai.interfaces;

import org.jdiai.JS;
import org.openqa.selenium.By;

import java.util.List;

public interface HasCore extends HasLocators {
    JS core();
    void setCore(JS core);
    default List<By> locators() { return core().locators(); }
}
