package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.selectsPage;
import static io.github.com.pages.SelectsPage.*;

public class SelectTests extends TestsInit {

    @BeforeClass
    public void before() {
        selectsPage.open();
    }

    @Test
    public void demoTest() throws InterruptedException {

//        outlinedStyleSelect.select("Bar");
//        outlinedStyleSelect.label().getValue();

        standardDenseSelect.is().collapsed();
        standardDenseSelect.expand();
        standardDenseSelect.is().expanded();
//        standardDenseSelect.close();
//        standardDenseSelect.is().collapsed();
        standardDenseSelect.select("Bar");
        standardDenseSelect.is().selected("Bar");
        standardDenseSelect.is().displayed();
    }
//
//    @Test
//    public void leftTest() throws InterruptedException {
//
////        leftIconSelect.is().collapsed();
////        leftIconSelect.expand();
////        leftIconSelect.is().expanded();
//        //standardDenseSelect.close();
//        //standardDenseSelect.is().collapsed();
//        leftIconSelect.select("Georgia");
//        leftIconSelect.is().selected("Georgia");
//        leftIconSelect.is().displayed();
//    }

    @Test
    public void labelTest() throws InterruptedException {
        menuPropsSelect.labelText();
        //System.out.println(menuPropsSelect.base().locator.toString());
    }

    @Test
    public void multiTest() {
        multipleSelect.select(1);
        multipleSelect.messageText();
    }

}
