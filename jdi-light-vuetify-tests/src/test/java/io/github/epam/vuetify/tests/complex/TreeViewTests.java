package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLACK_TRANSPARENT_087;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE_DARKEN_1;
import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.*;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TreeViewTests extends TestsInit {

    Map<String, List<String>> expectedTreeStructure;
    Map<String, List<String>> expectedFileTreeStructure;

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
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

        expectedFileTreeStructure = new LinkedHashMap<>();
        expectedFileTreeStructure.put("/", asList(".git", "node_modules", "public", ".gitignore",
                "babel.config.js", "package.json", "README.md", "vue.config.js", "yarn.lock"));
        expectedFileTreeStructure.put("/public", asList("static", "favicon.ico", "index.html"));
        expectedFileTreeStructure.put("/public/static", asList("logo.png"));
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
        loadChildrenTreeView.is().expanded();
//        loadChildrenTreeView.has().values(equalTo(asList("Users")));
        loadChildrenTreeView.get("Users").expand();
        loadChildrenTreeView.get("Users").has().values(equalTo(asList(
                "Leanne Graham", "Ervin Howell", "Clementine Bauch", "Patricia Lebsack",
                "Chelsey Dietrich", "Mrs. Dennis Schulist", "Kurtis Weissnat",
                "Nicholas Runolfsdottir V", "Glenna Reichert", "Clementina DuBuque"
        )));
//        loadChildrenTreeView.get("Users").get(1).activate();
//        loadChildrenTreeView.get("Users").get(2).activate();
//        loadChildrenTreeView.get("Users").get(3).activate();
//        loadChildrenTreeView.get("Users").get(4).activate();
//        loadChildrenTreeView.get("Users").get(5).activate();
//        loadChildrenTreeView.get("Users").get(6).activate();
//        loadChildrenTreeView.get("Users").get(7).activate();
        loadChildrenTreeView.is().recursive(treeView -> {
            if (treeView.isLeaf()) {
//                System.out.println(treeView.getText());
                treeView.activate();
                treeView.is().active(true);
                System.out.println(treeView.value().find(".v-icon").classes());
                treeView.value().find(".v-icon").has().classValue(containsString("mdi-account"));
                treeView.value().has().css("color", ORANGE_DARKEN_1.value());
                card.content().find("h3").has().text(equalTo(treeView.getText()));
                treeView.deactivate();
                treeView.is().active(false);

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
        treeView.walk(checkedTree -> {
            if (checkedTree.isPseudoCore()) {
                return;
            }
            checkedTree.has().checkbox(true);
            checkedTree.is().notMarked();
            checkedTree.check();
            checkedTree.is().fullyMarked();
            checkedTree.checkbox().has().css("color", color.value());
            checkedTree.uncheck();
            checkedTree.is().notMarked();
        });
        treeView.has().structure(expectedTreeStructure);
    }

    @Test
    public void selectionTypeTreeViewTest() {
        selectionTypeTreeView.assertThat().recursive(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            treeView.has().checkbox(true);
            treeView.check();
            treeView.is().fullyMarked();
            List<String> checked = new ArrayList<>();
            treeView.is().recursive(child -> {
                if (child.isLeaf() && child.isFullyMarked()) {
                    checked.add(child.getText());
                }
            });
            assertThat(checked, equalTo(selectionTypeResult.values()));
            treeView.uncheck();
        });

        String id = selectionTypeId.attr("id").split("-")[1];
        selectionTypeExpander.click();
        WebList values = $$("#list-" + id + " .v-list-item");
        values.get("independent").click();

        selectionTypeTreeView.assertThat().recursive(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            treeView.check();
            assertThat(selectionTypeResult.values(), hasSize(1));
            treeView.has().text(selectionTypeResult.values().get(0));
            treeView.uncheck();
        });
        List<String> checked = new ArrayList<>();
        selectionTypeTreeView.assertThat().recursive(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            treeView.check();
            treeView.is().selected(true);
            checked.add(treeView.getText());
        });
        assertThat(checked, equalTo(selectionTypeResult.values()));
    }

    @Test
    public void appendLabelTreeViewTest() {
        appendLabelTreeView.has().structure(expectedFileTreeStructure);
        appendLabelTreeView.get(".git").value().find(".v-icon")
                .has().classValue(containsString("mdi-folder"));
        appendLabelTreeView.get("node_modules").value().find(".v-icon")
                .has().classValue(containsString("mdi-folder"));
        appendLabelTreeView.get("public").value().find(".v-icon")
                .has().classValue(containsString("mdi-folder-open"));
        appendLabelTreeView.get(".gitignore").value().find(".v-icon")
                .has().classValue(containsString("mdi-file-document-outline"));
        appendLabelTreeView.get("babel.config.js").value().find(".v-icon")
                .has().classValue(containsString("mdi-nodejs"));
        appendLabelTreeView.get("package.json").value().find(".v-icon")
                .has().classValue(containsString("mdi-code-json"));
        appendLabelTreeView.get("README.md").value().find(".v-icon")
                .has().classValue(containsString("mdi-language-markdown"));
        appendLabelTreeView.get("vue.config.js").value().find(".v-icon")
                .has().classValue(containsString("mdi-nodejs"));
        appendLabelTreeView.get("yarn.lock").value().find(".v-icon")
                .has().classValue(containsString("mdi-file-document-outline"));
        appendLabelTreeView.get(".git").value().find(".v-icon")
                .has().classValue(containsString("mdi-folder"));

        TreeView publicTree = appendLabelTreeView.get("public");
        publicTree.get("static").value().find(".v-icon")
                .has().classValue(containsString("mdi-folder"));
        publicTree.get("favicon.ico").value().find(".v-icon")
                .has().classValue(containsString("mdi-file-image"));
        publicTree.get("index.html").value().find(".v-icon")
                .has().classValue(containsString("mdi-language-html5"));

        TreeView staticTree = publicTree.get("static");
        staticTree.get("logo.png").value().find(".v-icon")
                .has().classValue(containsString("mdi-file-image"));
    }

    @Test
    public void searchAndFilterTreeViewTest() {
        TreeView vuetifyTree = searchFilterTreeView.get(1);

        searchLine.input("Core team");
        vuetifyTree.get("Core team").has().values("John", "Kael", "Nekosaur", "Jacek", "Andrew");
        clearSearchLineButton.click();

        searchLine.input("K");
        vuetifyTree.has().values("Core team", "Administrators");
        vuetifyTree.get("Core team").has().values("Kael", "Nekosaur", "Jacek");
        vuetifyTree.get("Administrators").has().values("Mike");
        clearSearchLineButton.click();

        caseSensitiveSearch.check();
        vuetifyTree.has().values("Core team");
        vuetifyTree.get("Core team").has().values("Kael");
    }

    @Test
    public void selectableIconsTreeViewTest() {
        selectableIconsTreeView.is().recursive(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            if (treeView.isLeaf()) {
                treeView.root().highlight();
                return;
            }
            treeView.root().highlight();
            System.out.println(treeView.getText());
            treeView.is().notMarked();
            treeView.expand();
            treeView.select();
            treeView.is().fullyMarked();
            List<String> checked = new ArrayList<>();
            treeView.assertThat().recursive(tree -> {
                 if (!tree.isLeaf()) {
                     return;
                 }
                 tree.is().fullyMarked();
                 checked.add(tree.getText());
            });
            assertThat(checked, equalTo(chips.values()));
            treeView.uncheck();
            treeView.root().highlight();
        });
    }


}
