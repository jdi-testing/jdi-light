package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TreeViewNode;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.BLUE_ACCENT_1;
import static io.github.com.enums.Colors.ORANGE_DARKEN_1;
import static io.github.com.enums.MdiIcons.CODE_JSON;
import static io.github.com.enums.MdiIcons.FILE_DOCUMENT_OUTLINE;
import static io.github.com.enums.MdiIcons.FOLDER;
import static io.github.com.enums.MdiIcons.LANGUAGE_MARKDOWN;
import static io.github.com.enums.MdiIcons.MENU_DOWN;
import static io.github.com.enums.MdiIcons.NODEJS;
import static io.github.com.pages.TreeviewPage.activatableTreeView;
import static io.github.com.pages.TreeviewPage.appendLabelTreeView;
import static io.github.com.pages.TreeviewPage.caseSensitiveSearchCheckbox;
import static io.github.com.pages.TreeviewPage.chips;
import static io.github.com.pages.TreeviewPage.colorTreeView;
import static io.github.com.pages.TreeviewPage.denseTreeView;
import static io.github.com.pages.TreeviewPage.hoverableTreeView;
import static io.github.com.pages.TreeviewPage.itemDisabledTreeView;
import static io.github.com.pages.TreeviewPage.loadChildrenTreeView;
import static io.github.com.pages.TreeviewPage.reset;
import static io.github.com.pages.TreeviewPage.roundedTreeView;
import static io.github.com.pages.TreeviewPage.searchFilterTreeView;
import static io.github.com.pages.TreeviewPage.searchLine;
import static io.github.com.pages.TreeviewPage.selectableIconsTreeView;
import static io.github.com.pages.TreeviewPage.selectableTreeView;
import static io.github.com.pages.TreeviewPage.shapedTreeView;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TreeViewTests extends TestsInit {
    @BeforeClass
    public void before() {
        treeviewPage.open();
        waitCondition(() -> treeviewPage.isOpened());
        treeviewPage.checkOpened();
    }


    @Test(description = "Test checks that tree-view is activatable")
    public void activatableTreeViewTest() {
        activatableTreeView.show();
        activatableTreeView.expandAllNodes();
        activatableTreeView.node(3).walk(treeViewNode -> {
            treeViewNode.activate();
            treeViewNode.is().active();
            treeViewNode.deactivate();
            treeViewNode.is().notActive();

        });
    }


    @Test(description = "Test checks tree-view color")
    public void colorTreeViewTest() {
        colorTreeView.show();
        colorTreeView.node(1).walk(treeViewNode -> {
            if (!treeViewNode.isLeaf()) {
                TreeViewNode child = treeViewNode.first();
                child.has().color(BLACK_TRANSPARENT_087.value());
                child.activate();
                child.has().color(ORANGE_DARKEN_1.value());
            }
        });
    }

    @Test(description = "Test checks if tree-view is expanded or collapsed")
    public void expandCollapseTreeViewTest() {
        colorTreeView.show();
        colorTreeView.node(1).walk(treeViewNode -> {
            if (!treeViewNode.isLeaf()) {
                treeViewNode.close();
                treeViewNode.is().collapsed();
                treeViewNode.expand();
                treeViewNode.is().expanded();
            }
        });
    }

    @Test(description = "Test checks if tree-view has checkbox with color or not")
    public void checkboxTreeViewTest() {
        activatableTreeView.show();
        activatableTreeView.node(1).walk(treeViewNode -> treeViewNode.has().noCheckbox());
        selectableTreeView.show();
        selectableTreeView.node(1).walk(checkedTree -> {
            checkedTree.has().checkbox();
            checkedTree.check();
            waitCondition(() -> checkedTree.checkboxColor().equals(BLUE_ACCENT_1.value()));
            checkedTree.has().checkboxColor(BLUE_ACCENT_1.value());
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
        itemDisabledTreeView.node("Documents :").is().enabled();
        itemDisabledTreeView.node("Applications :").is().disabled();
        itemDisabledTreeView.node("Applications :").walk(treeViewNode -> treeViewNode.is().disabled());
        itemDisabledTreeView.node("Documents :").get("vuetify :").get("src :")
                .walk(treeViewNode -> treeViewNode.is().disabled());
        itemDisabledTreeView.node("Downloads :").nodes().forEach(node->node.is().disabled());
    }

    @Test(description = "Test checks that tree-view is loading : load children (y/n)")
    public void loadChildrenTreeViewTest() {
        loadChildrenTreeView.show();
        loadChildrenTreeView.expandAllNodes();
        waitCondition(() -> !loadChildrenTreeView.isLoading());
        loadChildrenTreeView.is().loaded();
    }

    @Test(description = "Test checks if tree-view is rounded or not")
    public void roundedTreeViewTest() {
        roundedTreeView.show();
        roundedTreeView.node(1).walk(treeViewNode -> treeViewNode.is().rounded());
        shapedTreeView.show();
        shapedTreeView.node(1).walk(treeViewNode -> treeViewNode.is().notRounded());
    }

    @Test(description = "Test checks if tree-view is shaped or not")
    public void shapedTreeViewTest() {
        shapedTreeView.show();
        shapedTreeView.node(1).walk(treeViewNode -> treeViewNode.is().shaped());
        selectableTreeView.show();
        selectableTreeView.node(1).walk(treeViewNode -> treeViewNode.is().notShaped());
    }

    @Test(description = "Test checks tree-view icons")
    public void iconsTreeViewTest() {
        appendLabelTreeView.show();
        appendLabelTreeView.node(".git").icon().has().type(FOLDER.mdi());
        appendLabelTreeView.node("node_modules").icon().has().type(FOLDER.mdi());
        appendLabelTreeView.node("public").icon().has().type(MENU_DOWN.mdi());
        appendLabelTreeView.node(".gitignore").icon().has().type(FILE_DOCUMENT_OUTLINE.mdi());
        appendLabelTreeView.node("babel.config.js").icon().has().type(NODEJS.mdi());
        appendLabelTreeView.node("package.json").icon().has().type(CODE_JSON.mdi());
        appendLabelTreeView.node("README.md").icon().has().type(LANGUAGE_MARKDOWN.mdi());
        appendLabelTreeView.node("vue.config.js").icon().has().type(NODEJS.mdi());
        appendLabelTreeView.node("yarn.lock").icon().has().type(FILE_DOCUMENT_OUTLINE.mdi());
        appendLabelTreeView.node(".git").icon().has().type(FOLDER.mdi());
    }

    @Test(description = "Test checks tree-view search and values")
    public void searchAndFilterTreeViewTest() {
        searchFilterTreeView.show();
        TreeViewNode vuetifyTree = searchFilterTreeView.node("Vuetify Human Resources");

        searchLine.text("Core team");
        vuetifyTree.get("Core team").has().values("John", "Kael", "Nekosaur", "Jacek", "Andrew");
        searchLine.clear();

        searchLine.text("K");
        vuetifyTree.has().values("Core team", "Administrators");
        vuetifyTree.get("Core team").has().values("Kael", "Nekosaur", "Jacek");
        vuetifyTree.get("Administrators").has().values("Mike");

        caseSensitiveSearchCheckbox.check();
        vuetifyTree.has().values("Core team");
        vuetifyTree.get("Core team").has().values("Kael");
        searchLine.clear();
    }

    // @todo #5298 Change test to selecct group and check internal items status on Video folder
    @Test(description = "Test checks if tree-view is marked or not",
        enabled = false)

    public void selectableIconsTreeViewTest() {
        selectableIconsTreeView.show();
        selectableIconsTreeView.node(0).walk(treeViewNode -> {
            treeViewNode.is().notMarked();
            treeViewNode.check();
            List<String> checked = new ArrayList<>();
            chips.hover();
            treeViewNode.walk(childTree -> {
                childTree.is().fullyMarked();
                if (childTree.isLeaf()) {
                    checked.add(childTree.getText());
                }
            });
            assertThat(checked, equalTo(chips.values()));
            reset.click();
        });
    }

    @Test(description = "Test checks if tree-view node is leaf or not")
    public void leafTreeViewTest() {
        selectableTreeView.node(1).walk(treeViewNode -> {
            if (!treeViewNode.isLeaf()) {
                treeViewNode.is().notLeaf();
            } else {
                treeViewNode.is().leaf();
            }
        });
    }

    @Test(description = "Test checks if tree-view node is selected or not")
    public void selectTreeViewTest() {
        selectableTreeView.node(1).walk(checkedTree -> {
            checkedTree.has().checkbox();
            checkedTree.check();
            checkedTree.is().selected();
            checkedTree.uncheck();
            checkedTree.is().notSelected();
        });
    }
}
