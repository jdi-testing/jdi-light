package org.jdiai.site;

import org.jdiai.WebPage;
import org.jdiai.annotations.UI;
import org.jdiai.entities.SearchItem;

import java.util.List;

public class SearchPage extends WebPage {
    @UI("#search-results li")
    public List<SearchItem> searchResults;
}
