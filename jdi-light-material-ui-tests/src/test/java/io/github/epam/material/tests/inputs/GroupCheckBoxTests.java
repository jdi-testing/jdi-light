package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.groupCheckBoxFrame;
import static io.github.com.StaticSite.groupCheckBoxPage;

public class GroupCheckBoxTests extends TestsInit {

    @Test
    public void verifyingGroupCheckBoxTests() {
        groupCheckBoxPage.shouldBeOpened();

        groupCheckBoxFrame.groupCheckbox.is().enabled();
        groupCheckBoxFrame.groupCheckbox.clickUncheckedCheckBox();
        groupCheckBoxFrame.groupCheckbox.is().checked();
        groupCheckBoxFrame.groupCheckbox.clickCheckedCheckBox();
        groupCheckBoxFrame.groupCheckbox.is().unchecked();
        groupCheckBoxFrame.groupCheckbox.is().disabled();
    }
}
