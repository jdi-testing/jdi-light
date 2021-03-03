package org.jdiai.jsbuilder;

import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class RetryFunctions {
    public static JFunc2<JavascriptExecutor, String, Object> RETRY_DEFAULT = (js, jsScript) ->
        js.executeScript(jsScript);
    public static JFunc2<JavascriptExecutor, String, Object> RETRY_TIMEOUT = (js, jsScript) -> {
        Timer t = new Timer(1000);
        Object obj = null;
        while (obj == null && t.isRunning()) {
            try {
                obj = js.executeScript(jsScript);
            } catch (Exception ignore) { }
        }
        return obj;
    };

    public static JFunc2<JavascriptExecutor, String, List<String>> LIST_RETRY_DEFAULT =
        (js, jsScript) -> (List<String>) js.executeScript(jsScript);
    public static JFunc2<JavascriptExecutor, String, List<String>> LIST_RETRY_TIMEOUT = (js, jsScript) -> {
        Timer t = new Timer(1000);
        List<String> obj = null;
        while (obj == null && t.isRunning()) {
            try {
                obj = (List<String>) js.executeScript(jsScript);
                if (obj == null || obj.size() == 0) {
                    obj = null;
                }
            } catch (Exception ignore) { }
        }
        return obj;
    };
}
