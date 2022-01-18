package com.jdiai.custom;

import com.jdiai.CoreElement;
import com.jdiai.DataList;
import com.jdiai.annotations.UI;

public class GenericList<T> extends CoreElement {
    @UI("#search-results li")
    public DataList<T> searchData;

}
