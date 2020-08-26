package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.common.TextTypes;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.basicNativeSelect;
import static io.github.com.pages.sections.SelectSection.disableNativeSelect;
import static io.github.com.pages.sections.SelectSection.formNativeFeatureSelect;
import static io.github.com.pages.sections.SelectSection.nativeErrorStateMatcherSelect;
import static io.github.com.pages.sections.SelectSection.optionGroupsNativeSelect;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.ARIA_INVALID;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.AUDI;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.GERMAN_CARS;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MERCEDES;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.MUST_MAKE_SELECTION;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.SAAB;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.SWEDISH_CARS;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.VOLVO;
import static io.github.epam.angular.tests.elements.complex.select.TestsSelectBase.getCarsMap;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
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
        assertTrue(basicNativeSelect.list().size() == 4
                           && basicNativeSelect.list().get(1).text().equals(VOLVO)
                           && basicNativeSelect.list().get(2).text().equals(SAAB)
                           && basicNativeSelect.list().get(3).text().equals(MERCEDES)
                           && basicNativeSelect.list().get(4).text().equals(AUDI));
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
