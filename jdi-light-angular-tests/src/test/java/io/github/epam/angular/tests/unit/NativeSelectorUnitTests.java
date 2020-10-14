package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.common.TextTypes;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.*;
import static io.github.epam.angular.tests.elements.complexgroups.select.TestsSelectBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NativeSelectorUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void listTest() {
        assertThat(basicNativeSelect.list(), hasSize(4));
        assertThat(basicNativeSelect.list().values(), hasItems(VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void selectByValueTest() {
        basicNativeSelect.show();
        basicNativeSelect.select(VOLVO);
        assertEquals(basicNativeSelect.selected(), VOLVO);
    }

    @Test
    public void selectByIndexTest() {
        basicNativeSelect.show();
        basicNativeSelect.select(SAAB);
        assertTrue(basicNativeSelect.selected(SAAB));
    }

    @Test
    public void valuesTest() {
        assertEquals(basicNativeSelect.values(), Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void valuesByTextTypeTest() {
        assertEquals(basicNativeSelect.values(TextTypes.TEXT), Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void getGroupsTest() {
        assertEquals(optionGroupsNativeSelect.groups(), Arrays.asList(SWEDISH_CARS, GERMAN_CARS));
    }

    @Test
    public void getGroupsAndOptionsTest() {
        assertEquals(optionGroupsNativeSelect.groupsAndOptions(), getCarsMap());
    }

    @Test
    public void listEnabledTest() {
        assertEquals(disableNativeSelect.listEnabled(), Arrays.asList(VOLVO, MERCEDES, AUDI));
    }

    @Test
    public void listDisabledTest() {
        assertEquals(disableNativeSelect.listDisabled(), Arrays.asList("", SAAB));
    }

    @Test
    public void hintTest() {
        formNativeFeatureSelect.show();
        formNativeFeatureSelect.select(MERCEDES);
        formNativeFeatureSelect.waitFor().attr(ARIA_INVALID, "false");
        assertEquals(formNativeFeatureSelect.hint().text(), "You can pick up your favorite car here");
    }

    @Test
    public void errorTest() {
        nativeErrorStateMatcherSelect.show();
        nativeErrorStateMatcherSelect.select("");
        assertEquals(nativeErrorStateMatcherSelect.error().text(), MUST_MAKE_SELECTION);
    }
}
