package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.badgesPage;
import static io.github.com.StaticSite.overflowButtonsPage;
import static io.github.com.pages.OverflowButtonsPage.*;

public class OverflowButtonsTest extends TestsInit {

    @BeforeClass
    public void before() {
        overflowButtonsPage.open();
    }

    @Test
    public void demoTest() throws InterruptedException {
        Thread.sleep(2000);
//        counterOverflowButton.expand();
//        Thread.sleep(2000);
//        counterOverflowButton.close();
//        Thread.sleep(2000);
//
//        counterOverflowButton.expand();
//        System.out.println(counterOverflowButton.dropDownList().size());
//
//        for (UIElement element : counterOverflowButton.dropDownList()) {
//            System.out.println(element.getText());
//        }

        counterOverflowButton.select(1);
        System.out.println(counterOverflowButton.getCounterMessage());

        counterOverflowButton.select(1);
        System.out.println(counterOverflowButton.getMessage());

        hintOverflowButton.select(1);
        System.out.println(hintOverflowButton.getMessage());

        Thread.sleep(2000);
    }

}
