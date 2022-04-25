package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerPage;
import static io.github.com.pages.layout.ContainerPage.container;

public class ContainerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        containerPage.open();
        containerPage.checkOpened();
    }

    @Test
    public void fluidContainerTest() {
        container.is().displayed().and().enabled().and().fluid()
                 .and().has().maxWidth(600);
    }
}
