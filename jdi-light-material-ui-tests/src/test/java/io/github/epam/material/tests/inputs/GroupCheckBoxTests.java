package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.groupCheckBoxFrame;
import static io.github.com.StaticSite.groupCheckBoxPage;

public class GroupCheckBoxTests extends TestsInit {

    private final int indexOne = 1;
    private final int indexTwo = 2;
    private final int indexThree = 3;

    @Test
    public void verifyingGroupCheckBoxTests() {
        groupCheckBoxPage.shouldBeOpened();

        groupCheckBoxFrame.groupCheckbox.is().unchecked(indexOne);
        groupCheckBoxFrame.groupCheckbox.is().enabled(indexOne);
        groupCheckBoxFrame.groupCheckbox.clickOnCheckBoxByIndex(indexOne);
        groupCheckBoxFrame.groupCheckbox.is().checked(indexOne);

        groupCheckBoxFrame.groupCheckbox.is().checked(indexTwo);
        groupCheckBoxFrame.groupCheckbox.is().enabled(indexTwo);
        groupCheckBoxFrame.groupCheckbox.clickOnCheckBoxByIndex(indexTwo);
        groupCheckBoxFrame.groupCheckbox.is().checked(indexTwo);

        groupCheckBoxFrame.groupCheckbox.is().disabled(indexThree);
    }
}
