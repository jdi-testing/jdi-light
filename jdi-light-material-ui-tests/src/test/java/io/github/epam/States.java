package io.github.epam;

import com.epam.jdi.light.elements.composite.WebPage;
import static io.github.com.StaticSite.defaultGridPage;

public class States {
    public static void shouldBeLoggedIn() {
        String url = WebPage.getUrl();
        if (!url.contains("http://localhost:8080/?path=/story")) {
            defaultGridPage.open();
        }
    }

}
