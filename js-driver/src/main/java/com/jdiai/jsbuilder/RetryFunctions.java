package com.jdiai.jsbuilder;

import com.epam.jdi.tools.Timer;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.function.BiFunction;

import static com.jdiai.jsbuilder.HttpExecutor.execute;

public class RetryFunctions {
    public static BiFunction<Object, String, Object> DEFAULT_SCRIPT_EXECUTE =
        (driver, script) -> HttpExecutor.execute((WebDriver) driver, script);
        // ((JavascriptExecutor)driver).executeScript(jsScript);
    public static BiFunction<Object, String, Object> RETRY_TIMEOUT = (driver, jsScript) -> {
        Timer t = new Timer(1000);
        Object obj = null;
        while (obj == null && t.isRunning()) {
            try {
                obj = execute((WebDriver) driver, jsScript);
            } catch (Exception ignore) { }
        }
        return obj;
    };

    public static BiFunction<Object, String, List<Object>> DEFAULT_LIST_SCRIPT_EXECUTE =
        (driver, jsScript) -> (List<Object>) execute((WebDriver) driver, jsScript);

    public static BiFunction<Object, String, List<Object>> LIST_RETRY_TIMEOUT = (driver, jsScript) -> {
        Timer t = new Timer(1000);
        List<Object> obj = null;
        while (obj == null && t.isRunning()) {
            try {
                obj = (List<Object>) execute((WebDriver) driver, jsScript);
            } catch (Exception ignore) { }
        }
        return obj;
    };
}
