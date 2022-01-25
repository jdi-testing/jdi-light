package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum CheckTypes {
    DEFAULT, NONE, EQUALS, MATCH, CONTAINS;

    public static CheckTypes parseUrlCheck(String value) {
        String check = value.trim().toLowerCase().replaceAll("[^a-z]", "");
        switch (check) {
            case "none": return NONE;
            case "equals": return EQUALS;
            case "match": return MATCH;
            case "contains": return CONTAINS;
            default: return CONTAINS;
        }
    }

    public static CheckTypes parseTitleCheck(String value) {
        String check = value.trim().toLowerCase().replaceAll("[^a-z]", "");
        switch (check) {
            case "none": return NONE;
            case "equals": return EQUALS;
            case "match": return MATCH;
            case "contains": return CONTAINS;
            default: return NONE;
        }
    }
}
