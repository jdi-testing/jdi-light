package com.jdiai.tests.directions;

import com.jdiai.JS;
import com.jdiai.TestInit;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.$;
import static com.jdiai.Pages.CONTACTS_PAGE;
import static com.jdiai.asserts.Conditions.*;
import static com.jdiai.states.States.loggedInAt;

@Listeners(TestNGListener.class)
public class RelativePositionTests implements TestInit {
    JS firstName = $("#first-name");
    JS lastName = $("#last-name");
    JS passportNumber = $("#passport-number");
    JS passportSeria = $("#passport-seria");
    JS weather = $("#weather");
    JS gender = $("#gender");
    JS position = $("#position");
    JS passport = $("#passport");

    @BeforeMethod
    public void before() {
        loggedInAt(CONTACTS_PAGE);
    }

    @Test
    public void onTopOfTest() {
        lastName.shouldBe(onTopOf(passportNumber));
        passportNumber.shouldBe(below(lastName));
        passportNumber.shouldBe(below(firstName));
        passportNumber.shouldBe(below(position));

        gender.shouldBe(below(lastName));
        passportNumber.shouldBe(onTopOf(gender));
        passportNumber.shouldBe(onTopOf(weather));
    }

    @Test
    public void belowTest() {
        gender.shouldBe(below(lastName));
        passportNumber.shouldBe(onTopOf(gender));
        passportNumber.shouldBe(onTopOf(weather));
        firstName.shouldBe(onTopOf(weather));
    }

    @Test
    public void leftRightTest() {
        passportNumber.shouldBe(onLeftOf(passportSeria));
        passportNumber.shouldBe(onRightOf(passport));
        passport.shouldBe(onLeftOf(passportSeria));
    }

    @Test
    public void sameLineHorizontallyTest() {
        passportNumber.shouldBe(onTheSameLine(passportSeria));
        passport.shouldBe(onTheSameLine(passportNumber));
        firstName.shouldBe(onTheSameLine(lastName));
        weather.shouldBe(onTheSameLine(gender));
    }

    @Test
    public void sameLineVerticallyTest() {
        firstName.shouldBe(onTheSameVertical(gender));
        weather.shouldBe(onTheSameVertical(position));
    }

    @Test
    public void secondaryDirectionsTest() {
        firstName.shouldBe(onTopLeftOf(passportNumber));
        position.shouldBe(onTopRightOf(passportNumber));
        gender.shouldBe(onBottomLeftOf(passportNumber));
        weather.shouldBe(onBottomRightOf(passportNumber));
    }
}
