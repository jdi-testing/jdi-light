package com.epam.jdi.light.logger;

import java.util.List;

public enum HighlightStrategy {
    OFF, FAIL, ASSERT, ACTION;

    public static HighlightStrategy parseStrategy(String strategy) {
        String strategyName = strategy.toLowerCase().replace(" ", "").replace("_", "");
        switch (strategyName) {
            case "onfailure":
            case "onfail":
                return FAIL;
            case "onassert": return ASSERT;
            case "onaction": return ACTION;
            default: return OFF;
        }
    }
    public static void addStrategy(HighlightStrategy strategy, List<HighlightStrategy> list) {
        if (!list.contains(strategy))
            list.add(strategy);
    }
}
