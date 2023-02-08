package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.overflowButtonsPage;
import static io.github.com.pages.OverflowButtonsPage.counterOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.denseOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.disabledOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.editableOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.filledOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.flatOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.hintOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.loadingOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.menuPropsOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.outlinedOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.readonlyOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.reversedOverflowButton;
import static io.github.com.pages.OverflowButtonsPage.segmentedOverflowButton;

public class OverflowButtonsTests extends TestsInit {

    @BeforeClass
    public void before() {
        overflowButtonsPage.open();
        waitCondition(() -> overflowButtonsPage.isOpened());
        overflowButtonsPage.checkOpened();
    }

    @Test(description = "Test checks if overflow button is expanded or not")
    public void closeExpandOverflowButtonTest() {
        counterOverflowButton.show();
        counterOverflowButton.has().placeholder("Overflow Btn w/ counter");
        counterOverflowButton.expand();
        counterOverflowButton.is().expanded();
        counterOverflowButton.close();
        counterOverflowButton.is().closed();
        counterOverflowButton.select("50%");
        counterOverflowButton.is().selected("50%").and().counter(3);
        counterOverflowButton.select(1);
        counterOverflowButton.is().selected("100%");
        counterOverflowButton.select(5);
        counterOverflowButton.is().counter(2);
    }

    @Test(description = "Test checks if element is disabled or not")
    public void disabledOverflowButton() {
        disabledOverflowButton.show();
        disabledOverflowButton.is().disabled();
        counterOverflowButton.show();
        counterOverflowButton.is().enabled();
    }

    @Test
    public void editableOverflowButton() {
        editableOverflowButton.show();
        editableOverflowButton.is().editable();
        editableOverflowButton.sendText("1");
        editableOverflowButton.dropDownList().get(1).is().text("100%");
        editableOverflowButton.clear();
        editableOverflowButton.sendText("7");
        editableOverflowButton.dropDownList().get(1).is().text("75%");
        filledOverflowButton.show();
        filledOverflowButton.is().notEditable();
    }

    @Test(description = "Test checks overflow button message")
    public void messagesOverflowButton() {
        hintOverflowButton.has().messagesCount(0);
        hintOverflowButton.expand();
        hintOverflowButton.has().messageText("Select font");
        outlinedOverflowButton.has().successMessages();
        outlinedOverflowButton.has().successMessagesCount(1);
        outlinedOverflowButton.has().successMessage("Success message");
    }

    @Test(description = "Test checks if overflow button is loading or not")
    public void loadingOverflowButton() {
        loadingOverflowButton.show();
        loadingOverflowButton.is().loading();
        loadingOverflowButton.has().hasLoader();
        loadingOverflowButton.loader().has().height(2);
        menuPropsOverflowButton.show();
        menuPropsOverflowButton.is().loaded();
    }

    @Test(description = "Test checks if overflow button is readonly or not")
    public void readonlyOverflowButton() {
        readonlyOverflowButton.show();
        readonlyOverflowButton.is().readonly();
        segmentedOverflowButton.show();
        segmentedOverflowButton.is().notReadonly();
    }

    @Test(description = "Test checks if overflow button is dense or not")
    public void denseOverflowButton() {
        denseOverflowButton.show();
        denseOverflowButton.is().dense();
        denseOverflowButton.has().notCounter();
        disabledOverflowButton.show();
        disabledOverflowButton.is().notDense();
    }

    @Test(description = "Test checks if overflow button is filled or not")
    public void filledOverflowButton() {
        filledOverflowButton.show();
        filledOverflowButton.is().filled();
        hintOverflowButton.show();
        hintOverflowButton.is().notFilled();
    }

    @Test(description = "Test checks if overflow button is segmented or not")
    public void segmentedOverflowButton() {
        segmentedOverflowButton.show();
        segmentedOverflowButton.is().segmented();
        reversedOverflowButton.show();
        reversedOverflowButton.is().notSegmented();
    }

    @Test(description = "Test checks if overflow button is reversed or not")
    public void reversedOverflowButton() {
        reversedOverflowButton.show();
        reversedOverflowButton.is().reversed();
        flatOverflowButton.show();
        flatOverflowButton.is().notReversed();
    }

    @Test(description = "Test checks if overflow button is rounded or not")
    public void roundedOverflowButton() {
        reversedOverflowButton.show();
        reversedOverflowButton.is().rounded();
        flatOverflowButton.show();
        flatOverflowButton.is().notRounded();
    }

    @Test(description = "Test checks if overflow button is flat or not")
    public void flatOverflowButton() {
        flatOverflowButton.show();
        flatOverflowButton.is().flat();
        outlinedOverflowButton.show();
        outlinedOverflowButton.is().notFlat();
    }

    @Test(description = "Test checks if overflow button is outlined or not")
    public void outlinedOverflowButton() {
        outlinedOverflowButton.show();
        outlinedOverflowButton.is().outlined();
        flatOverflowButton.show();
        flatOverflowButton.is().notOutlined();
    }

    @Test(description = "Test checks if overflow button is shaped or not")
    public void shapedOverflowButton() {
        outlinedOverflowButton.show();
        outlinedOverflowButton.is().shaped();
        flatOverflowButton.show();
        flatOverflowButton.is().notShaped();
    }

    @Test(description = "Test checks overflow button's theme")
    public void themeOverflowButton() {
        outlinedOverflowButton.show();
        outlinedOverflowButton.has().darkTheme();
        flatOverflowButton.show();
        flatOverflowButton.has().lightTheme();
    }

    @Test(description = "Test checks if overflow button is single-line")
    public void singleLineOverflowButton() {
        outlinedOverflowButton.show();
        outlinedOverflowButton.is().singleLine();
    }

    @Test(description = "Test checks overflow button's chips")
    public void chipsOverflowButton() {
        flatOverflowButton.show();
        flatOverflowButton.has().chips();
        flatOverflowButton.has().smallChips();
        flatOverflowButton.select(1);
        flatOverflowButton.selectedChips().get(0).is().removable();
        outlinedOverflowButton.show();
        outlinedOverflowButton.has().noChips();
        outlinedOverflowButton.has().noSmallChips();
    }

    @Test(description = "Test checks if overflow button is full-width or not")
    public void fullWidthOverflowButton() {
        outlinedOverflowButton.show();
        outlinedOverflowButton.is().fullWidth();
        flatOverflowButton.show();
        flatOverflowButton.is().notFullWidth();
    }
}
