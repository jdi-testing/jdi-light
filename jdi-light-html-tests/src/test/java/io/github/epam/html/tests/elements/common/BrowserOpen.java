package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;

public class BrowserOpen implements TestsInit {

    @Test
    public void before() {
        html5Page.open();
    }

}
