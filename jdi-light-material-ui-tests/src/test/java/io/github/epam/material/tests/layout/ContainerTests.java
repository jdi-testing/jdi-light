package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerPage;
import static io.github.com.pages.layout.ContainerPage.containerFixed;
import static io.github.com.pages.layout.ContainerPage.containerFluid;

public class ContainerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        containerPage.open();
        containerPage.checkOpened();
    }
    // @todo #5297 maxWidth should be read from the class like MuiContainer-maxWidthLg, values in pixes are not guaranteed 
    @Test
    public void fluidContainerTest() {
        containerFluid.show();
        containerFluid.is().displayed()
                      .and().is().fluid();
    }

    @Test
    public void fixedContainerTest() {
        containerFixed.show();
        containerFixed.is().displayed()
                      .and().is().fixed();
    }
}
