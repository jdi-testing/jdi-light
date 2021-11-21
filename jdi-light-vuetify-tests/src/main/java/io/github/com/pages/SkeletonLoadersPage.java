package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.SkeletonLoader;

public class SkeletonLoadersPage extends VuetifyPage {

    @UI("#BoilerplateComponentSkeletonLoader > div > div:nth-child(1) > div:nth-child(1)")
    public static SkeletonLoader imageAvatarArticleActionsSkeletonLoader;

    @UI("#BoilerplateComponentSkeletonLoader > div > div:nth-child(1) > div:nth-child(2)")
    public static SkeletonLoader datePickerSkeletonLoader;

    @UI("#BoilerplateComponentSkeletonLoader > div > div:nth-child(2) > div:nth-child(1)")
    public static SkeletonLoader articleActionsSkeletonLoader;

    @UI("#BoilerplateComponentSkeletonLoader > div > div:nth-child(2) > div:nth-child(2)")
    public static SkeletonLoader tableImageSkeletonLoader;

    @UI("#BoilerplateComponentSkeletonLoader > div > div:nth-child(3) > div:nth-child(1)")
    public static SkeletonLoader avatarTextImageActionsSkeletonLoader;

    @UI("#BoilerplateComponentSkeletonLoader > div > div:nth-child(3) > div:nth-child(2)")
    public static SkeletonLoader avatarTextImageArticleSkeletonLoader;
}
