package com.jdiai;

import com.jdiai.interfaces.HasName;
import com.jdiai.interfaces.ISetup;

import java.lang.reflect.Field;

import static com.jdiai.JDI.$;
import static com.jdiai.JDI.openPage;
import static com.jdiai.page.objects.PageFactory.initPageElements;
import static com.jdiai.page.objects.PageFactoryUtils.getPageTitle;
import static com.jdiai.page.objects.PageFactoryUtils.getPageUrl;

public class WebPage implements HasName<WebPage>, ISetup {
    private String url;
    private String title;
    private String name;

    public WebPage() {
        initPageElements(this);
    }
    public void open() {
        openPage(url);
    }

    public void setup(Field field) {
        Class<?> fieldClass = field.getType();
        this.url = getPageUrl(fieldClass, field);
        this.title = getPageTitle(fieldClass, field);
    }

    public String getName() {
        return name;
    }

    public WebPage setName(String name) {
        this.name = name;
        return this;
    }

    public void makeScreenshot() {
        $("document")
            .setName(getName())
            .makeScreenshot(getName());
    }
}
