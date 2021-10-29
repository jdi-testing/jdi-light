package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLineItem;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import com.epam.jdi.tools.Timer;
import io.github.com.custom.alerts.IconAlert;
import io.github.com.custom.cards.ButtonCard;
import io.github.com.custom.cards.RowsCard;
import io.github.com.custom.sections.DecadeEvent;
import io.github.com.custom.sections.ScheduledEvent;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.AMBER;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.AMBER_LIGHTEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.CYAN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.CYAN_LIGHTEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN_LIGHTEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.INDIGO;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PINK;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE_DARKEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.TEAL_LIGHTEN_3;
import static io.github.com.StaticSite.timelinesPage;
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
import static org.hamcrest.Matchers.containsString;

public class TimelinesTests extends TestsInit {

    private static String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, no " +
            "nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire " +
            "principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, " +
            "vix an salutandi sententiae.";

    @DataProvider
    public static Object[][] iconDotsTimeLineData() {
        return new Object[][]{
                {1, "mdi-star", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, RED_LIGHTEN_2},
                {2, "mdi-book-variant", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, PURPLE_DARKEN_1},
                {3, "mdi-airballoon", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, GREEN_LIGHTEN_1},
                {4, "mdi-buffer", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, INDIGO}
        };
    }

    @BeforeClass
    public void before() {
        timelinesPage.open();
        timelinesPage.checkOpened();
    }

    @Test
    public void colorTimeLineTest() {
        colorTimeLine.has().size(4);
        colorTimeLine.is().alignTop();
        colorTimeLine.is().dense();

        colorTimeLine.item(2).body().avatars().forEach(avatar -> {
            avatar.is().displayed();
            avatar.has().size("48");
        });
        colorTimeLine.item(3).body().caption().is().notVisible();
    }

    @DataProvider
    public static Object[][] colorTimeLineData() {
        return new Object[][]{
                {1, "5pm", "New Icon", "Mobile App", PINK},
                {2, "3-4pm", "Design Stand Up", "Hangouts", TEAL_LIGHTEN_3},
                {3, "12pm", "Lunch break", null, PINK},
                {4, "9-11am", "Finish Home Screen", "Web App", TEAL_LIGHTEN_3}
        };
    }

    @Test(dataProvider = "colorTimeLineData")
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
        singleItem.body().icon().has().classValue(containsString("mdi-information"));
        singleItem.body().has().text(LOREM_IPSUM_TEXT);
        singleItem.body().has().css("background-color", BLUE.value());
        singleItem.has().dotColor(BLUE);
        singleItem.has().smallDot();

        denseLoggingButton.click();
        Timer.waitCondition(() -> denseTimeLine.size() == 2);
        denseLoggingButton.click();

        denseTimeLine.has().size(2);
        denseTimeLine.item(2).body().has().text(LOREM_IPSUM_TEXT);
    }

    @Test(dataProvider = "iconDotsTimeLineData")
    public void iconDotsTimeLineTest(int index, String icon, String title, String text, Colors color) {
        TimeLineItem<ButtonCard, Icon> item = iconDotsTimeLine.item(index);
        item.has().dotColor(color);
        item.divider().has().classValue(containsString(icon));
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

    @DataProvider
    public static Object[][] smallTimeLineData() {
        return new Object[][]{
                {1, "Title 1", "mdi-magnify", PURPLE_LIGHTEN_2, false},
                {2, "Title 2", "mdi-home-outline", AMBER_LIGHTEN_1, true},
                {3, "Title 3", "mdi-email-outline", CYAN_LIGHTEN_1, false},
                {4, "Title 4", "mdi-account-multiple-outline", RED_LIGHTEN_1, true},
                {5, "Title 5", "mdi-phone-in-talk", GREEN_LIGHTEN_1, false}
        };
    }

    @Test(dataProvider = "smallTimeLineData")
    public void smallTimeLineTest(int index, String title, String icon, Colors color, boolean small) {
        TimeLineItem<RowsCard, UIElement> item = smallTimeLine.item(index);
        item.has().dotColor(color);
        item.body().title().has().css("background-color", color.value());
        item.body().has().title(title);
        item.body().titleIcon().has().classValue(containsString(icon));
        if (small) {
            item.has().smallDot();
        }
    }

    @Test
    public void iconTimeLineTest() {
        iconTimeLine.items().forEach(item -> {
            item.opposite().has().text("Tus eu perfecto");
            item.divider().has().photo();
            item.body().has().title("Lorem ipsum");
            item.body().content().has().text(LOREM_IPSUM_TEXT);
        });
    }

    @DataProvider
    public static Object[][] oppositeTimeLineData() {
        return new Object[][]{
                {1, "1960", CYAN},
                {2, "1970", GREEN},
                {3, "1980", PINK},
                {4, "1990", AMBER},
                {5, "2000", ORANGE}
        };
    }

    @Test(dataProvider = "oppositeTimeLineData")
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
    }
}
