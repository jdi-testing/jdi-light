package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerFrame;
import static io.github.com.StaticSite.defaultContainerPage;

public class ContainerTests extends TestsInit {
    @Test
    public void defaultContainerTest(){
        defaultContainerPage.open();

        containerFrame.container.is().displayed();
        containerFrame.container.is().hasStyle("background-color: rgb(207, 232, 252)");
    }
}
