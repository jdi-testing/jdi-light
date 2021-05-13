package io.github.epam.material.tests.layout;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.layout.ContainerPage.*;

/**
 * To see an example of Container web element please visit https://material-ui.com/components/container/
 */

public class ContainerTests extends TestsInit {
    @BeforeTest
    public void before() {
        openSection("Container");
    }

    @Test
    public void defaultContainerTest(){
        Timer timer = new Timer(1000L);
        timer.wait(() -> container.isDisplayed());
        container.is().text("Example text");
        container.is().attr("style", "background-color: rgb(207, 232, 252); height: 100vh;");
    }
}
