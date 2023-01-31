package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class CardAssert extends UIAssert<CardAssert, Card> implements RoundedAssert<CardAssert, Card>,
        OutlinedAssert<CardAssert, Card>, ShapedAssert<CardAssert, Card>, TileAssert<CardAssert, Card>,
        LoadingAssert<CardAssert, Card>, ElevationAssert<CardAssert, Card>, MeasurementAssert<CardAssert, Card>,
        ColorAssert<CardAssert, Card>, ThemeAssert<CardAssert, Card>, FlatAssert<CardAssert, Card> {

    @JDIAction("Assert that '{name}' title has value '{0}'")
    public CardAssert title(final Matcher<String> condition) {
        String actualTitle = element().title().getText();
        jdiAssert(actualTitle, condition, String.format("Actual element's title '%s' is not equal to expected '%s'",
                actualTitle, condition));
        return this;
    }

    public CardAssert title(String text) {
        return this.title(equalTo(text));
    }

    @JDIAction("Assert that '{name}' subtitle has value '{0}'")
    public CardAssert subtitle(final Matcher<String> condition) {
        String actualSubtitle = element().subtitle().getText();
        jdiAssert(actualSubtitle, condition, String.format("Actual element's subtitle '%s' is not equal to expected " +
                        "'%s'", actualSubtitle, condition));
        return this;
    }

    public CardAssert subtitle(String text) {
        return this.subtitle(equalTo(text));
    }

    @JDIAction("Assert that '{name}' has loader height {0}")
    public CardAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height " +
                "'%s px' is not equal to expected '%s px'", actualLoaderHeight, height));
        return this;
    }

    @JDIAction("Assert that '{name}' is link")
    public CardAssert link() {
        jdiAssert(element().isLink(), Matchers.is(true), "Element is not link");
        return this;
    }

    @JDIAction("Assert that '{name}' is not link")
    public CardAssert notLink() {
        jdiAssert(element().isLink(), Matchers.is(false), "Element is link");
        return this;
    }

    @JDIAction("Assert that '{name}' max-width is '{0}'")
    public CardAssert maxWidthPx(int maxWidth) {
        int actualMaxWidth = element().getMaxWidth();
        jdiAssert(actualMaxWidth, Matchers.is(maxWidth), String.format("Element's actual max-width '%s px' is not " +
                "equal to expected '%s px'", actualMaxWidth, maxWidth));
        return this;
    }

    @JDIAction("Assert that '{name}' max-height is '{0}'")
    public CardAssert maxHeightPx(int maxHeight) {
        int actualMaxHeight = element().getMaxWidth();
        jdiAssert(actualMaxHeight, Matchers.is(maxHeight), String.format("Element's actual max-height '%s px' is not " +
                "equal to expected '%s px'", actualMaxHeight, maxHeight));
        return this;
    }

    @JDIAction("Assert that '{name}' is hover")
    public CardAssert hover() {
        jdiAssert(element().isHover(), Matchers.is(true), "Element is not hover");
        return this;
    }

    @JDIAction("Assert that '{name}' is not hover")
    public CardAssert notHover() {
        jdiAssert(element().isHover(), Matchers.is(false), "Element is hover");
        return this;
    }

    @JDIAction("Assert that '{name}' is raised")
    public CardAssert raised() {
        jdiAssert(element().isRaised(), Matchers.is(true), "Element is not raised");
        return this;
    }

    @JDIAction("Assert that '{name}' is not raised")
    public CardAssert notRaised() {
        jdiAssert(element().isRaised(), Matchers.is(false), "Element is raised");
        return this;
    }

    @JDIAction("Assert that '{name}' column is expanded")
    public CardAssert columnExpanded() {
        jdiAssert(element().columnIsExpanded(), Matchers.is(true), "Element's column is collapsed");
        return this;
    }

    @JDIAction("Assert that '{name}' column is collapsed")
    public CardAssert columnCollapsed() {
        jdiAssert(element().columnIsExpanded(), Matchers.is(false), "Element's column  is expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' column is not empty")
    public CardAssert columnNotEmpty() {
        jdiAssert(element().columnIsEmpty(), Matchers.is(false), "Column is empty");
        return this;
    }

    @JDIAction("Assert that '{name}' column is empty")
    public CardAssert columnEmpty() {
        jdiAssert(element().columnIsEmpty(), Matchers.is(true), "Column is not empty");
        return this;
    }

    @JDIAction("Assert that '{name}' column has title")
    public CardAssert columnTitle(String title) {
        String actualColumnTitle = element().getColumnTitle();
        jdiAssert(actualColumnTitle, Matchers.is(title), String.format("Column actual title '%s' is not equal to " +
                "expected '%s'", actualColumnTitle, title));
        return this;
    }
}
