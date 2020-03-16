package com.epam.jdi.light.logger;

import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;

public class LogStrategy {
    public static List<Strategy> SCREEN_STRATEGY = new ArrayList<>();
    public static List<Strategy> HTML_CODE_STRATEGY = new ArrayList<>();
    public static List<Strategy> REQUESTS_STRATEGY = new ArrayList<>();
    public static JFunc1<LogEntry, Boolean> FILTER_REQUESTS =
        l -> l.getMessage().contains("\"status\":\"4") || l.getMessage().contains("\"status\":\"5");
}
