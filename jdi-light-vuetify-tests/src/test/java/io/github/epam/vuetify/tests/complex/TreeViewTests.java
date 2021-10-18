package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
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
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_ACCENT_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE_DARKEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED;
import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.activatableTreeView;
import static io.github.com.pages.TreeviewPage.appendLabelTreeView;
import static io.github.com.pages.TreeviewPage.caseSensitiveSearchCheckbox;
import static io.github.com.pages.TreeviewPage.chips;
import static io.github.com.pages.TreeviewPage.clearSearchButton;
import static io.github.com.pages.TreeviewPage.colorTreeView;
import static io.github.com.pages.TreeviewPage.denseTreeView;
import static io.github.com.pages.TreeviewPage.hoverableTreeView;
import static io.github.com.pages.TreeviewPage.itemDisabledTreeView;
import static io.github.com.pages.TreeviewPage.loadChildrenTreeView;
import static io.github.com.pages.TreeviewPage.openAllTreeView;
import static io.github.com.pages.TreeviewPage.reset;
import static io.github.com.pages.TreeviewPage.roundedTreeView;
import static io.github.com.pages.TreeviewPage.searchFilterTreeView;
import static io.github.com.pages.TreeviewPage.searchLine;
import static io.github.com.pages.TreeviewPage.selectableIconsTreeView;
import static io.github.com.pages.TreeviewPage.selectableTreeView;
import static io.github.com.pages.TreeviewPage.selectedColorTreeView;
import static io.github.com.pages.TreeviewPage.selectionTypeExpander;
import static io.github.com.pages.TreeviewPage.selectionTypeId;
import static io.github.com.pages.TreeviewPage.selectionTypeResult;
import static io.github.com.pages.TreeviewPage.selectionTypeTreeView;
import static io.github.com.pages.TreeviewPage.shapedTreeView;
import static io.github.com.pages.TreeviewPage.userCard;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class TreeViewTests extends TestsInit {

    Map<String, List<String>> expectedBaseTreeStructure;
    Map<String, List<String>> expectedFileTreeStructure;

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    @BeforeClass
    public void initData() {
        expectedBaseTreeStructure = new LinkedHashMap<String, List<String>>() {{
            put("/", asList("Applications :", "Documents :", "Downloads :", "Videos :"));
            put("/Applications :", asList("Calendar : app", "Chrome : app", "Webstorm : app"));
            put("/Documents :", asList("vuetify :", "material2 :"));
            put("/Documents :/vuetify :", asList("src :"));
            put("/Documents :/vuetify :/src :", asList("index : ts", "bootstrap : ts"));
            put("/Documents :/material2 :", asList("src :"));
            put("/Documents :/material2 :/src :", asList("v-btn : ts", "v-card : ts", "v-window : ts"));
            put("/Downloads :", asList("October : pdf", "November : pdf", "Tutorial : html"));
            put("/Videos :", asList("Tutorials :", "Intro : mov", "Conference introduction : avi"));
            put("/Videos :/Tutorials :", asList("Basic layouts : mp4", "Advanced techniques : mp4", "All about app : dir"));
        }};

        expectedFileTreeStructure = new LinkedHashMap<String, List<String>>() {{
            put("/", asList(".git", "node_modules", "public", ".gitignore", "babel.config.js", "package.json",
                    "README.md", "vue.config.js", "yarn.lock"));
            put("/public", asList("static", "favicon.ico", "index.html"));
            put("/public/static", asList("logo.png"));
        }};
    }

    @Test
    public void activatableTreeViewTest() {
        activatableTreeView.is().pseudoCore();
        activatableTreeView.has().structure(expectedBaseTreeStructure);
        activatableTreeView.walk(treeView -> {
            if (!treeView.isLeaf()) {
                treeView.is().expanded();
            }
            if (!treeView.isPseudoCore()) {
                treeView.has().checkbox(false);
                treeView.has().color(BLACK_TRANSPARENT_087);
                treeView.activate();
                treeView.is().active(true);
                treeView.has().color(BLUE_DARKEN_2);
                treeView.deactivate();
                treeView.is().active(false);
            }
        });
    }

    @Test
    public void colorTreeViewTest() {
        colorTreeView.has().structure(expectedBaseTreeStructure);
        colorTreeView.walk(treeView -> {
            if (!treeView.isLeaf() && !treeView.isPseudoCore()) {
                String child = treeView.first().getText();
                treeView.get(child).has().color(BLACK_TRANSPARENT_087);
                treeView.get(child).activate();
                treeView.get(child).has().color(ORANGE_DARKEN_1);
                treeView.close();
                treeView.is().collapsed();
                treeView.expand();
                treeView.is().expanded();
                treeView.get(child).deactivate();
                treeView.get(child).has().color(BLACK_TRANSPARENT_087);
            }
        });
    }

    @Test
    public void denseTreeViewTest() {
        denseTreeView.has().structure(expectedBaseTreeStructure);
        denseTreeView.walk(treeView -> {
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
        hoverableTreeView.has().structure(expectedBaseTreeStructure);
    }

    @Test
    public void itemDisabledTreeViewTest() {
        itemDisabledTreeView.has().enabled(equalTo(asList("Documents :", "Downloads :", "Videos :")));
        itemDisabledTreeView.has().disabled(equalTo(asList("Applications :")));
        itemDisabledTreeView.get("Applications :").walk(treeView -> {
            treeView.is().disabled();
        });
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :").walk(treeView -> {
            treeView.is().disabled();
        });
        itemDisabledTreeView.get("Downloads :")
                .has().disabled("October : pdf", "November : pdf", "Tutorial : html");
        itemDisabledTreeView.select("Documents :", "Downloads :");
        itemDisabledTreeView.get("Documents :").get("material2 :").get("src :").walk(treeView -> {
            treeView.is().selected(true);
        });
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :")
                .is().selected(false)
                .has().checked("index : ts", "bootstrap : ts");
        itemDisabledTreeView.get("Downloads :")
                .is().selected(true)
                .has().checked(is(empty()));
        itemDisabledTreeView.has().structure(expectedBaseTreeStructure);
    }

    @Test
    public void loadChildrenTreeViewTest() {
        loadChildrenTreeView.get("Users").has().values(equalTo(asList(
                "Leanne Graham", "Ervin Howell", "Clementine Bauch", "Patricia Lebsack",
                "Chelsey Dietrich", "Mrs. Dennis Schulist", "Kurtis Weissnat",
                "Nicholas Runolfsdottir V", "Glenna Reichert", "Clementina DuBuque"
        )));
        loadChildrenTreeView.walk(treeView -> {
            if (treeView.isLeaf()) {
                treeView.activate();
                treeView.has().color(ORANGE_DARKEN_1);
                treeView.value().find(".v-icon").has().classValue(containsString("mdi-account"));
                assertThat(treeView.getText(), equalTo(userCard.content().find("h3").getText()));
                treeView.deactivate();
                treeView.has().color(BLACK_TRANSPARENT_087);
            }
        });
    }

    @Test
    public void openAllTreeViewTest() {
        openAllTreeView.has().structure(expectedBaseTreeStructure);
        openAllTreeView.walk(treeView -> {
            if (!treeView.isLeaf()) {
                treeView.is().expanded();
            }
        });
    }

    @Test
    public void roundedTreeViewTest() {
        roundedTreeView.has().structure(expectedBaseTreeStructure);
        roundedTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().rounded(true);
            }
        });
    }

    @Test
    public void shapedTreeViewTest() {
        shapedTreeView.has().structure(expectedBaseTreeStructure);
        shapedTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().shaped(true);
            }
        });
    }

    @DataProvider
    public static Object[][] selectableTreeViewDataWithColor() {
        return new Object[][]{
                {selectableTreeView, BLUE_ACCENT_1},
                {selectedColorTreeView, RED}
        };
    }

    @Test(dataProvider = "selectableTreeViewDataWithColor")
    public void selectableTreeViewTest(TreeView treeView, Colors color) {
        treeView.has().structure(expectedBaseTreeStructure);
        treeView.walk(checkedTree -> {
            if (!checkedTree.isPseudoCore()) {
                checkedTree.has().checkbox(true);
                checkedTree.is().notMarked();
                checkedTree.check();
                checkedTree.is().fullyMarked();
                checkedTree.checkbox().has().css("color", color.value());
                checkedTree.uncheck();
                checkedTree.is().notMarked();
            }
        });
    }

    private static void selectInDropDownByIdAndExpander(UIElement idElement, UIElement expander, String value) {
        String fullId = idElement.attr("id");
        String id = fullId.substring(fullId.indexOf("-") + 1);
        expander.click();
        WebList values = $$(String.format("#list-%s .v-list-item", id));
        values.get(value).click();
    }

    @Test
    public void selectionTypeTreeViewTest() {
        selectionTypeTreeView.walk(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            treeView.has().checkbox(true);
            treeView.check();
            treeView.is().fullyMarked();
            List<String> checked = new ArrayList<>();
            treeView.walk(child -> {
                if (child.isLeaf() && child.isFullyMarked()) {
                    checked.add(child.getText());
                }
            });
            assertThat(checked, equalTo(selectionTypeResult.values()));
            treeView.uncheck();
        });

        selectInDropDownByIdAndExpander(selectionTypeId, selectionTypeExpander, "independent");

        selectionTypeTreeView.walk(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            treeView.check();
            assertThat(selectionTypeResult.values(), hasSize(1));
            treeView.has().text(selectionTypeResult.first().getText());
            treeView.uncheck();
        });
        List<String> checked = new ArrayList<>();
        selectionTypeTreeView.walk(treeView -> {
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
        TreeView vuetifyTree = searchFilterTreeView.get("Vuetify Human Resources");

        searchLine.input("Core team");
        vuetifyTree.get("Core team").has().values("John", "Kael", "Nekosaur", "Jacek", "Andrew");
        clearSearchButton.click();

        searchLine.input("K");
        vuetifyTree.has().values("Core team", "Administrators");
        vuetifyTree.get("Core team").has().values("Kael", "Nekosaur", "Jacek");
        vuetifyTree.get("Administrators").has().values("Mike");

        caseSensitiveSearchCheckbox.check();
        vuetifyTree.has().values("Core team");
        vuetifyTree.get("Core team").has().values("Kael");
        clearSearchButton.click();
    }

    @Test
    public void selectableIconsTreeViewTest() {
        selectableIconsTreeView.walk(treeView -> {
            if (treeView.isPseudoCore()) {
                return;
            }
            treeView.is().notMarked();
            treeView.is().selected(false);
            treeView.check();
            List<String> checked = new ArrayList<>();
            treeView.walk(childTree -> {
                childTree.is().fullyMarked();
                childTree.is().selected(true);
                if (childTree.isLeaf()) {
                    checked.add(childTree.getText());
                }
            });
            assertThat(checked, equalTo(chips.values()));
            reset.click();
        });
    }
}
