package com.epam.jdi.light.logger;

public class AllureLogData {
    String screenPath;
    String htmlSnapshot;
    String requests;
    public AllureLogData(String screenPath, String htmlSnapshot, String requests) {
        this.screenPath = screenPath;
        this.htmlSnapshot = htmlSnapshot;
        this.requests = requests;
    }
}
