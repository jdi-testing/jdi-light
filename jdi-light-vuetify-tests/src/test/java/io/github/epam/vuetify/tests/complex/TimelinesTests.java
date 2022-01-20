package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLineItem;
import io.github.com.enums.Colors;
import com.epam.jdi.tools.Timer;
import io.github.com.custom.alerts.IconAlert;
import io.github.com.custom.cards.ButtonCard;
import io.github.com.custom.cards.RowsCard;
import io.github.com.custom.sections.DecadeEvent;
import io.github.com.custom.sections.ScheduledEvent;
import io.github.com.dataproviders.TimeLineDataProviders;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.PINK;
import static io.github.com.StaticSite.timelinesPage;
import static io.github.com.dataproviders.TimeLineDataProviders.LOREM_IPSUM_TEXT;
import static io.github.com.pages.TimelinesPage.advancedTimeline;
import static io.github.com.pages.TimelinesPage.colorTimeLine;
import static io.github.com.pages.TimelinesPage.defaultTimeLine;
import static io.github.com.pages.TimelinesPage.denseLoggingButton;
import static io.github.com.pages.TimelinesPage.denseTimeLine;
import static io.github.com.pages.TimelinesPage.iconDotsTimeLine;
import static io.github.com.pages.TimelinesPage.iconTimeLine;
import static io.github.com.pages.TimelinesPage.oppositeTimeLine;
import static io.github.com.pages.TimelinesPage.reverseDenseTimeLine;
import static io.github.com.pages.TimelinesPage.reverseSwitch;
import static io.github.com.pages.TimelinesPage.reverseTimeLine;
import static io.github.com.pages.TimelinesPage.smallTimeLine;

public class TimelinesTests extends TestsInit {

    @BeforeClass
    public void before() {
        timelinesPage.open();
        waitCondition(() -> timelinesPage.isOpened());
        timelinesPage.checkOpened();
    }

    @Test
    public void colorTimeLineTest() {
        colorTimeLine.has().size(4);
        colorTimeLine.is().alignTop();
        colorTimeLine.is().dense();

        colorTimeLine.item(2).body().avatars().forEach(avatar -> {
            avatar.is().displayed();
            avatar.has().size(48);
        });
        colorTimeLine.item(3).body().caption().is().notVisible();
    }


    @Test(dataProvider = "colorTimeLineData", dataProviderClass = TimeLineDataProviders.class)
    public void colorTimeLineDataTest(int index, String time, String event, String caption, Colors color) {
        TimeLineItem<ScheduledEvent, UIElement> item = colorTimeLine.item(index);
        item.body().time().has().text(time);
        item.body().event().has().text(event);
        item.has().dotColor(color);
        item.has().smallDot();
        if (caption != null) {
            item.body().caption().has().text(caption);
        }
    }

    @Test
    public void denseTimeLineTest() {
        denseTimeLine.has().size(1);
        TimeLineItem<IconAlert, UIElement> singleItem = denseTimeLine.item(1);
        singleItem.body().icon().is().type("mdi-information");
        singleItem.body().has().text(LOREM_IPSUM_TEXT);
        singleItem.body().has().css("background-color", BLUE.value());
        singleItem.has().dotColor(BLUE);
        singleItem.has().smallDot();

        denseLoggingButton.click();
        waitCondition(() -> denseTimeLine.size() == 2);
        denseLoggingButton.click();

        denseTimeLine.has().size(2);
        denseTimeLine.item(2).body().has().text(LOREM_IPSUM_TEXT);
    }

    @Test(dataProvider = "iconDotsTimeLineData", dataProviderClass = TimeLineDataProviders.class)
    public void iconDotsTimeLineTest(int index, String icon, String title, String text, Colors color) {
        TimeLineItem<ButtonCard, Icon> item = iconDotsTimeLine.item(index);
        item.has().dotColor(color);
        item.divider().has().type(icon);
        item.body().has().css("background-color", color.value());
        item.body().title().has().text(title);
        item.body().text().has().text(text);
    }

