package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.angular.elements.enums.AngularColors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.LIGHT_GREEN_2;
import static io.github.com.enums.Colors.LIGHT_LILAC;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridListPage;

import static io.github.com.enums.Colors.LIGHT_PINK;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.enums.Colors.WHITE_TRANSPARENT_038;
import static io.github.com.pages.GridListPage.dynamicGridList;
import static io.github.com.pages.GridListPage.tileWithImage;

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
            .and().notEmpty()
            .and().size(4)
            .and().each(e -> e.isVisible())
            .and().noOne(e -> e.text().equals("Zero"))
            .and().onlyOne(e -> e.text().equals("One"))
            .and().any(e -> e.rowspan() == 1);

        dynamicGridList.tiles().forEach(e -> e.is().visible());

        dynamicGridList.tileByIndex(1)
            .has().text("One")
            .and().colspan(3)
            .and().rowspan(1);

        dynamicGridList.tileByIndex(2)
            .is().color(AngularColors.fromColor(LIGHT_GREEN_2.value()))
            .and().colspan(1)
            .and().rowspan(2);

         tileWithImage.image.is()
            .attr("src","https://material.angular.io/assets/img/examples/shiba2.jpg");

        dynamicGridList.tileByIndex(3)
            .is().colspan(1)
            .and().rowspan(1)
            .and().backgroundColor(LIGHT_PINK.value())
            .and().backgroundColor(AngularColors.fromColor(LIGHT_PINK.value()))
            .and().color(BLACK_TRANSPARENT_087.value())
            .and().color(AngularColors.fromColor(BLACK_TRANSPARENT_087.value()))
            .and().footerColor(AngularColors.fromColor(WHITE.value()))
            .and().footerBackgroundColor(WHITE_TRANSPARENT_038.value())
            .and().headerColor(WHITE.value())
            .and().headerBackgroundColor(AngularColors.fromColor(WHITE_TRANSPARENT_038.value()))
            .and().text("Mat Grid Header\nThree\nMat Grid Footer")
            .and().footerText("Mat Grid Footer")
            .and().headerText("Mat Grid Header");

        dynamicGridList.tileByIndex(4)
        .is().text("Four")
            .and().color(AngularColors.fromColor(LIGHT_LILAC.value()))
            .and().colspan(2);
    }
}
