package org.jdiai.jsbuilder;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.jdiai.jsbuilder.HttpExecutor.*;

public class RetryFunctions {
    public static JFunc2<WebDriver, String, Object> RETRY_DEFAULT = HttpExecutor::execute;
        // ((JavascriptExecutor)driver).executeScript(jsScript);
    public static JFunc2<WebDriver, String, Object> RETRY_TIMEOUT = (driver, jsScript) -> {
        Timer t = new Timer(1000);
        Object obj = null;
        while (obj == null && t.isRunning()) {
            try {
                obj = execute(driver, jsScript);
            } catch (Exception ignore) { }
        }
        return obj;
    };

    public static JFunc2<WebDriver, String, List<String>> LIST_RETRY_DEFAULT =
        (driver, jsScript) -> (List<String>) execute(driver, jsScript);
    public static JFunc2<WebDriver, String, List<String>> LIST_RETRY_TIMEOUT = (driver, jsScript) -> {
        Timer t = new Timer(1000);
        List<String> obj = null;
        while (obj == null && t.isRunning()) {
            try {
                obj = (List<String>) execute(driver, jsScript);
            } catch (Exception ignore) { }
        }
        return obj;
    };
}
