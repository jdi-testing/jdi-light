package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.buttonGroupsPage;
import static io.github.com.pages.ButtonGroupsPage.fontAlignmentGroup;
import static io.github.com.pages.ButtonGroupsPage.fontAlignmentGroupWYSIWYG;
import static io.github.com.pages.ButtonGroupsPage.fontDecorationGroup;
import static io.github.com.pages.ButtonGroupsPage.fontDecorationGroupWYSIWYG;
import static io.github.com.pages.ButtonGroupsPage.fontDropdown;
import static io.github.com.pages.ButtonGroupsPage.mandatoryButtonGroup;
import static io.github.com.pages.ButtonGroupsPage.modelText;
import static io.github.com.pages.ButtonGroupsPage.multipleButtonGroup;
import static io.github.com.pages.ButtonGroupsPage.roundedButtonGroup;
import static io.github.com.pages.ButtonGroupsPage.sizeDropdown;
import static org.hamcrest.Matchers.containsString;

public class ButtonGroupsTests extends TestsInit {

    @BeforeClass
    public void before() {
        buttonGroupsPage.open();
        buttonGroupsPage.checkOpened();
    }

    @Test
    public void mandatoryButtonGroupTest() {
        mandatoryButtonGroup.is().displayed();
        mandatoryButtonGroup.has().css("width", "197px");
        mandatoryButtonGroup.getButtonByIndex(1).has().css("width", "50px");
        assertSelected(mandatoryButtonGroup.getButtonByIndex(1));
        mandatoryButtonGroup.getButtonByIndex(2).click();
        assertSelected(mandatoryButtonGroup.getButtonByIndex(2));

        mandatoryButtonGroup.getAllButtons().forEach(HasClick::click);

        assertSelected(mandatoryButtonGroup.getButtonByIndex(4));
    }

    @Test
    public void multipleButtonGroupTest() {
        List<Integer> clickOrdering = Arrays.asList(2, 3, 1);

        multipleButtonGroup.is().displayed();
        modelText.has().text(containsString("Model: []"));
        clickOrdering.stream()
                .map(index -> multipleButtonGroup.getButtonByIndex(index))
                .peek(HasClick::click)
                .forEach(this::assertSelected);

        modelText.has().text(containsString(
                String.format("Model: [ %s ]", clickOrdering.stream()
                        .map(index -> index - 1) // zero based
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")))
        ));
    }

    @Test
    public void roundedButtonGroupTest() {
        roundedButtonGroup.is().displayed();
        roundedButtonGroup.has().cssClass("v-btn-toggle--rounded");

        roundedButtonGroup.first().has().css("border-bottom-left-radius", "24px");
        roundedButtonGroup.last().has().css("border-bottom-right-radius", "24px");

        roundedButtonGroup.getAllButtons().forEach(HasClick::click);
    }

    @Test
    public void toolkitExampleTest() {
        fontDropdown.select("Courier");
        sizeDropdown.select("50%");

        fontDecorationGroup.has().size(4);

        // 1,2,3 are selected by default, make them unselected
        fontDecorationGroup.getAllButtons().stream().limit(3).forEach(HasClick::click);
        // select all
        fontDecorationGroup.getAllButtons().stream().peek(HasClick::click).forEach(this::assertSelected);

        // single selected group
        assertSelected(fontAlignmentGroup.getButtonByIndex(2));
        fontAlignmentGroup.getAllButtons().forEach(HasClick::click);
        assertSelected(fontAlignmentGroup.getButtonByIndex(4));
    }

    @Test
    public void wysiwygExampleTest() {
        fontDecorationGroupWYSIWYG.has().size(4);
        fontDecorationGroupWYSIWYG.getAllButtons().forEach(HasClick::click);
        fontDecorationGroupWYSIWYG.getAllButtons().forEach(this::assertSelected);

        fontAlignmentGroupWYSIWYG.has().size(3);
        assertSelected(fontAlignmentGroupWYSIWYG.getButtonByIndex(2));
        fontAlignmentGroupWYSIWYG.getAllButtons().forEach(HasClick::click);
        assertSelected(fontAlignmentGroupWYSIWYG.getButtonByIndex(3));
    }

    @JDIAction("Assert that '{0}' is selected")
    private void assertSelected(Button button) {
        // by the time I write tests for button groups, vuetify version of Button is not completed yet
        // vuetify button is considered to be active if it has the 'v-btn--active' class
        button.has().cssClass("v-btn--active");
    }

}
