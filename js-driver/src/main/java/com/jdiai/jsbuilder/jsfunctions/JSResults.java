package com.jdiai.jsbuilder.jsfunctions;

public class JSResults {
    public static String ONE_TO_RESULT = "return %s";

    public static String ONE_TO_ACTION = "%s";

    public static String LIST_TO_ACTION = "elements.forEach(element => %s)";

    public static String LIST_TO_RESULT = "return elements.map(element => %s);";

    public static String PURE_CONDITION =
        "conditionResult = false;\n" +
        "if (!condition(element)) { throw 'Element found but does not meet condition %s'; }\n";

    public static String CONDITION =
        "conditionResult = false;\n" +
        "try { conditionResult = condition(element); } catch(ex) { }\n" +
        "if (!conditionResult) { throw 'Element found but does not meet condition %s'; }\n";

    public static String PURE_CONDITION_LIST_TO_RESULT =
        "return elements.filter(condition).map(element => %s);";

    public static String AGILE_LIST_TO_RESULT =
        "filtered = []\n" +
        "try { filtered = elements.filter(condition); } catch { }\n" +
        "if (filtered.length == 0) { filtered = elements; }\n" +
        "return filtered.filter(condition).map(element => %s);";

    public static String PURE_CONDITION_LIST_TO_ACTION =
        "elements.filter(condition).forEach(element => %s);";

    public static String AGILE_LIST_TO_ACTION =
        "filtered = []\n" +
        "try { filtered = elements.filter(condition); } catch { }\n" +
        "if (filtered.length == 0) { filtered = elements; }\n" +
        "filtered.filter(condition).forEach(element => %s);";
}
