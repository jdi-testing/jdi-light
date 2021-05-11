package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerPage;

public class ContainerTests extends TestsInit {
    @Test
    public void defaultContainerTest(){
        containerPage.open();
        containerPage.container.is().displayed();
        containerPage.container.is().text("Example text");
        containerPage.container.is().attr("style", "background-color: rgb(207, 232, 252); height: 100vh;");
    }
}
