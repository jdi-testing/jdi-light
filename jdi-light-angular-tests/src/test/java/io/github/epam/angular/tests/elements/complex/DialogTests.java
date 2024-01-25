package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.DialogPosition.CENTER;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.checkBoxPage;
import static io.github.com.StaticSite.dialogPage;
import static io.github.com.pages.DialogPage.alignAction;
import static io.github.com.pages.DialogPage.customizableDialog;
import static io.github.com.pages.DialogPage.dialogActionButton;
import static io.github.com.pages.DialogPage.dialogOverviewButton;
import static io.github.com.pages.DialogPage.minHeightAutocomplete;
import static io.github.com.pages.DialogPage.minWidthAutocomplete;
import static io.github.com.pages.DialogPage.nameDialog;
import static io.github.com.pages.DialogPage.nameFormFields;
import static io.github.com.pages.DialogPage.withAnimationButton;
import static io.github.com.pages.DialogPage.withAnimationDialog;
import static io.github.com.pages.DialogPage.withoutAnimationButton;
import static io.github.com.pages.DialogPage.withoutAnimationDialog;
import static io.github.com.pages.DialogPage.youChooseText;

public class DialogTests extends TestsInit {

    @BeforeClass(alwaysRun = true)
    public void before() {
        dialogPage.open();
        waitCondition((() -> checkBoxPage.isOpened()));
        dialogPage.checkOpened();
    }

    @Test(description = "Test checks opening and closing a dialog")
    public void baseTest() {
        nameFormFields.input("EPAM Systems");
        dialogOverviewButton.click();
        nameDialog.is().opened();
        nameDialog.close();
        nameDialog.is().closed();
    }


    @Test(description = "Test checks opening and closing a dialog")
    public void dialogOverviewTest() {
        nameFormFields.input("EPAM Systems");
        dialogOverviewButton.click();
        nameDialog.is().opened();
        nameDialog.inputField().input("Lion");
        nameDialog.okButton().click();
        nameDialog.is().closed();
        youChooseText.is().text("You choose: Lion");
    }

    @Test(description = "Test checks the dialog animation")
    public void animationTest() {
        withoutAnimationButton.click();
        withoutAnimationDialog.is().opened();
        withoutAnimationDialog.has().animationDuration("0ms");
        withoutAnimationDialog.close();

        withAnimationButton.click();
        withAnimationDialog.is().opened();
        withAnimationDialog.has().animationDuration("3000ms");
        withAnimationDialog.close();
    }

    @Test(description = "Test checks the align of action buttons")
    public void actionAlignTest() {
        alignAction.select("Center");
        dialogActionButton.click();
        customizableDialog.is().opened();
        customizableDialog.has().position(CENTER);
        customizableDialog.close();
    }

    @Test(description = "Test checks the height and width")
    public void sizeTest() {
        minHeightAutocomplete.select("500px");
        minWidthAutocomplete.select("500px");
        dialogActionButton.click();
        customizableDialog.is().opened();
        customizableDialog.has().maxHeight("1000px");
        customizableDialog.has().minHeight("500px");
        customizableDialog.has().maxWidth("1000px");
        customizableDialog.has().minWidth("500px");
        customizableDialog.close();
    }

}
