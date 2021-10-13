package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewDropDown;
import io.github.com.pages.TreeviewPage;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.activatableTreeView;

public class TreeViewDropDownTests extends TestsInit {

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    @Test
    public void baseTest() {
        activatableTreeView
                .is().customAssertForVisualCheckThatAssertWork()
                .is().expandedAll();
//        System.out.println(TreeviewPage.activatableTreeView.is().element());
//        TreeViewDropDown treeViewDropDown = (TreeViewDropDown) TreeviewPage.activatableTreeView.is().element();
//        treeViewDropDown.list().foreach(UIElement::highlight);
    }

    @Test
    public void normalTest() {
        System.out.println(activatableTreeView.getStartIndex());
        activatableTreeView.list().has().size(4);
//        activatableTreeView.foreach(treeViewDropDown -> {
//            treeViewDropDown.expand();
//            treeViewDropDown.root().click();
//            Assert.assertTrue(treeViewDropDown.isActive());
//        });
        activatableTreeView.selected(2);
        activatableTreeView.selected("1");
        activatableTreeView.list().foreach(uiElement -> {
            System.out.println(uiElement.getText());
            uiElement.highlight();
        });
    }

}
