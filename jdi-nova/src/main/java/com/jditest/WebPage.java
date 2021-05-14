package com.jditest;

import com.jditest.interfaces.HasName;

import static com.epam.jdi.tools.JsonUtils.getDouble;
import static com.jditest.JDI.*;
import static com.jditest.page.objects.PageFactory.initPageElements;

public class WebPage implements HasName {
    private String url;
    private String title;
    private String name;

    public WebPage() {
        initPageElements(this);
    }
    public void open() {
        openPage(url);
    }
    public WebPage setup(String url, String title) {
        this.url = url;
        this.title = title;
        return this;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
