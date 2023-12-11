package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.angular.elements.enums.AngularColors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.enums.Colors.LIGHT_GREEN_2;
import static io.github.com.enums.Colors.LIGHT_LILAC;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridListPage;

import static io.github.com.enums.Colors.LIGHT_PINK;
import static io.github.com.enums.Colors.WHITE_TRANSPARENT_038;
import static io.github.com.pages.GridListPage.dynamicGridList;

public class GridListTests extends TestsInit {

    @BeforeClass
    public void before() {
        gridListPage.open();
        waitCondition(() -> gridListPage.isOpened());
        gridListPage.checkOpened();
    }

    @Test(description = "Test checks dynamic grid list attributes")
    public void dynamicGridListTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();

        dynamicGridList.has().cols(4)
                .and().rowHeight("100px")
                .and().gutterSize("10px")

                .and().cellText(1, "One")
                .and().cellText(4, "Four")

                .and().cellColor(2, AngularColors.fromColor(LIGHT_GREEN_2.value()))
                .and().cellColor(4, AngularColors.fromColor(LIGHT_LILAC.value()))

                .and().cellColspan(1, 3)
                .and().cellColspan(2, 1)
                .and().cellColspan(4, 2)

                .and().cellRowspan(1, 1)
                .and().cellRowspan(2, 2)

                .and().cellHasAvatar(2)
                .and().cellAvatarUrl(2,"https://material.angular.io/assets/img/examples/shiba2.jpg");;

        dynamicGridList.cellByIndex(3)
                .is().colspan(1)
                .and().rowspan(1)
                .and().color(AngularColors.fromColor(LIGHT_PINK.value()))
                .and().footerColor(AngularColors.fromColor(WHITE_TRANSPARENT_038.value()))
                .and().headerColor(AngularColors.fromColor(WHITE_TRANSPARENT_038.value()))
                .and().cellText("Three")
                .and().footerText("Mat Grid Footer")
                .and().headerText("Mat Grid Header");
    }
}
