package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.sleep;
import static com.jdiai.tools.Timer.waitCondition;
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
import static io.github.com.pages.ButtonGroupsPage.textOptions;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import io.github.com.enums.Texts;
import io.github.epam.TestsInit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VuetifyButtonGroupsTests extends TestsInit {

    @BeforeClass
    public void before() {
        buttonGroupsPage.open();
        waitCondition(() -> buttonGroupsPage.isOpened());
        buttonGroupsPage.checkOpened();
    }

    @Test
    public void mandatoryButtonGroupTest() {
        mandatoryButtonGroup.is().displayed();
        mandatoryButtonGroup.has().css("width", "197px");
        mandatoryButtonGroup.getButtonByIndex(1).has().css("width", "50px");

        mandatoryButtonGroup.is().selected(1);
        mandatoryButtonGroup.getButtonByIndex(2).click();
        mandatoryButtonGroup.is().selected(2);
        mandatoryButtonGroup.getAllButtons().stream().forEachOrdered(HasClick::click);
        mandatoryButtonGroup.is().selected(4);
    }

    @Test
    public void multipleButtonGroupTest() {
        List<Integer> clickOrdering = Arrays.asList(2, 3, 1);

        multipleButtonGroup.is().displayed();
        modelText.has().text(containsString("Model: []"));
        clickOrdering.stream()
                     .map(index -> multipleButtonGroup.getButtonByIndex(index))
                     .forEach(HasClick::click);
        clickOrdering.stream()
                     .forEach(index -> multipleButtonGroup.is().selected(index));

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

        roundedButtonGroup.getAllButtons().stream().forEachOrdered(HasClick::click);
        roundedButtonGroup.is().selected(4);
    }

    @Test
    public void toolkitExampleTest() {
        fontDropdown.select("Courier");
        sizeDropdown.select("50%");

        fontDecorationGroup.has().size(4);

        // 1,2,3 are selected by default, make them unselected
        fontDecorationGroup.getAllButtons().stream().limit(3).forEach(HasClick::click);
        // select all
        fontDecorationGroup.getAllButtons().stream().forEach(HasClick::click);
        for (int i = 1; i <= 4; i++) {
            fontDecorationGroup.is().selected(i);
        }

        // single selected group
        fontAlignmentGroup.is().selected(2);
        fontAlignmentGroup.getAllButtons().stream().forEachOrdered(HasClick::click);
        fontAlignmentGroup.is().selected(4);
    }

    @Test
    public void wysiwygExampleTest() {
        fontDecorationGroupWYSIWYG.has().size(4);
        fontDecorationGroupWYSIWYG.getAllButtons().forEach(HasClick::click);
        for (int i = 1; i <= 4; i++) {
            fontDecorationGroupWYSIWYG.is().selected(i);
        }

        fontAlignmentGroupWYSIWYG.has().size(3);
        fontAlignmentGroupWYSIWYG.is().selected(2);
        fontAlignmentGroupWYSIWYG.getAllButtons().stream().forEachOrdered(HasClick::click);
        fontAlignmentGroupWYSIWYG.is().selected(3);
    }

    @Test
    public void textOptionsButtonGroupTest() {
        textOptions.has().size(4);
        textOptions.getButtonByText(Texts.LEFTWITHSPACES.toString()).click();
        textOptions.is().selected(1);
        textOptions.getButtonByText(Texts.CENTERWITHSPACES.toString()).click();
        textOptions.getButtonByText(Texts.RIGHTWITHSPACES.toString()).click();
        textOptions.getButtonByText(Texts.JUSTIFYWITHSPACES.toString()).click();

    }

    @Test
    public void textOptionsAndIconsButtonGroupTest() {
        textOptions.has().size(4);
        textOptions.getButtonByText(Texts.LEFT.toString()).click();
        textOptions.is().selected(1);
        textOptions.getButtonByText(Texts.CENTER.toString()).click();
        textOptions.getButtonByText(Texts.RIGHT.toString()).click();
        textOptions.getButtonByText(Texts.JUSTIFY.toString()).click();

    }
}
