package com.epam.jdi.light.asserts;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JAction;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

/**
 * Created by Roman Iovlev on 02.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface BaseSelectorAssert {
    static void waitAssert(JAction action, String name) {
        try {
            action.execute();
        } catch (Throwable ignore) {
            try {
                logger.logOff(() ->
                    new Timer(TIMEOUT.get() * 1000).wait(action::execute)
                );
            } catch (Throwable ex) {
                throw exception("Failed for " + name +
                    LINE_BREAK + ex.getMessage());
            }
        }
    }
    WebElement get();
    String selected();
    boolean selected(String value);
    List<String> values();
    List<String> checked();
    List<String> listEnabled();
    List<String> listDisabled();
}
