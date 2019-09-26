package com.epam.jdi.light.elements.base;


/**
 * Created by Roman Iovlev on 04.08.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class OutputTemplates {
    public static String PRINT_PAGE_STEP = "(url={url}; title={title})";
    public static String PRINT_PAGE_INFO = "{varName} (url={url}; title={title})";
    public static String PRINT_PAGE_DEBUG = "{varName} (url={url}; title={title})";

    public static String PRINT_ELEMENT_STEP = "{varName} ({context})";
    public static String PRINT_ELEMENT_INFO = "{varName} ({context})";
    public static String PRINT_ELEMENT_DEBUG = "{varName} ({context})";
    public static String PRINT_ERROR_STEP = "{varName} ({context})";
    public static String PRINT_ERROR_INFO = "{name}";
    public static String PRINT_ERROR_DEBUG = "{name}";

    public static String STEP_TEMPLATE = "{action}";
    public static String DEFAULT_TEMPLATE = "{action} ({element})";
    public static String FAILED_ACTION_TEMPLATE =
        "Failed to execute '{action}' for element '{failElement}' during '{timeout}' seconds. {exception}";
}
