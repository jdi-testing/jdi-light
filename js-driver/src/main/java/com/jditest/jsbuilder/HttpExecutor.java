package com.jditest.jsbuilder;

import com.google.common.collect.ImmutableMap;
import com.jditest.jsdriver.JSException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;

import java.io.IOException;

import static org.openqa.selenium.remote.DriverCommand.EXECUTE_SCRIPT;
import static org.openqa.selenium.remote.ErrorCodes.JAVASCRIPT_ERROR;
import static org.openqa.selenium.remote.ErrorCodes.SUCCESS;

public class HttpExecutor {

    static final String FAILED_TO_EXECUTE_SCRIPT = "Failed to execute script:\n";
    public static Object execute(WebDriver driver, String script) {
        if (!(driver instanceof RemoteWebDriver)) {
            throw new JSException("Failed to execute jsScript: Selenium execute script work only with RemoteWebDriver");
        }
        return execute((RemoteWebDriver) driver, script);
    }
    public static Object execute(RemoteWebDriver driver, String script) {
        Command command = new Command(driver.getSessionId(), EXECUTE_SCRIPT,
            ImmutableMap.of("script", script, "args", new Object[]{}));
        Response response;
        try {
            response = driver.getCommandExecutor().execute(command);
        } catch (IOException ex) {
            throw new JSException(ex, FAILED_TO_EXECUTE_SCRIPT + script);
        }
        if (response == null || response.getStatus() == null) {
            throw new JSException(FAILED_TO_EXECUTE_SCRIPT + script);
        }
        if (response.getStatus() == SUCCESS) {
            return response.getValue();
        }
        if (response.getStatus() != JAVASCRIPT_ERROR || !(response.getValue() instanceof JavascriptException)) {
            throw new JSException(FAILED_TO_EXECUTE_SCRIPT + script);
        }
        JavascriptException jsException = (JavascriptException) response.getValue();
        throw new JSException(jsException, FAILED_TO_EXECUTE_SCRIPT + script);
    }
}
