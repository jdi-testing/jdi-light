package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.BLUE_ACCENT_1;
import static io.github.com.enums.Colors.ORANGE_DARKEN_1;
//import static io.github.com.enums.MdiIcons.CODE_JSON;
//import static io.github.com.enums.MdiIcons.FILE_DOCUMENT_OUTLINE;
//import static io.github.com.enums.MdiIcons.FOLDER;
//import static io.github.com.enums.MdiIcons.LANGUAGE_MARKDOWN;
//import static io.github.com.enums.MdiIcons.MENU_DOWN;
//import static io.github.com.enums.MdiIcons.NODEJS;
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
import static io.github.com.pages.TreeviewPage.shapedTreeView;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TreeViewTests extends TestsInit {

    Map<String, List<String>> expectedBaseTreeStructure;
    Map<String, List<String>> expectedFileTreeStructure;

    @BeforeClass
    public void before() {
        treeviewPage.open();
        waitCondition(() -> treeviewPage.isOpened());
        treeviewPage.checkOpened();
        initData();
    }

    private void initData() {
        expectedBaseTreeStructure = new LinkedHashMap<>();
        expectedBaseTreeStructure.put("/", asList("Applications :", "Documents :", "Downloads :", "Videos :"));
        expectedBaseTreeStructure.put("/Applications :", asList("Calendar : app", "Chrome : app", "Webstorm : app"));
        expectedBaseTreeStructure.put("/Documents :", asList("vuetify :", "material2 :"));
        expectedBaseTreeStructure.put("/Documents :/vuetify :", asList("src :"));
        expectedBaseTreeStructure.put("/Documents :/vuetify :/src :", asList("index : ts", "bootstrap : ts"));
        expectedBaseTreeStructure.put("/Documents :/material2 :", asList("src :"));
        expectedBaseTreeStructure.put("/Documents :/material2 :/src :",
                asList("v-btn : ts", "v-card : ts", "v-window : ts"));
        expectedBaseTreeStructure.put("/Downloads :", asList("October : pdf", "November : pdf", "Tutorial : html"));
        expectedBaseTreeStructure.put("/Videos :",
                asList("Tutorials :", "Intro : mov", "Conference introduction : avi"));
        expectedBaseTreeStructure.put("/Videos :/Tutorials :",
                asList("Basic layouts : mp4", "Advanced techniques : mp4", "All about app : dir"));

        expectedFileTreeStructure = new LinkedHashMap<>();
        expectedFileTreeStructure.put("/", asList(".git", "node_modules", "public", ".gitignore", "babel.config.js",
                "package.json", "README.md", "vue.config.js", "yarn.lock"));
        expectedFileTreeStructure.put("/public", asList("static", "favicon.ico", "index.html"));
        expectedFileTreeStructure.put("/public/static", asList("logo.png"));
    }

    @Test(description = "Test checks that tree-view is activatable")
    public void activatableTreeViewTest() {
        activatableTreeView.show();
        activatableTreeView.expand();
        activatableTreeView.has().structure(expectedBaseTreeStructure);
        activatableTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.activate();
                treeView.is().active();
                treeView.deactivate();
                treeView.is().notActive();
            }
        });
    }

    @Test(description = "Test checks if tree-view is pseudo core or not")
    public void pseudoCoreTreeViewTest() {
        activatableTreeView.show();
        activatableTreeView.is().pseudoCore();
        activatableTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().notPseudoCore();
            }
        });
    }

    @Test(description = "Test checks tree-view color")
    public void colorTreeViewTest() {
        colorTreeView.show();
        colorTreeView.walk(treeView -> {
            if (!treeView.isLeaf() && !treeView.isPseudoCore()) {
                TreeView child = treeView.first();
                child.has().color(BLACK_TRANSPARENT_087.value());
                child.activate();
                child.has().color(ORANGE_DARKEN_1.value());
                child = treeView.first();
                child.deactivate();
                child.has().color(BLACK_TRANSPARENT_087.value());
            }
        });
    }

    @Test(description = "Test checks if tree-view is expanded or collapsed")
    public void expandCollapseTreeViewTest() {
        colorTreeView.show();
        colorTreeView.walk(treeView -> {
            if (!treeView.isLeaf() && !treeView.isPseudoCore()) {
                treeView.close();
                treeView.is().collapsed();
                treeView.expand();
                treeView.is().expanded();
            }
        });
    }

    @Test(description = "Test checks if tree-view has checkbox with color or not")
    public void checkboxTreeViewTest() {
        activatableTreeView.show();
        activatableTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.has().noCheckbox();
            }
        });
        selectableTreeView.show();
        selectableTreeView.walk(checkedTree -> {
            if (!checkedTree.isPseudoCore()) {
                checkedTree.has().checkbox();
                checkedTree.check();
                waitCondition(() -> checkedTree.checkboxColor().equals(BLUE_ACCENT_1.value()));
                checkedTree.has().checkboxColor(BLUE_ACCENT_1.value());
            }
        });
    }

    @Test(description = "Test checks if tree-view is dense or not : dense (y/n)")
    public void denseTreeViewTest() {
        denseTreeView.show();
        denseTreeView.is().dense();
        hoverableTreeView.show();
        hoverableTreeView.is().notDense();
    }

    @Test(description = "Test checks if tree-view is hoverable or not")
    public void hoverableTreeViewTest() {
        hoverableTreeView.show();
        hoverableTreeView.is().hoverable();
        denseTreeView.show();
        denseTreeView.is().notHoverable();
    }

    @Test(description = "Test checks that tree-view items are disabled")
    public void itemDisabledTreeViewTest() {
        itemDisabledTreeView.show();
        itemDisabledTreeView.has().enabled(asList("Documents :", "Downloads :", "Videos :"));
        itemDisabledTreeView.has().disabled(asList("Applications :"));
        itemDisabledTreeView.get("Applications :").walk(treeView -> {
            treeView.is().disabled();
        });
        itemDisabledTreeView.get("Documents :").get("vuetify :").get("src :").walk(treeView -> {
            treeView.is().disabled();
        });
        itemDisabledTreeView.get("Downloads :")
                .is().disabled("October : pdf", "November : pdf", "Tutorial : html");
    }

    @Test(description = "Test checks that tree-view is loading : load children (y/n)")
    public void loadChildrenTreeViewTest() {
        loadChildrenTreeView.show();
        loadChildrenTreeView.expand();
        loadChildrenTreeView.is().loading();
        waitCondition(() -> !loadChildrenTreeView.isLoading());
        loadChildrenTreeView.is().loaded();
    }

    @Test(description = "Test checks if tree-view is collapsed or expanded")
    public void openAllTreeViewTest() {
        openAllTreeView.show();
        openAllTreeView.walk(treeView -> {
            if (!treeView.isLeaf()) {
                treeView.is().expanded();
            } else {
                treeView.is().collapsed();
            }
        });
    }

    @Test(description = "Test checks if tree-view is rounded or not")
    public void roundedTreeViewTest() {
        roundedTreeView.show();
        roundedTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().rounded();
            }
        });
        shapedTreeView.show();
        shapedTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().notRounded();
            }
        });
    }

    @Test(description = "Test checks if tree-view is shaped or not")
    public void shapedTreeViewTest() {
        shapedTreeView.show();
        shapedTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().shaped();
            }
        });
        selectableTreeView.show();
        selectableTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().notShaped();
            }
        });
    }

    @Test(description = "Test checks tree-view icons")
    public void iconsTreeViewTest() {
        appendLabelTreeView.show();
        appendLabelTreeView.has().structure(expectedFileTreeStructure);
        appendLabelTreeView.get(".git").icon().has().type("mdi-folder");
        appendLabelTreeView.get("node_modules").icon().has().type("mdi-folder");
        appendLabelTreeView.get("public").icon().has().type("mdi-menu-down");
        appendLabelTreeView.get(".gitignore").icon().has().type("mdi-file-document-outline");
        appendLabelTreeView.get("babel.config.js").icon().has().type("mdi-nodejs");
        appendLabelTreeView.get("package.json").icon().has().type("mdi-code-json");
        appendLabelTreeView.get("README.md").icon().has().type("mdi-language-markdown");
        appendLabelTreeView.get("vue.config.js").icon().has().type("mdi-nodejs");
        appendLabelTreeView.get("yarn.lock").icon().has().type("mdi-file-document-outline");
        appendLabelTreeView.get(".git").icon().has().type("mdi-folder");
    }

    @Test(description = "Test checks tree-view search and values")
    public void searchAndFilterTreeViewTest() {
        searchFilterTreeView.show();
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

    @Test(description = "Test checks if tree-view is marked or not")
    public void selectableIconsTreeViewTest() {
        selectableIconsTreeView.show();
        selectableIconsTreeView.walk(treeView -> {
            if (!treeView.isPseudoCore()) {
                treeView.is().notMarked();
                treeView.check();
                List<String> checked = new ArrayList<>();
                chips.hover();
                treeView.walk(childTree -> {
                    childTree.is().fullyMarked();
                    if (childTree.isLeaf()) {
                        checked.add(childTree.getText());
                    }
                });
                assertThat(checked, equalTo(chips.values()));
                reset.click();
            }
        });
    }

    @Test(description = "Test checks if tree-view node is leaf or not")
    public void leafTreeViewTest() {
        selectableTreeView.walk(treeView -> {
            if (!treeView.isLeaf()) {
                treeView.is().notLeaf();
            } else {
                treeView.is().leaf();
            }
        });
    }

    @Test(description = "Test checks if tree-view node is selected or not")
    public void selectTreeViewTest() {
        selectableTreeView.walk(checkedTree -> {
            if (!checkedTree.isPseudoCore()) {
                checkedTree.has().checkbox();
                checkedTree.check();
                checkedTree.is().selected();
                checkedTree.uncheck();
                checkedTree.is().notSelected();
            }
        });
    }
}
