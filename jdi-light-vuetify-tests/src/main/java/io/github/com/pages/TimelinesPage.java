package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDITimeLine;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLine;
import io.github.com.custom.alerts.IconAlert;
import io.github.com.custom.cards.ButtonCard;
import io.github.com.custom.cards.RowsCard;
import io.github.com.custom.sections.DecadeEvent;
import io.github.com.custom.sections.OrderLine;
import io.github.com.custom.sections.ScheduledEvent;

public class TimelinesPage extends VuetifyPage {

    @JDITimeLine(root = "#ColorTimeline .v-timeline")
    public static TimeLine<ScheduledEvent, UIElement> colorTimeLine;

    @JDITimeLine(
            root = "#DenseTimeline .v-timeline",
            body = ".v-timeline-item__body .v-alert"
    )
    public static TimeLine<IconAlert, UIElement> denseTimeLine;

    @UI("#DenseTimeline button")
    public static Button denseLoggingButton;

    @JDITimeLine(
            root = "#IconDotsTimeline.v-timeline",
            body = ".v-timeline-item__body .v-card",
            divider = ".v-timeline-item__divider .v-icon"
    )
    public static TimeLine<ButtonCard, Icon> iconDotsTimeLine;

    @UI("#ReverseTimeline .v-input--switch")
    public static Switch reverseSwitch;

    @JDITimeLine(
            root = "#ReverseTimeline .v-timeline[1]",
            body = ".v-timeline-item__body .v-card"
    )
    public static TimeLine<Card, UIElement> reverseTimeLine;

    @JDITimeLine(
            root = "#ReverseTimeline .v-timeline[2]",
            body = ".v-timeline-item__body .v-card"
    )
    public static TimeLine<Card, UIElement> reverseDenseTimeLine;

    @JDITimeLine(
            root = "#SmallTimeline.v-timeline",
            body = ".v-timeline-item__body .v-card"
    )
    public static TimeLine<RowsCard, UIElement> smallTimeLine;

    @JDITimeLine(
            root = "#IconTimeline.v-timeline",
            body = ".v-timeline-item__body .v-card",
            divider = ".v-timeline-item__divider .v-avatar"
    )
    public static TimeLine<Card, Avatar> iconTimeLine;

    @JDITimeLine(
            root = "#OppositeTimeline.v-timeline",
            opposite = ".v-timeline-item__opposite span"
    )
    public static TimeLine<DecadeEvent, UIElement> oppositeTimeLine;

    @JDITimeLine(
            root = "#TimelineItemDefaultTimeline.v-timeline",
            body = ".v-timeline-item__body .v-card"
    )
    public static TimeLine<Card, UIElement> defaultTimeLine;

    @JDITimeLine(root = "#AdvancedTimeline .v-timeline")
    public static TimeLine<OrderLine, UIElement> advancedTimeline;
}
