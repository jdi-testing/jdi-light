package com.jdiai.jsbuilder.jsfunctions;

import com.jdiai.tools.DataClass;

public class BuilderFunctions extends DataClass<BuilderFunctions> {
    public String oneToOne, oneToOneFilter, oneToList, oneToListFilter, listToOne,
        listToOneFilter, listToList, listToListFilter, result, listResult, action, listAction;

    public BuilderFunctions() {
        this.oneToOne = JSOneToOne.PURE_ONE_TO_ONE;
        this.oneToOneFilter = JSOneToOne.PURE_STRICT_ONE_TO_ONE;
        this.oneToList = JSOneToList.ONE_TO_LIST;
        this.oneToListFilter = JSOneToList.FILTER_ONE_TO_LIST;
        this.listToOne = JSListToOne.PURE_LIST_TO_ONE;
        this.listToOneFilter = JSListToOne.FILTER_LIST_TO_ONE;
        this.listToList = JSListToList.ONE_LIST_TO_LIST;
        this.listToListFilter = JSListToList.FILTER_ONE_LIST_TO_LIST;
        this.result = JSResults.ONE_TO_RESULT;
        this.listResult = JSResults.LIST_TO_RESULT;
        this.action = JSResults.ONE_TO_ACTION;
        this.listAction = JSResults.LIST_TO_ACTION;
    }
}
