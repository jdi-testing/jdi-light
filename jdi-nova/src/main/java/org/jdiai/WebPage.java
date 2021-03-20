package org.jdiai;

import org.jdiai.interfaces.HasName;

import static org.jdiai.JSTalk.openPage;
import static org.jdiai.page.objects.PageFactory.initElements;
import static org.jdiai.page.objects.PageFactory.initPageElements;

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
