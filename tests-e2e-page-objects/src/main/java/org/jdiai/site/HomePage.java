package org.jdiai.site;

import org.jdiai.JS;
import org.jdiai.annotations.UI;
import org.jdiai.annotations.Url;

@Url("/")
public class HomePage {
    @UI("#user-icon") public JS userIcon;
    @UI(".search-field input") public JS searchField;
    @UI(".icon-search.active") public JS searchIcon;
}
