package com.epam.jdi.light.settings;

import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.logger.Strategy;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.*;

public class LogSettings {
    public LogLevels logLevel = INFO;
    public boolean writeToAllure = true;
    public boolean writeToLog = true;
    public List<Strategy> screenStrategy = new ArrayList<>();
    public List<Strategy> htmlCodeStrategy = new ArrayList<>();
    public List<Strategy> requestsStrategy = new ArrayList<>();
    public JFunc1<LogEntry, Boolean> filterHttpRequests =
        l -> l.getMessage().contains("\"status\":\"4") || l.getMessage().contains("\"status\":\"5");
}
