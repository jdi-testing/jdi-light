package org.jdiai.jsbuilder;

import com.epam.jdi.tools.func.JAction1;

public class QueryLogger {
    public static final int OFF = 0;
    public static final int RESULT = 1;
    public static final int ALL = 2;
    public static int LOG_QUERY = OFF;
    public static JAction1<String> logger = System.out::println;

}
