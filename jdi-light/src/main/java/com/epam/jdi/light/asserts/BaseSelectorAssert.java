package com.epam.jdi.light.asserts;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface BaseSelectorAssert {
    WebElement get();
    String selected();
    boolean selected(String value);
    List<String> values();
    List<String> checked();
    List<String> enabled();
    List<String> disabled();
}
