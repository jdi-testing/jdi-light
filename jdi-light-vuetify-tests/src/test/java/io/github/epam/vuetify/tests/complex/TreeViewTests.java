package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import io.github.com.custom.treeview.CheckedNode;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.activatableTreeView;
import static io.github.com.pages.TreeviewPage.selectableTreeView;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class TreeViewTests extends TestsInit {

    @BeforeClass
    public void before() {
        treeviewPage.open();
        treeviewPage.checkOpened();
    }

    @Test
    public void activatableTreeViewTest() {
        assertThat(activatableTreeView.isPseudoRoot(), is(true));
        activatableTreeView.children().has().size(4);

        TreeView<UIElement> app = activatableTreeView.getNode(1);
        app.children().has().size(3);
        app.root().has().text("Applications :");
        app.getRoot(1).has().text("Calendar : app");
        app.getRoot(2).has().text("Chrome : app");
        app.getRoot(3).has().text("Webstorm : app");

        TreeView<UIElement> doc = activatableTreeView.getNode(2);
        doc.root().has().text("Documents :");
        doc.children().has().size(2);
        doc.getRoot(1).has().text("vuetify :");
        doc.getRoot(2).has().text("material2 :");

        TreeView<UIElement> vue = doc.getNode(1);
        vue.children().has().size(1);
        vue.getRoot(1).has().text("src :");

        TreeView<UIElement> mat = doc.getNode(1);
        mat.children().has().size(1);
        mat.getRoot(1).has().text("src :");

        TreeView<UIElement> videos = activatableTreeView.getNode(4);
        videos.children().has().size(3);

        videos.root().has().text("Videos :");
        videos.getRoot(1).has().text("Tutorials :");
        videos.getRoot(2).has().text("Intro : mov");
        assertThat(videos.getNode(2).isLeaf(), is(true));
        videos.getRoot(3).has().text("Conference introduction : avi");
        assertThat(videos.getNode(3).isLeaf(), is(true));
    }

    @Test
    public void selectableTreViewTest() {
        assertThat(selectableTreeView.isPseudoRoot(), is(true));
        TreeView<CheckedNode> app = selectableTreeView.getNode(1);
        app.getNode(1).root().checkbox.has().classValue(containsString("mdi-checkbox-blank-outline"));
        app.getNode(1).root().checkbox.check();
        app.getNode(1).root().checkbox.has().classValue(containsString("mdi-checkbox-marked"));
        app.root().checkbox.has().classValue(containsString("mdi-minus-box"));
    }
}
