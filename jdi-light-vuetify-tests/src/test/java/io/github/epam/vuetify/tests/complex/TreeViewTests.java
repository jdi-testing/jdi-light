package io.github.epam.vuetify.tests.complex;

import io.github.com.pages.TreeviewPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.activatableTreeView;

public class TreeViewTests extends TestsInit {

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    @Test
    public void baseTest() {
//        activatableTreeView.nodes().foreach(elem -> System.out.println(elem.find(".v-treeview-node__content").getText()));
    }
}
