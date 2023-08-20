package com.epam.jdi.light.logger;

import java.util.List;

public enum Strategy {
    OFF, FAIL, ASSERT, NEW_PAGE;

    public static Strategy parseStrategy(String strategy) {
        String strategyName = strategy.toLowerCase().replace(" ", "").replace("_", "");
        switch (strategyName) {
            case "onfailure":
            case "onfail":
                return FAIL;
            case "onassert": return ASSERT;
            case "newpage": return NEW_PAGE;
            default: return OFF;
        }
    }
    public static void addStrategy(Strategy strategy, List<Strategy> list) {
        if (!list.contains(strategy))
            list.add(strategy);
    }
}
