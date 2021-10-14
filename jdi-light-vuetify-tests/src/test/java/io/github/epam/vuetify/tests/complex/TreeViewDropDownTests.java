package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.*;
import static java.util.Arrays.asList;

public class TreeViewDropDownTests extends TestsInit {

    protected String CHECKBOX_FULLY_MARKED_CLASS = "mdi-checkbox-marked";
    protected String CHECKBOX_PARTLY_MARKED_CLASS = "mdi-minus-box";
    protected String CHECKBOX_NOT_MARKED_CLASS = "mdi-checkbox-blank-outline";

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    Map<String, List<String>> expectedTreeStructure;

    @DataProvider
    public static Object[][] activeTreeViewWithColor() {
        return new Object[][]{
                {activatableTreeView, Colors.BLUE_DARKEN_2},
                {colorTreeView, Colors.ORANGE_DARKEN_1},
                {roundedTreeView, Colors.BLUE_DARKEN_2},
                {shapedTreeView, Colors.BLUE_DARKEN_2}
        };
    }

    @Test(dataProvider = "activeTreeViewWithColor")
    public void activatedTreeViewTest(TreeView treeView, Colors color) {
        treeView.nodes().forEach(node -> {
            node.activate();
            node.is().active();
            node.value().has().css("color", color.value());
        });
    }

    @BeforeClass
    public void initData() {
        expectedTreeStructure = new LinkedHashMap<>();
        expectedTreeStructure.put("/", asList("Applications :" , "Documents :", "Downloads :", "Videos :"));
        expectedTreeStructure.put("/Applications :", asList("Calendar : app" , "Chrome : app", "Webstorm : app"));
        expectedTreeStructure.put("/Documents :", asList("vuetify :", "material2 :"));
        expectedTreeStructure.put("/Documents :/vuetify :", asList("src :"));
        expectedTreeStructure.put("/Documents :/vuetify :/src :", asList("index : ts", "bootstrap : ts"));
        expectedTreeStructure.put("/Documents :/material2 :", asList("src :"));
        expectedTreeStructure.put("/Documents :/material2 :/src :", asList("v-btn : ts", "v-card : ts", "v-window : ts"));
        expectedTreeStructure.put("/Downloads :", asList("October : pdf", "November : pdf", "Tutorial : html"));
        expectedTreeStructure.put("/Videos :", asList("Tutorials :", "Intro : mov", "Conference introduction : avi"));
        expectedTreeStructure.put("/Videos :/Tutorials :", asList("Basic layouts : mp4", "Advanced techniques : mp4", "All about app : dir"));
    }

    @Test
    public void itemDisabledTreeViewTest() {
        itemDisabledTreeView.is().collapsed();
        System.out.println(itemDisabledTreeView.elements(0));
        itemDisabledTreeView.get(2).expand();
        itemDisabledTreeView.has().enabled("Documents :", "Downloads :", "Videos :");
        itemDisabledTreeView.get("Applications :")
                .is().disabled()
                .has().disabled("Calendar : app", "Chrome : app", "Webstorm : app");
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :")
                .is().disabled()
                .has().disabled("index : ts", "bootstrap : ts");
        itemDisabledTreeView.get("Downloads :")
                .has().disabled("October : pdf", "November : pdf", "Tutorial : html");


        itemDisabledTreeView.select("Documents :", "Downloads :");
        itemDisabledTreeView.has().checked("Documents :", "Downloads :");
        itemDisabledTreeView.get("Downloads :").has().checked(Matchers.equalTo(Collections.emptyList()));
        itemDisabledTreeView.get("Documents :").is().selected();
        itemDisabledTreeView.get("Documents :").has().checked("vuetify :", "material2 :");
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :")
                .is().notSelected()
                .has().checked("index : ts", "bootstrap : ts");
        itemDisabledTreeView.get("Documents :").get("material2 :").get("src :")
                .is().selected()
                .has().checked("v-btn : ts", "v-card : ts", "v-window : ts");
    }



}
