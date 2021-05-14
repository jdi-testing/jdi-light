package com.jdiai.interfaces;

import com.jdiai.JS;
import org.openqa.selenium.By;

import java.util.List;

public interface HasCore extends HasLocators {
    JS core();
    void setCore(JS core);
    default List<By> locators() { return core().locators(); }
}
