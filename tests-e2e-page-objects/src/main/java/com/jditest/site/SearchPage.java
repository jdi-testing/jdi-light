package com.jditest.site;

import com.jditest.DataList;
import com.jditest.WebPage;
import com.jditest.annotations.UI;
import com.jditest.entities.SearchItem;

import java.util.List;

public class SearchPage extends WebPage {
    @UI("#search-results li")
    public List<SearchItem> searchResults;
    @UI("#search-results li")
    public DataList<SearchItem> searchData;
}
