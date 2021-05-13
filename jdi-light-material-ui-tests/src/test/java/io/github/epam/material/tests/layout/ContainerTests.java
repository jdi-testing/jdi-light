package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.containerPage;
import static io.github.com.pages.layout.ContainerPage.container;

/**
 * To see an example of Container web element please visit https://material-ui.com/components/container/
 */

public class ContainerTests extends TestsInit {
    @BeforeTest
    public void before() {
        containerPage.open();
    }

    @Test
    public void defaultContainerTest(){
        container.is().displayed();
        container.is().text("Example text");
        container.is().attr("style", "background-color: rgb(207, 232, 252); height: 100vh;");
    }
}
