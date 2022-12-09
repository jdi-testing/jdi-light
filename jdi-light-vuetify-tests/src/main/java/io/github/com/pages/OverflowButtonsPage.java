package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;

public class OverflowButtonsPage extends VuetifyPage {
    @UI("#CounterOverflowButton .v-overflow-btn")
    public static OverflowButton counterOverflowButton;

    @UI("#DenseOverflowButton .v-overflow-btn")
    public static OverflowButton denseOverflowButton;

    @UI("#DisabledOverflowButton .v-overflow-btn")
    public static OverflowButton disabledOverflowButton;

    @UI("#EditableOverflowButton .v-overflow-btn")
    public static OverflowButton editableOverflowButton;

    @UI("#FilledOverflowButton .v-overflow-btn")
    public static OverflowButton filledOverflowButton;

    @UI("#HintOverflowButton .v-overflow-btn")
    public static OverflowButton hintOverflowButton;

    @UI("#LoadingOverflowButton .v-overflow-btn")
    public static OverflowButton loadingOverflowButton;

    @UI("#MenuPropsOverflowButton .v-overflow-btn")
    public static OverflowButton menuPropsOverflowButton;

    @UI("#ReadonlyOverflowButton .v-overflow-btn")
    public static OverflowButton readonlyOverflowButton;

    @UI("#SegmentedOverflowButton .v-overflow-btn")
    public static OverflowButton segmentedOverflowButton;

    @UI("#ReversedOverflowButton .v-overflow-btn")
    public static OverflowButton reversedOverflowButton;

    @UI("#WithChipsOverflowButton .v-overflow-btn")
    public static OverflowButton flatOverflowButton;

    @UI("#OutlinedOverflowButton .v-overflow-btn")
    public static OverflowButton outlinedOverflowButton;
}
