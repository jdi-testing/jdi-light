package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerPage;
import static io.github.com.pages.layout.ContainerPage.container;

/**
 * To see an example of Container web element please visit
 * https://material-ui.com/components/container/
 */

public class ContainerTests extends TestsInit {
    @BeforeMethod
    public void before() {
        containerPage.open();
        containerPage.checkOpened();
    }

    @Test
    public void fluidContainerTest() {
        container.has().maxWidth(600);
        container.is().fluid();
    }

    @Test
    public void fluidContainerValidationTest() {
        container.is().displayed();
        container.is().enabled();
    }
}
