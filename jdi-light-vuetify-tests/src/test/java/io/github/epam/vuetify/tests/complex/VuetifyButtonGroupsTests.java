package io.github.epam.vuetify.tests.complex;

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
import static io.github.com.pages.ButtonGroupsPage.textAndIconOptions;
import static io.github.com.pages.ButtonGroupsPage.textOptions;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.light.elements.interfaces.base.HasClick;
import io.github.com.enums.ButtonNames;
import io.github.com.enums.Colors;
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

    @Test(description = "Test checks button group feature: 'mandatory'")
    public void mandatoryButtonGroupTest() {
        mandatoryButtonGroup.is().displayed();
        mandatoryButtonGroup.is().selected(1);
        mandatoryButtonGroup.getButtonByIndex(2).click();
        mandatoryButtonGroup.is().selected(2);
        mandatoryButtonGroup.getAllButtons().stream().forEachOrdered(HasClick::click);
        mandatoryButtonGroup.is().selected(4);
    }
    @Test(description = "Test checks button group feature: 'width'")
    public void widthButtonGroupTest() {
        mandatoryButtonGroup.is().displayed();
        mandatoryButtonGroup.has().width(197);
        mandatoryButtonGroup.getButtonByIndex(1).has().width(50);
    }
    @Test(description = "Test checks button group feature: 'shaped'")
    public void shapedButtonGroupTest() {
        mandatoryButtonGroup.is().displayed();
        mandatoryButtonGroup.has().shaped();
        multipleButtonGroup.has().notShaped();
    }

    @Test(description = "Test checks button group feature: 'multiple'")
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

    @Test(description = "Test checks button group feature: 'rounded'")
    public void roundedButtonGroupTest() {
        roundedButtonGroup.is().displayed();
        roundedButtonGroup.has().rounded();
        roundedButtonGroup.first().has().css("border-bottom-left-radius", "24px");
        roundedButtonGroup.last().has().css("border-bottom-right-radius", "24px");
        roundedButtonGroup.getAllButtons().stream().forEachOrdered(HasClick::click);

        mandatoryButtonGroup.is().displayed();
        mandatoryButtonGroup.has().notRounded();
    }

    @Test(description = "Test checks button group feature: 'dense' and 'background-color'")
    public void toolkitExampleTest() {
        fontDropdown.select("Courier");
        fontDecorationGroup.has().dense();
        fontDecorationGroup.has().backgroundColor(Colors.TRANSPARENT.value());
        sizeDropdown.select("50%");

        fontDecorationGroup.has().size(4);
        fontAlignmentGroup.getButtonByIndex(2).has().lightTheme();

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

    @Test(description = "Test checks button group 'WYSIWYG': size, clickable")
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

    @Test(description = "Test checks button group feature: 'theme', 'tile' and 'group'")
    public void textOptionsButtonGroupTest() {
        textOptions.has().size(4);
        textOptions.getButtonByText(ButtonNames.LEFT.name()).click();
        textOptions.is().selected(1);
        textOptions.has().lightTheme();
        textOptions.has().tile();
        textOptions.has().cssClass("v-btn-toggle--group");
        textOptions.getButtonByText(ButtonNames.CENTER.name()).click();
        textOptions.getButtonByText(ButtonNames.RIGHT.name()).click();
        textOptions.getButtonByText(ButtonNames.JUSTIFY.name()).click();

    }

    @Test(description = "Test checks button group feature: 'borderless' and 'icon'")
    public void textOptionsAndIconsButtonGroupTest() {
        textAndIconOptions.has().size(4);
        textAndIconOptions.getButtonByText(ButtonNames.LEFT.name()).click();
        textAndIconOptions.is().selected(1);
        textAndIconOptions.has().cssClass("v-btn-toggle--borderless");
        textAndIconOptions.has().icon();
        textAndIconOptions.getButtonByText(ButtonNames.CENTER.name()).click();
        textAndIconOptions.getButtonByText(ButtonNames.RIGHT.name()).click();
        textAndIconOptions.getButtonByText(ButtonNames.JUSTIFY.name()).click();

    }
}
