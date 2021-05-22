package com.jdiai.site;

import com.jdiai.JS;
import com.jdiai.annotations.UI;
import com.jdiai.annotations.Url;
import com.jdiai.custom.LoginRegisterForm;

@Url("/")
public class HomePage {
    @UI("#user-icon") public JS userIcon;
    @UI(".search-field input") public JS searchField;
    @UI(".icon-search.active") public JS searchIcon;
    public LoginRegisterForm loginForm;
}
