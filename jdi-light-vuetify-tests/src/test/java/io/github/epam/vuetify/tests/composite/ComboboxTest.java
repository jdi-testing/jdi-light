package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.comboboxPage;
import static io.github.com.pages.ComboboxPage.*;

public class ComboboxTest extends TestsInit {

    @BeforeClass
    public void beforeTest() {
       comboboxPage.open();
    }

    @Test
    public void demoTest1() {
        System.out.println(denseCombobox.rootLocator);
        //denseCombobox.expand();
    }
    @Test
    public void demoTest() throws InterruptedException {
        List<String> list = Arrays.asList("Design", "Vue");
        List<String> list1 = Arrays.asList("vvv", "Vue");
        List<String> list2 = Arrays.asList("Vuetify", "Programming", "Design", "Vue");


        multipleChipsCombobox.select(list2);
        System.out.println(multipleChipsCombobox.isSelected(list2));

//        multipleChipsCombobox.expand();
//        System.out.println(multipleChipsCombobox.isExpanded());
//        multipleChipsCombobox.close();
//        System.out.println(multipleChipsCombobox.isExpanded());
//        System.out.println(multipleChipsCombobox.isSelected("Vuetify"));
//        System.out.println(multipleChipsCombobox.isSelected("Programming"));
//        System.out.println(" --------------------------------------- ");
//        System.out.println(multipleChipsCombobox.isSelected("Design"));
//        multipleChipsCombobox.select("Design");
//        System.out.println(multipleChipsCombobox.isSelected("Vue"));
//        multipleChipsCombobox.select("Vue");
//        //multipleChipsCombobox.select("Vue");
//        System.out.println(multipleChipsCombobox.isSelected("Design"));
//        System.out.println(multipleChipsCombobox.isSelected("Vue"));
//        System.out.println(" --------------------------------------- ");
//        multipleChipsCombobox.unselect("Vuetify");
//        multipleChipsCombobox.unselect("Programming");
//        multipleChipsCombobox.unselect("Design");
//        multipleChipsCombobox.unselect("Vue");
//        System.out.println(multipleChipsCombobox.isSelected("Design"));
//        System.out.println(multipleChipsCombobox.isSelected("Programming"));
//        System.out.println(multipleChipsCombobox.isSelected("Design"));
//        System.out.println(multipleChipsCombobox.isSelected("Vue"));


//        Thread.sleep(2000);
    }

}
