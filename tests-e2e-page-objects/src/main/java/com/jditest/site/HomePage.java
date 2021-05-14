package com.jditest.site;

import com.jditest.JS;
import com.jditest.annotations.UI;
import com.jditest.annotations.Url;

@Url("/")
public class HomePage {
    @UI("#user-icon") public JS userIcon;
    @UI(".search-field input") public JS searchField;
    @UI(".icon-search.active") public JS searchIcon;
}
