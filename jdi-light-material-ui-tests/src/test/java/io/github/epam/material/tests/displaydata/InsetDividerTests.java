package io.github.epam.material.tests.displaydata;

import io.github.com.custom.elements.MUIContainerListItem;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.insetDividerPage;
import static io.github.com.pages.displaydata.InsetDividerPage.insetDividers;
import static io.github.com.pages.displaydata.InsetDividerPage.itemList;

public class InsetDividerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        insetDividerPage.open();
        insetDividerPage.isOpened();
    }

    @Test
    public void insetDividerTest() {
        itemList.has().size(3);
        MUIContainerListItem item = itemList.item("Photos").with(MUIContainerListItem.class);
        item.asText().has().text(Matchers.containsString("Jan 9, 2014"));

        jdiAssert(insetDividers, Matchers.hasSize(2));
        insetDividers.forEach(divider -> divider.is().inset());
    }
}
