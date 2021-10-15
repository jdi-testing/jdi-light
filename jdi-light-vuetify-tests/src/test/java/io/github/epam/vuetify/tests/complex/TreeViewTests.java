package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.*;
import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.*;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class TreeViewTests extends TestsInit {

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    Map<String, List<String>> expectedTreeStructure;

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
    public void activatableTreeViewTest() {
        activatableTreeView.is().pseudoCore();
        activatableTreeView.has().structure(expectedTreeStructure);
        activatableTreeView.shouldBe().recursive(treeView -> {
            if (!treeView.isLeaf()) {
                treeView.is().expanded();
            }
            if (!treeView.isPseudoCore()) {
                treeView.value().has().css("color", BLACK_TRANSPARENT_087.value());
                treeView.activate();
                treeView.is().active(true);
                treeView.value().has().css("color", BLUE_DARKEN_2.value());
                treeView.deactivate();
                treeView.is().active(false);
                treeView.has().checkbox(false);
                treeView.is().hoverable(false);
                treeView.is().rounded(false);
                treeView.is().shaped(false);
            }
        });
    }

    @Test
    public void colorTreeViewTest() {
        colorTreeView.is().pseudoCore();
        colorTreeView.has().structure(expectedTreeStructure);
        colorTreeView.shouldBe().recursive(treeView -> {
            if (!treeView.isLeaf() && !treeView.isPseudoCore()) {
                String child = treeView.nodes()
                        .stream()
                        .findAny()
                        .map(TreeView::getText)
                        .orElse(null);
                if (child != null) {
                    treeView.get(child).activate();
                    treeView.get(child).is().active(true);
                    treeView.get(child).value().has().css("color", ORANGE_DARKEN_1.value());
                    treeView.close();
                    treeView.is().collapsed();
                    treeView.expand();
                    treeView.is().expanded();
                    treeView.get(child).is().active(true);
                    treeView.get(child).value().has().css("color", BLACK_TRANSPARENT_087.value());
                }
            }
        });
    }

    @Test
    public void denseTreeViewTest() {
        denseTreeView.has().structure(expectedTreeStructure);
        denseTreeView.shouldBe().recursive(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.activate();
                treeView.is().active(false);
                treeView.has().checkbox(false);
            }
        });
    }

    @Test
    public void hoverableTreeViewTest() {
        hoverableTreeView.is().hoverable(true);
        hoverableTreeView.has().structure(expectedTreeStructure);
    }

    @Test
    public void itemDisabledTreeViewTest() {
        itemDisabledTreeView.assertThat().recursive(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.has().checkbox(true);
                treeView.is().selected(false);
            }
        });
        itemDisabledTreeView.has().enabled(equalTo(asList("Documents :", "Downloads :", "Videos :")));
        itemDisabledTreeView.has().disabled(equalTo(asList("Applications :")));
        itemDisabledTreeView.get("Applications :").is().recursive(treeView -> {
            treeView.is().disabled();
        });
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :").is().recursive(treeView -> {
            treeView.is().disabled();
        });
        itemDisabledTreeView.get("Downloads :")
                .has().disabled("October : pdf", "November : pdf", "Tutorial : html");
        itemDisabledTreeView.select("Documents :", "Downloads :");
        itemDisabledTreeView.get("Documents :").get("material2 :").get("src :").is().recursive(treeView -> {
            treeView.is().selected(true);
        });
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :")
                .is().selected(false)
                .has().checked("index : ts", "bootstrap : ts");
        itemDisabledTreeView.get("Downloads :")
                .is().selected(true)
                .has().checked(emptyList());
        itemDisabledTreeView.has().structure(expectedTreeStructure);
    }

    @Test
    public void loadChildrenTreeViewTest() {
        loadChildrenTreeView.has().values(equalTo(asList("Users")));
        loadChildrenTreeView.get("Users").has().values(equalTo(asList(
                "Leanne Graham", "Ervin Howell", "Clementine Bauch", "Patricia Lebsack",
                "Chelsey Dietrich", "Mrs. Dennis Schulist", "Kurtis Weissnat",
                "Nicholas Runolfsdottir V", "Glenna Reichert", "Clementina DuBuque"
        )));
        loadChildrenTreeView.is().recursive(treeView -> {
            if (treeView.isLeaf()) {
                treeView.activate();
                treeView.is().active(true);
                treeView.value().find(".v-icon").has().classValue(containsString("mdi-account"));
                treeView.value().has().css("color", ORANGE_DARKEN_1.value());
                card.content().find("h3").has().text(equalTo(treeView.getText()));
                treeView.deactivate();
                treeView.is().active(false);
                selectText.is().displayed()
                        .has().text("Select a User");
            }
        });
    }

    @Test
    public void openAllTreeViewTest() {
        openAllTreeView.assertThat().recursive(treeView -> {
            if (!treeView.isLeaf()) {
                treeView.is().expanded();
            }
        });
        openAllTreeView.has().structure(expectedTreeStructure);
    }

    @Test
    public void roundedTreeViewTest() {
        roundedTreeView.assertThat().recursive(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().rounded(true);
            }
        });
        roundedTreeView.has().structure(expectedTreeStructure);
    }

    @Test
    public void shapedTreeViewTest() {
        shapedTreeView.assertThat().recursive(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().shaped(true);
            }
        });
        shapedTreeView.has().structure(expectedTreeStructure);
    }

    @DataProvider
    public static Object[][] selectableTreeViewWithColor() {
        return new Object[][]{
                {selectableTreeView, Colors.BLUE_ACCENT_1},
                {selectedColorTreeView, Colors.RED}
        };
    }

    @Test(dataProvider = "selectableTreeViewWithColor")
    public void selectableTreeViewTest(TreeView treeView, Colors color) {
        treeView.has().structure(expectedTreeStructure);
        treeView.is().recursive(checkedTree -> {
            if (!checkedTree.isPseudoCore()) {
                checkedTree.has().checkbox(true);
                checkedTree.is().notMarked();
                checkedTree.check();
                checkedTree.is().fullyMarked();
                checkedTree.checkbox().has().css("color", color.value());
                treeView.assertThat().recursive(tree -> {
                    if (!tree.isPseudoCore()) {
                        if (tree.isNotMarked()) {
                            return;
                        }
                        if (tree.isLeaf() && tree.isPartlyMarked()) {
                            fail("Leaf node can't be partly marked" + tree.getText());
                        }
                        if (tree.isFullyMarked()) {
                            tree.nodes().forEach(node -> node.is().fullyMarked().and().selected(true));
                        } else if (tree.isPartlyMarked()) {
                            assertTrue("Can't find any marked children in marked node",
                                    tree.nodes()
                                    .stream()
                                    .anyMatch(child -> child.isPartlyMarked() || child.isFullyMarked())
                            );
                        }
                    }
                });
                checkedTree.uncheck();
                checkedTree.is().notMarked();
            }
        });
    }

}
