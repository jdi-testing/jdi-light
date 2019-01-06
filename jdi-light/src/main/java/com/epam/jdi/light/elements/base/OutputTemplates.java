package com.epam.jdi.light.elements.base;

/**
 * Created by Roman_Iovlev on 4/8/2018.
 */
public class OutputTemplates {
    public static String PRINT_PAGE_STEP = "(url={url}}";
    public static String PRINT_PAGE_INFO = "{varName} (url={url}; title={title})";
    public static String PRINT_PAGE_DEBUG = "{varName} (url={url}; title={title})";

    public static String PRINT_ELEMENT_STEP = "{varName} ({context})";
    public static String PRINT_ELEMENT_INFO = "{varName} ({context})";
    public static String PRINT_ELEMENT_DEBUG = "{varName} ({context})";
    public static String PRINT_ELEMENT_ERROR = "{varName} ({context})";

    public static String SHORT_TEMPLATE = "{action}";
    public static String DEFAULT_TEMPLATE = "{action} ({element})";
}
