package com.epam.jdi.light.elements.base;

/**
 * Created by Roman_Iovlev on 4/8/2018.
 */
public class OutputTemplates {
    public static String PRINT_PAGE_STEP = "{name}";
    public static String PRINT_PAGE_INFO = "{name} (url={url}; title={title})";
    public static String PRINT_PAGE_DEBUG = "{name} ({varName}; url={url}; title={title})";

    public static String PRINT_ELEMENT_STEP = "{name} ({context})";
    public static String PRINT_ELEMENT_INFO = "{name} ({context})";
    public static String PRINT_ELEMENT_DEBUG = "{name} ({varName}; {context})";

    public static String SHORT_TEMPLATE = "{element} {action}";
    public static String DEFAULT_TEMPLATE = "{action} ({element})";
}
