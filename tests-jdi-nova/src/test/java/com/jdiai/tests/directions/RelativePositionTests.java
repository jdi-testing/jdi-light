package com.jdiai.tests.directions;

import com.jdiai.JS;
import com.jdiai.TestInit;
import com.jdiai.interfaces.HasCore;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.*;
import static com.jdiai.Pages.CONTACTS_PAGE;
import static com.jdiai.asserts.Conditions.*;
import static com.jdiai.states.States.loggedInAt;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

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
        lastName.shouldBe(above(passportNumber));
        passportNumber.shouldBe(below(lastName));
        passportNumber.shouldBe(below(firstName));
        passportNumber.shouldBe(below(position));

        gender.shouldBe(below(lastName));
        passportNumber.shouldBe(above(gender));
        passportNumber.shouldBe(above(weather));
    }

    @Test
    public void belowTest() {
        gender.shouldBe(below(lastName));
        passportNumber.shouldBe(above(gender));
        passportNumber.shouldBe(above(weather));
        firstName.shouldBe(above(weather));
    }

    @Test
    public void leftRightTest() {
        passportNumber.shouldBe(onLeftOf(passportSeria));
        passportNumber.shouldBe(onRightOf(passport));
        passport.shouldBe(onLeftOf(passportSeria));
    }

    @Test
    public void sameLineHorizontallyTest() {
        passportNumber.shouldBe(onSameLine(passportSeria));
        passport.shouldBe(onSameLine(passportNumber));
        firstName.shouldBe(onSameLine(lastName));
        weather.shouldBe(onSameLine(gender));
    }

    @Test
    public void sameLineVerticallyTest() {
        firstName.shouldBe(onSameVerticalLine(gender));
        weather.shouldBe(onSameVerticalLine(position));
    }

    @Test
    public void secondaryDirectionsTest() {
        firstName.shouldBe(onTopLeftOf(passportNumber));
        position.shouldBe(onTopRightOf(passportNumber));
        gender.shouldBe(onBottomLeftOf(passportNumber));
        weather.shouldBe(onBottomRightOf(passportNumber));
    }

    @Test
    public void lineLayoutTest() {
        lineLayout(firstName, lastName, position);
    }

    @Test
    public void lineLayoutFailTest() {
        try {
            timeout = 1;
            lineLayout(lastName, firstName, position);
            fail("lineLayout in wrong order should fail");
        } catch (AssertionError ex) {
            assertTrue(ex.getMessage().contains("Assert that 'id:'last-name'' is on the Left of 'id:'first-name''"));
        } finally {
            timeout = 10;
        }
    }

    @Test
    public void complexLayoutTest() {
        complexLayout(new HasCore[][] {
            { firstName, lastName, position },
            { passportNumber, passportSeria },
            { gender, weather }
        });
    }

    @Test
    public void gridLayoutTest() {
        gridLayout(new HasCore[][] {
            { firstName, lastName, position },
            { null, passportNumber, passportSeria },
            { gender, null, weather }
        });

        gridLayout(new HasCore[][] {
            { firstName, lastName, position },
            { passportNumber, null, passportSeria },
            { gender, null, weather }
        });

        gridLayout(new HasCore[][] {
            { firstName, lastName, position },
            { passportNumber, passportSeria, null },
            { gender, null, weather }
        });
    }

    @Test
    public void gridLayout2Test() {
        gridLayout(new HasCore[][] {
            { firstName, null, lastName, null, position },
            { null, passportNumber, null, passportSeria, null },
            { gender, null, null, null, weather }
        });
    }

    @Test
    public void gridLayoutFailTest() {
        try {
            timeout = 1;
            gridLayout(new HasCore[][] {
                { lastName, firstName, position },
                { null, passportNumber, passportSeria },
                { gender, null, weather }
            });
            fail("gridLayout in wrong order should fail");
        } catch (AssertionError ex) {
            assertTrue(ex.getMessage().contains("Assert that 'id:'last-name'' is on the Left of 'id:'passport-number''"));
        } finally {
            timeout = 10;
        }
    }


    @Test
    public void gridLayoutFail2Test() {
        try {
            timeout = 1;
            gridLayout(new HasCore[][] {
                { firstName, lastName, position },
                { gender, null, weather },
                { null, passportNumber, passportSeria },
            });
            fail("gridLayout in wrong order should fail");
        } catch (AssertionError ex) {
            assertTrue(ex.getMessage().contains("Assert that 'id:'weather'' is on the Top of 'id:'passport-number''"));
        } finally {
            timeout = 10;
        }
    }
}
