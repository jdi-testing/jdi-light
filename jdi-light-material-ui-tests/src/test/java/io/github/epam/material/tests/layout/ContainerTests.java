package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerPage;
import static io.github.com.pages.layout.ContainerPage.containerFixed;
import static io.github.com.pages.layout.ContainerPage.containerFluid;

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
        containerFluid.show();
        containerFluid.is().displayed()
                .and().maxWidth(600)
                .and().is().fluid();
    }

    @Test
    public void fixedContainerTest() {
        containerFixed.show();
        containerFixed.is().displayed()
                .and().maxWidth(1280)
                .and().is().fixed();
    }

}
