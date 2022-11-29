package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.skeletonLoadersPage;
import static io.github.com.pages.SkeletonLoadersPage.avatarTextImageActionsSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.avatarTextImageArticleSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.darkSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.datePickerSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.imageAvatarArticleActionsSkeletonLoader;

public class SkeletonLoadersTests extends TestsInit {
    @BeforeClass
    public void before() {
        skeletonLoadersPage.open();
        waitCondition(() -> skeletonLoadersPage.isOpened());
        skeletonLoadersPage.checkOpened();
    }

    @Test(description = "Test checks that skeleton loader components are displayed")
    public void displayedSkeletonLoaderTest() {
        imageAvatarArticleActionsSkeletonLoader.show();
        imageAvatarArticleActionsSkeletonLoader.is().displayed();
        imageAvatarArticleActionsSkeletonLoader.image().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.avatar().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.text().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.article().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.heading().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.paragraph().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.actions().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.button().is().displayed();
        datePickerSkeletonLoader.show();
        datePickerSkeletonLoader.text().is().displayed();
        datePickerSkeletonLoader.divider().is().displayed();
    }

    @Test(description = "Test checks that skeleton loader has light or dark theme : theme - dark")
    public void themeSkeletonLoaderTest() {
        avatarTextImageArticleSkeletonLoader.show();
        avatarTextImageActionsSkeletonLoader.has().lightTheme();
        darkSkeletonLoader.show();
        darkSkeletonLoader.has().darkTheme();
    }

    @Test(description = "Test checks that skeleton loader is boilerplate or animated : animation - on")
    public void boilerplateSkeletonLoaderTest() {
        avatarTextImageArticleSkeletonLoader.show();
        avatarTextImageActionsSkeletonLoader.is().boilerplate();
        darkSkeletonLoader.show();
        darkSkeletonLoader.is().notBoilerplate();
    }

    @Test(description = "Test checks skeleton loader's height and width : min/max/fixed width/height")
    public void heightWidthSkeletonLoaderTest() {
        darkSkeletonLoader.show();
        darkSkeletonLoader.has().height(250);
        darkSkeletonLoader.has().maxHeight(500);
        darkSkeletonLoader.has().maxWidth(300);
    }

    @Test(description = "Test checks skeleton loader's elevation :  elevation")
    public void elevationSkeletonLoaderTest() {
        darkSkeletonLoader.show();
        darkSkeletonLoader.is().elevated();
        darkSkeletonLoader.has().elevation(4);
        avatarTextImageActionsSkeletonLoader.show();
        avatarTextImageActionsSkeletonLoader.is().notElevated();
    }

    @Test(description = "Test checks if skeleton loader is tile or not :  tile - on")
    public void tileSkeletonLoaderTest() {
        darkSkeletonLoader.show();
        darkSkeletonLoader.is().tile();
        avatarTextImageActionsSkeletonLoader.show();
        avatarTextImageActionsSkeletonLoader.is().notTile();
    }

    @Test(description = "Test checks cursor type : loading cursor - on")
    public void loadingCursorSkeletonLoaderTest() {
        darkSkeletonLoader.show();
        darkSkeletonLoader.has().cursorTypeProgress();
        darkSkeletonLoader.has().cursorType("progress");
        avatarTextImageActionsSkeletonLoader.show();
        avatarTextImageActionsSkeletonLoader.has().cursorTypeAuto();
        avatarTextImageActionsSkeletonLoader.has().cursorType("auto");
    }
}