    @Test
    public void reverseTimeLinesTest() {
        reverseTimeLine.is().reversed();
        reverseDenseTimeLine.is().reversed();
        reverseDenseTimeLine.is().dense();
        reverseSwitch.is().checked();
        reverseSwitch.uncheck();
        reverseSwitch.is().unchecked();
        reverseTimeLine.is().notReversed();
        reverseDenseTimeLine.is().notReversed();
    }

    @Test(dataProvider = "smallTimeLineData", dataProviderClass = TimeLineDataProviders.class)
    public void smallTimeLineTest(int index, String title, String icon, Colors color, boolean small) {
        TimeLineItem<RowsCard, UIElement> item = smallTimeLine.item(index);
        item.has().dotColor(color);
        item.body().title().has().css("background-color", color.value());
        item.body().has().title(title);
        item.body().titleIcon().is().type(icon);
        if (small) {
            item.has().smallDot();
        }
    }

    @Test
    public void iconTimeLineTest() {
        iconTimeLine.items().forEach(item -> {
            item.opposite().has().text("Tus eu perfecto");
            item.divider().image().is().displayed();
            item.body().has().title("Lorem ipsum");
            item.body().content().has().text(LOREM_IPSUM_TEXT);
        });
    }

    @Test(dataProvider = "oppositeTimeLineData", dataProviderClass = TimeLineDataProviders.class)
    public void oppositeTimeLineTest(int index, String date, Colors color) {
        TimeLineItem<DecadeEvent, UIElement> item = oppositeTimeLine.item(index);
        item.has().dotColor(color);
        item.opposite().has().text(date);
        item.opposite().has().css("color", color.value());
    }

    @Test
    public void defaultTimeLineTest() {
        defaultTimeLine.items().forEach(item -> {
            item.has().largeDot();
            item.opposite().has().text("Tus eu perfecto");
            item.body().has().title("Lorem ipsum");
            item.body().content().has().text(LOREM_IPSUM_TEXT);
        });
    }

    @Test
    public void advancedTimeLineTest() {
        advancedTimeline.has().size(8);
        advancedTimeline.defaultItem(1).has().largeDot();
        advancedTimeline.defaultItem(1).has().dotColor(ORANGE);
        advancedTimeline.defaultItem(1).divider().has().text("JL");
        advancedTimeline.defaultItem(1).body().find("input").label().has().text("Leave a comment...");
        advancedTimeline.defaultItem(1).body().find("button").has().text("POST");
        advancedTimeline.defaultItem(1).body().find("input").sendKeys("Nice order dude!");
        advancedTimeline.defaultItem(1).body().find("button").click();
        advancedTimeline.has().size(9);

        advancedTimeline.item(2).has().smallDot();
        advancedTimeline.item(2).has().dotColor(PINK);
        advancedTimeline.item(2).body().message().has().text("Nice order dude!");

        advancedTimeline.defaultItem(3).body().has().text("TODAY");

        advancedTimeline.item(4).body().message()
                .has().text("This order was archived.");
        advancedTimeline.item(4).body().time().has().text("15:26 EDT");

        advancedTimeline.item(5).has().dotColor(BLUE_DARKEN_2);
        advancedTimeline.item(5).body().message()
                .has().text("APP\nDigital Downloads fulfilled 1 item.");
        advancedTimeline.item(5).body().time().has().text("15:25 EDT");

        advancedTimeline.item(6).body().message()
                .has().text("Order confirmation email was sent to John Leider (john@vuetifyjs.com).");
        advancedTimeline.item(6).body().time().has().text("15:25 EDT");

        advancedTimeline.defaultItem(7).body().find("button")
                .is().enabled()
                .has().text("RESEND EMAIL");

        advancedTimeline.item(8).body().message()
                .has().text("A $15.00 USD payment was processed on PayPal Express Checkout");
        advancedTimeline.item(8).body().time().has().text("15:25 EDT");

        advancedTimeline.item(9).body().message()
                .has().text("John Leider placed this order on Online Store (checkout #1937432132572).");
        advancedTimeline.item(9).body().time().has().text("15:25 EDT");

    }
}
