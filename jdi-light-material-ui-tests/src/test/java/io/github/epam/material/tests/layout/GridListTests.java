package io.github.epam.material.tests.layout;

import static io.github.com.StaticSite.gridListPage;
import static io.github.com.pages.layout.GridListPage.imageGridList;
import static io.github.com.pages.layout.GridListPage.singleLineGridList;
import static io.github.com.pages.layout.GridListPage.titleBarGridList;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GridListTests extends TestsInit {

    private static final String COFFEE = "coffee";
    private static final String HATS = "hats";
    private static final String FERN = "fern";
    private static final String BIKE = "bike";
    private static final String CAMERA = "camera";

    @BeforeClass
    public static void setup() {
        gridListPage.open();
        gridListPage.isOpened();
    }

    @Test
    public static void imageGridListTest() {
        imageGridList.has().size(5);
        imageGridList.has().image(1).and().altImgName(1, COFFEE);
        imageGridList.has().image(3).and().altImgName(3, HATS);
        imageGridList.has().image(4).and().altImgName(4, BIKE);

    }

    @Test
    public static void singleLineGridTest() {
        singleLineGridList.has().size(5);
        singleLineGridList.has().image(3).and().altImgName(3, HATS);
        singleLineGridList.has().image(4).and().altImgName(4, BIKE);
        singleLineGridList.has().title(5, CAMERA);
    }

    @Test
    public static void titleBarGridList() {
        titleBarGridList.has().size(6);
        titleBarGridList.get(1).has().text("December");
        titleBarGridList.has().image(2).and().altImgName(2, COFFEE);
        titleBarGridList.has().image(3).and().altImgName(3, FERN);
        titleBarGridList.has().image(6).and().altImgName(6, CAMERA);
    }
}
