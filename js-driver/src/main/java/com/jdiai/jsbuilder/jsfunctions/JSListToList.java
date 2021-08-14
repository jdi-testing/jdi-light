package com.jdiai.jsbuilder.jsfunctions;

public class JSListToList {
    public static String LIST_TO_LIST =
        "list = [];\n" +
        "for(let element of elements) {\n" +
        "  subElements = Array.from({{list}}).filter(e=>!!e);\n" +
        "  if (subElements.length === 0) { continue; }\n" +
        "  for(let j = 0; j < subElements.length; j++) {\n" +
        "    list.push(subElements[j]);\n" +
        "  }\n" +
        "}\n" +
        "elements = Array.from(list);\n";

    public static String FILTER_LIST_TO_LIST =
        "list = [];\n" +
        "for(let element of elements) {\n" +
        "  subElements = Array.from({{list}}).filter(e=>!!e).filter(filter);\n" +
        "  if (subElements.length === 0) { continue; }\n" +
        "  for(let j = 0; j < subElements.length; j++) {\n" +
        "    list.push(subElements[j]);\n" +
        "  }\n" +
        "}\n" +
        "elements = Array.from(list);\n";

    public static String ONE_LIST_TO_LIST =
        "elements = Array.from(elements.map(e=>{{one:e}})).filter(e=>!!e);\n";

    public static String FILTER_ONE_LIST_TO_LIST =
        "try { elements = Array.from(elements.map(e=>{{one:e}})).filter(e=>!!e).filter(filter); }\n" +
        "catch { throw 'Failed to find element' }";

    public static String AGILE_LIST_TO_LIST =
        "list = [];\n" +
        "for(let element of elements) {\n" +
        "  subElements = Array.from({{list}}).filter(e=>!!e);" +
        "  if (subElements.length === 0) { continue; }\n" +
        "  filtered = subElements.filter(filter);\n" +
        "  if (filtered.length === 0 && subElements.length > 0) { filtered = subElements; }\n" +
        "  for(let j = 0; j < filtered.length; j++) {\n" +
        "    list.push(filtered[j]);\n" +
        "  }\n" +
        "}\n" +
        "elements = Array.from(list);\n";

    public static String AGILE_ONE_LIST_TO_LIST =
        "list = [];\nnoFilterList = [];\n" +
        "for(let element of elements) {\n" +
        "  subElement = {{one}};\n" +
        "  if (subElement) { noFilterList.push(subElement); }\n" +
        "  if (filter(subElement)) { list.push(subElement); }\n" +
        "}\n" +
        "elements = Array.from(list.length > 0 ? list : noFilterList);\n";
}
