package com.epam.jdi.mobile.common;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public enum PageChecks {
    NONE(0), NEW_PAGE(1), EVERY_PAGE(2);
    int value;
    public boolean is(PageChecks check) {
        return this.value >= check.value;
    }
    public static PageChecks parse(String value) {
        switch (value) {
            case "NONE": return NONE;
            case "NEW_PAGE": return NEW_PAGE;
            case "EVERY_PAGE": return EVERY_PAGE;
            default: return NONE;
        }
    }
    PageChecks(int value) {
        this.value = value;
    }
}
