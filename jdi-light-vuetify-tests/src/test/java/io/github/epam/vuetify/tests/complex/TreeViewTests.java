package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import io.github.com.custom.treeview.CheckedNode;
import io.github.com.custom.treeview.SimpleNode;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.treeviewPage;
import static io.github.com.pages.TreeviewPage.*;
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

        TreeView<SimpleNode> app = activatableTreeView.nodes().get(0);
        app.children().has().size(3);
        app.root().text.has().text("Applications :");
        app.nodes().get(0).root().text.has().text("Calendar : app");
        app.nodes().get(1).root().text.has().text("Chrome : app");
        app.nodes().get(2).root().text.has().text("Webstorm : app");

        TreeView<SimpleNode> doc = activatableTreeView.nodes().get(1);
        doc.root().text.has().text("Documents :");
        doc.children().has().size(2);
        doc.nodes().get(0).root().text.has().text("vuetify :");
        doc.nodes().get(1).root().text.has().text("material2 :");

        TreeView<SimpleNode> vue = doc.nodes().get(0);
        vue.children().has().size(1);
        vue.nodes().get(0).root().text.has().text("src :");

        TreeView<SimpleNode> mat = doc.nodes().get(1);
        mat.children().has().size(1);
        mat.nodes().get(0).root().text.has().text("src :");

        TreeView<SimpleNode> videos = activatableTreeView.nodes().get(3);
        videos.children().has().size(3);
        videos.root().text.has().text("Videos :");
        videos.nodes().get(0).root().text.has().text("Tutorials :");
        videos.nodes().get(1).root().text.has().text("Intro : mov");
        assertThat(videos.nodes().get(1).isLeaf(), is(true));
        videos.nodes().get(2).root().text.has().text("Conference introduction : avi");
        assertThat(videos.nodes().get(2).isLeaf(), is(true));
    }

    @Test
    public void selectableTreViewTest() {
        assertThat(selectableTreeView.isPseudoRoot(), is(true));
        TreeView<CheckedNode> app = selectableTreeView.nodes().get(0);
        app.nodes().get(0).root().checkbox.has().classValue(containsString("mdi-checkbox-blank-outline"));
        app.nodes().get(0).root().checkbox.check();
        app.nodes().get(0).root().checkbox.has().classValue(containsString("mdi-checkbox-marked"));
        app.root().checkbox.has().classValue(containsString("mdi-minus-box"));
    }
}
