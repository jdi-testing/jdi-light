package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.iconsPage;
import static io.github.com.pages.displaydata.IconsPage.colorIcons;
import static io.github.com.pages.displaydata.IconsPage.differentSizesIcons;
import static io.github.com.pages.displaydata.IconsPage.simpleIcons;
import static io.github.com.pages.displaydata.IconsPage.simpleLastClick;
import static io.github.com.pages.displaydata.IconsPage.simpleLastHover;


public class IconsTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        iconsPage.open();
    }

    @Test
    public void validationTest() {
        simpleIcons.forEach(el -> el.is().displayed());
        simpleIcons.forEach(el -> el.is().enabled());
        simpleIcons.forEach(el -> el.is().attr("focusable", "false"));
        jdiAssert(simpleIcons.size(), Matchers.is(13));

        colorIcons.forEach(el -> el.is().displayed());
        colorIcons.forEach(el -> el.is().enabled());
        colorIcons.forEach(el -> el.is().attr("focusable", "false"));
        jdiAssert(colorIcons.size(), Matchers.is(6));

        differentSizesIcons.forEach(el -> el.is().displayed());
        differentSizesIcons.forEach(el -> el.is().enabled());
        differentSizesIcons.forEach(el -> el.is().attr("focusable", "false"));
        jdiAssert(differentSizesIcons.size(), Matchers.is(4));
    }

    @Test
    public void simpleIconsTest() {
        simpleIcons.get(1).hover();
        simpleLastHover.has().text("Last hover: DeleteIcon");
        simpleIcons.get(2).click();
        simpleLastClick.has().text("Last click: DeleteForeverIcon");

        simpleIcons.forEach(icon -> icon.is().notColored());
        simpleIcons.forEach(icon -> icon.has().color("rgba(0, 0, 0, 0.87)"));
        simpleIcons.forEach(icon -> icon.has().height(24));
        simpleIcons.forEach(icon -> icon.has().width(24));
    }

    @Test
    public void colorIconsTest() {
        colorIcons.get(1).is().notColored();
        colorIcons.get(2).has().color("rgba(63, 81, 181, 1)");
        colorIcons.get(3).has().color("rgba(245, 0, 87, 1)");
        colorIcons.get(4).has().color("rgba(0, 0, 0, 0.54)");
        colorIcons.get(5).has().color("rgba(0, 0, 0, 0.26)");
        colorIcons.get(6).has().color("rgba(76, 175, 80, 1)");
    }

    @Test
    public void differentSizesIconsTest() {
        differentSizesIcons.get(1).has().height(20).and().width(20);
        differentSizesIcons.get(2).has().height(24).and().width(24);
        differentSizesIcons.get(3).has().height(35).and().width(35);
        differentSizesIcons.get(4).has().height(40).and().width(40);
    }
}
