package com.epam.jdi.light.common;

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

    public static PageChecks parsePageCheck(String value) {
        String check = value.trim().toLowerCase().replaceAll("[^a-z]", "");
        switch (check) {
            case "none": return NONE;
            case "newpage": return NEW_PAGE;
            case "everypage": return EVERY_PAGE;
            default: return NONE;
        }
    }
    PageChecks(int value) {
        this.value = value;
    }
}
