package com.epam.jdi.light.asserts;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JAction;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.TIMEOUT;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface BaseSelectorAssert {
    static void waitAssert(JAction action) {
        new Timer(TIMEOUT*1000).wait(action::execute);
    }
    WebElement get();
    String selected();
    boolean selected(String value);
    List<String> values();
    List<String> checked();
    List<String> enabled();
    List<String> disabled();
}
