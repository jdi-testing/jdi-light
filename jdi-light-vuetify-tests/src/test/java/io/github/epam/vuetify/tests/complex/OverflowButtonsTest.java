package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.overflowButtonsPage;
import static io.github.com.pages.OverflowButtonsPage.*;

public class OverflowButtonsTest extends TestsInit {

    @BeforeClass
    public void before() {
        overflowButtonsPage.open();
    }

    @Test
    public void baseFunctionalityTest() {
        counterOverflowButton.is().placeholder("Overflow Btn w/ counter");
        counterOverflowButton.expand();
        counterOverflowButton.is().expanded();
        counterOverflowButton.close();
        counterOverflowButton.is().closed();
        counterOverflowButton.select("50%");
        counterOverflowButton.is().selected("50%");
        counterOverflowButton.select(1);
        counterOverflowButton.is().selected("100%");
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
//
//        counterOverflowButton.select(1);
//        System.out.println(counterOverflowButton.counterMessage());
//
//        counterOverflowButton.select(1);
//        System.out.println(counterOverflowButton.message());
//
//        hintOverflowButton.select(1);
//        System.out.println(hintOverflowButton.message());
//
//        Thread.sleep(2000);

//        System.out.println(counterOverflowButton.isDisabled());
//        System.out.println(disabledOverflowButton.isEnabled());

//        System.out.println(loadingOverflowButton.hasProgressBar());
//        System.out.println(counterOverflowButton.hasProgressBar());

        editableOverflowButton.hover();
        editableOverflowButton.setText("50");
        Thread.sleep(2000);
    }


}
