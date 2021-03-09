package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.groupCheckBoxFrame;
import static io.github.com.StaticSite.groupCheckBoxPage;

public class GroupCheckBoxTests extends TestsInit {

    private final int indexOne = 1;
    private final int indexTwo = 2;
    private final int indexThree = 3;
    private final int indexFour = 4;

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

    @Test(expectedExceptions = {IndexOutOfBoundsException.class},
            expectedExceptionsMessageRegExp = ".*(Can't perform click. Element is out of bound)")
    public void outOfBoundTest() {
        groupCheckBoxPage.shouldBeOpened();

        try {
            groupCheckBoxFrame.groupCheckbox.clickOnCheckBoxByIndex(indexFour);
        } catch (IndexOutOfBoundsException e) {
            e.getCause();
            e.getMessage();
        }

    }
}
