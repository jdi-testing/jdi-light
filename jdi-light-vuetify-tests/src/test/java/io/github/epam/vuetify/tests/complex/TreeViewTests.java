package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.treeviewPage;


public class TreeViewTests extends TestsInit {

    protected String CHECKBOX_FULLY_MARKED_CLASS = "mdi-checkbox-marked";
    protected String CHECKBOX_PARTLY_MARKED_CLASS = "mdi-minus-box";
    protected String CHECKBOX_NOT_MARKED_CLASS = "mdi-checkbox-blank-outline";

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }


//    @DataProvider
//    public static Object[][] activeTreeViewWithColor() {
//        return new Object[][]{
//                {activatableTreeView, Colors.BLUE_DARKEN_2},
//                {colorTreeView, Colors.ORANGE_DARKEN_1},
//                {roundedTreeView, Colors.BLUE_DARKEN_2},
//                {shapedTreeView, Colors.BLUE_DARKEN_2}
//        };
//    }

//    @Test(dataProvider = "activeTreeViewWithColor")
//    public void activatedTreeViewTest(TreeView treeView, Colors color) {
//        checkTreeViewDefaultTextAndStructure(treeView);
//        treeView.nodes().forEach(node -> {
//            node.activate();
//            node.is().active(true);
//            node.content().has().css("color", color.value());
//        });
//    }
//
//    @Test
//    public void simpleDenseTreeViewTest() {
//        checkTreeViewDefaultTextAndStructure(denseTreeView);
//    }
//
//    @Test
//    public void simpleHoverableTreeViewTreeViewTest() {
//        checkTreeViewDefaultTextAndStructure(hoverableTreeView);
//    }

//    @Test
//    public void itemDisabledTreeViewTest() {
//        itemDisabledTreeView.is().collapsed();
//        System.out.println(itemDisabledTreeView.elements(0));
//        itemDisabledTreeView.get(2).expand();
//        checkTreeViewDefaultTextAndStructure(itemDisabledTreeView);
//        itemDisabledTreeView.has().enabled("Documents :", "Downloads :", "Videos :");
//        itemDisabledTreeView.getNode("Applications :")
//                .is().disabled()
//                .has().disabled("Calendar : app", "Chrome : app", "Webstorm : app");
//        itemDisabledTreeView.getNode("Documents :").getNode("vuetify :").getNode("src :")
//                .is().disabled()
//                .has().disabled("index : ts", "bootstrap : ts");
//        itemDisabledTreeView.getNode("Downloads :")
//                .has().disabled("October : pdf", "November : pdf", "Tutorial : html");
//
//
//        itemDisabledTreeView.select("Documents :", "Downloads :");
//        itemDisabledTreeView.has().checked("Documents :", "Downloads :");
//        itemDisabledTreeView.getNode("Downloads :").has().checked(empty());
//        itemDisabledTreeView.getNode("Documents :").is().selected(true);
//        itemDisabledTreeView.getNode("Documents :").has().checked("vuetify :", "material2 :");
//        itemDisabledTreeView.getNode("Documents :").getNode("vuetify :").getNode("src :")
//                .is().selected(false)
//                .has().checked("index : ts", "bootstrap : ts");
//        itemDisabledTreeView.getNode("Documents :").getNode("material2 :").getNode("src :")
//                .is().selected(true)
//                .has().checked("v-btn : ts", "v-card : ts", "v-window : ts");
//    }
//
//    protected void checkTreeViewDefaultTextAndStructure(TreeView treeView) {
//        treeView.is().pseudo();
//        treeView.has().values(equalTo(Arrays.asList(
//                "Applications :" , "Documents :", "Downloads :", "Videos :"
//        )));
//
//        TreeView applications = treeView.getNode("Applications :");
//        applications.has().values(equalTo(Arrays.asList(
//                "Calendar : app" , "Chrome : app", "Webstorm : app"
//        )));
//        applications.nodes().forEach(node -> node.is().leaf());
//
//        TreeView documents = treeView.getNode("Documents :");
//        documents.has().values(equalTo(Arrays.asList(
//                "vuetify :", "material2 :"
//        )));
//        TreeView vuetify = documents.getNode("vuetify :");
//        vuetify.has().values(equalTo(Arrays.asList("src :")));
//        TreeView vuetifySource = vuetify.getNode("src :");
//        vuetifySource.has().values(equalTo(Arrays.asList(
//                "index : ts", "bootstrap : ts"
//        )));
//        vuetifySource.nodes().forEach(node -> node.is().leaf());
//        TreeView material = documents.getNode("material2 :");
//        material.has().values(equalTo(Arrays.asList("src :")));
//        TreeView materialSource = material.getNode("src :");
//        materialSource.has().values(equalTo(Arrays.asList(
//                "v-btn : ts", "v-card : ts", "v-window : ts"
//        )));
//
//        TreeView downloads = treeView.getNode("Downloads :");
//        downloads.has().values(equalTo(Arrays.asList(
//                "October : pdf", "November : pdf", "Tutorial : html"
//        )));
//        downloads.nodes().forEach(node -> node.is().leaf());
//
//        TreeView videos = treeView.getNode("Videos :");
//        videos.has().values(equalTo(Arrays.asList(
//                "Tutorials :", "Intro : mov", "Conference introduction : avi"
//        )));
//        videos.getNode("Intro : mov").is().leaf();
//        videos.getNode("Conference introduction : avi").is().leaf();
//        TreeView tutorials = videos.getNode("Tutorials :");
//        tutorials.has().values(equalTo(Arrays.asList(
//                "Basic layouts : mp4", "Advanced techniques : mp4", "All about app : dir"
//        )));
//        tutorials.nodes().forEach(node -> node.is().leaf());
//    }
}
