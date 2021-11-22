package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.skeletonLoadersPage;
import static io.github.com.pages.SkeletonLoadersPage.articleActionsSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.avatarTextImageActionsSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.avatarTextImageArticleSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.datePickerSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.imageAvatarArticleActionsSkeletonLoader;
import static io.github.com.pages.SkeletonLoadersPage.tableImageSkeletonLoader;

public class SkeletonLoadersTests extends TestsInit {
    @BeforeClass
    public void before() {
        skeletonLoadersPage.open();
        skeletonLoadersPage.checkOpened();
    }

    @Test
    public void imageAvatarArticleActionsSkeletonLoaderTest() {
        imageAvatarArticleActionsSkeletonLoader.is().displayed();
        imageAvatarArticleActionsSkeletonLoader.imageBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.avatarBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.textBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.articleBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.headingBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.paragraphBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.actionsBoilerplate().is().displayed();
        imageAvatarArticleActionsSkeletonLoader.buttonBoilerplate().is().displayed();
    }

    @Test
    public void datePickerSkeletonLoaderTest() {
        datePickerSkeletonLoader.is().displayed();
        datePickerSkeletonLoader.textBoilerplate().is().displayed();
        datePickerSkeletonLoader.headingBoilerplate().is().displayed();
        datePickerSkeletonLoader.dividerBoilerplate().is().displayed();
        datePickerSkeletonLoader.avatarBoilerplate().is().displayed();
        datePickerSkeletonLoader.actionsBoilerplate().is().displayed();
        datePickerSkeletonLoader.buttonBoilerplate().is().displayed();
    }

    @Test
    public void articleActionsSkeletonLoaderTest() {
        articleActionsSkeletonLoader.is().displayed();
        articleActionsSkeletonLoader.articleBoilerplate().is().displayed();
        articleActionsSkeletonLoader.headingBoilerplate().is().displayed();
        articleActionsSkeletonLoader.paragraphBoilerplate().is().displayed();
        articleActionsSkeletonLoader.textBoilerplate().is().displayed();
        articleActionsSkeletonLoader.actionsBoilerplate().is().displayed();
        articleActionsSkeletonLoader.buttonBoilerplate().is().displayed();
    }

    @Test
    public void tableImageSkeletonLoaderTest() {
        tableImageSkeletonLoader.is().displayed();
        tableImageSkeletonLoader.headingBoilerplate().is().displayed();
        tableImageSkeletonLoader.textBoilerplate().is().displayed();
        tableImageSkeletonLoader.imageBoilerplate().is().displayed();
        tableImageSkeletonLoader.avatarBoilerplate().is().displayed();
    }

    @Test
    public void avatarTextImageActionsSkeletonLoaderTest() {
        avatarTextImageActionsSkeletonLoader.is().displayed();
        avatarTextImageActionsSkeletonLoader.avatarBoilerplate().is().displayed();
        avatarTextImageActionsSkeletonLoader.textBoilerplate().is().displayed();
        avatarTextImageActionsSkeletonLoader.dividerBoilerplate().is().displayed();
        avatarTextImageActionsSkeletonLoader.paragraphBoilerplate().is().displayed();
        avatarTextImageActionsSkeletonLoader.headingBoilerplate().is().displayed();
        avatarTextImageActionsSkeletonLoader.imageBoilerplate().is().displayed();
        avatarTextImageActionsSkeletonLoader.actionsBoilerplate().is().displayed();
    }

    @Test
    public void avatarTextImageArticleSkeletonLoaderTest() {
        avatarTextImageArticleSkeletonLoader.is().displayed();
        avatarTextImageArticleSkeletonLoader.avatarBoilerplate().is().displayed();
        avatarTextImageArticleSkeletonLoader.paragraphBoilerplate().is().displayed();
        avatarTextImageArticleSkeletonLoader.imageBoilerplate().is().displayed();
        avatarTextImageArticleSkeletonLoader.articleBoilerplate().is().displayed();
    }
}
