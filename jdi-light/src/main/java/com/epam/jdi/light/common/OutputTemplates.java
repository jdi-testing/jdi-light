package com.epam.jdi.light.common;

/**
 * Created by Roman_Iovlev on 4/8/2018.
 */
public class OutputTemplates {
    public static String PRINT_PAGE_STEP = "{name}";
    public static String PRINT_PAGE_INFO = "{name} (url={url}; title={title})";
    public static String PRINT_PAGE_DEBUG = "{name} ({varName}; url={url}; title={title})";

    public static String PRINT_ELEMENT_STEP = "{name}";
    public static String PRINT_ELEMENT_INFO = "{name} ({context})";
    public static String PRINT_ELEMENT_DEBUG = "{name} ({varName}; {context})";
}
