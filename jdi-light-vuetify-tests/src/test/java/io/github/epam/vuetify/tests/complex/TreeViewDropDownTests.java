package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Lists;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewDropDown;
import io.github.com.pages.TreeviewPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.activatableTreeView;
import static java.util.Arrays.asList;

public class TreeViewDropDownTests extends TestsInit {

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    Map<String, Map<String>> data = new LinkedHashMap<>();

    @BeforeClass
    public void initData() {
        data.put(null, asList("Applications :" , "Documents :", "Downloads :", "Videos :"));
        data.put("Applications :", asList("Calendar : app" , "Chrome : app", "Webstorm : app"));
        data.put("Documents :", asList("vuetify :", "material2 :"));
        data.put("vuetify :", asList("src :"));
        data.put("src :", asList("index : ts", "bootstrap : ts"));
        data.put("material2 :", asList("src :"));
        data.put("src :", asList("v-btn : ts", "v-card : ts", "v-window : ts"));
    }

    protected void checkTreeViewDefaultTextAndStructure(TreeView treeView) {

        treeView.is().pseudo();
        treeView.has().values(equalTo(asList(
                "Applications :" , "Documents :", "Downloads :", "Videos :"
        )));

        TreeView applications = treeView.getNode("Applications :");
        applications.has().values(equalTo(asList(
                "Calendar : app" , "Chrome : app", "Webstorm : app"
        )));
        applications.nodes().forEach(node -> node.is().leaf());

        TreeView documents = treeView.getNode("Documents :");
        documents.has().values(equalTo(asList(
                "vuetify :", "material2 :"
        )));
        TreeView vuetify = documents.getNode("vuetify :");
        vuetify.has().values(equalTo(asList("src :")));
        TreeView vuetifySource = vuetify.getNode("src :");
        vuetifySource.has().values(equalTo(asList(
                "index : ts", "bootstrap : ts"
        )));
        vuetifySource.nodes().forEach(node -> node.is().leaf());
        TreeView material = documents.getNode("material2 :");
        material.has().values(equalTo(asList("src :")));
        TreeView materialSource = material.getNode("src :");
        materialSource.has().values(equalTo(asList(
                "v-btn : ts", "v-card : ts", "v-window : ts"
        )));

        TreeView downloads = treeView.getNode("Downloads :");
        downloads.has().values(equalTo(asList(
                "October : pdf", "November : pdf", "Tutorial : html"
        )));
        downloads.nodes().forEach(node -> node.is().leaf());

        TreeView videos = treeView.getNode("Videos :");
        videos.has().values(equalTo(asList(
                "Tutorials :", "Intro : mov", "Conference introduction : avi"
        )));
        videos.getNode("Intro : mov").is().leaf();
        videos.getNode("Conference introduction : avi").is().leaf();
        TreeView tutorials = videos.getNode("Tutorials :");
        tutorials.has().values(equalTo(asList(
                "Basic layouts : mp4", "Advanced techniques : mp4", "All about app : dir"
        )));
        tutorials.nodes().forEach(node -> node.is().leaf());
    }

    @Test
    public void normalTest() throws InterruptedException {
        t.collect(Collectors.toList()).forEach(System.out::println);
//        System.out.println(activatableTreeView.getStartIndex());
//        System.out.println(activatableTreeView.nodes().size());
//        System.out.println(activatableTreeView.list().size());
////        activatableTreeView.foreach(treeViewDropDown -> {
////            treeViewDropDown.expand();
////            treeViewDropDown.root().click();
////            Assert.assertTrue(treeViewDropDown.isActive());
////        });
//        activatableTreeView.select(3);
//        System.out.println(activatableTreeView.selected(2));
//        System.out.println(activatableTreeView.selected("1"));
//        Thread.sleep(5000);
//        activatableTreeView.list().foreach(uiElement -> {
//            System.out.println(uiElement.getText());
//            uiElement.highlight();
//        });
    }

}
