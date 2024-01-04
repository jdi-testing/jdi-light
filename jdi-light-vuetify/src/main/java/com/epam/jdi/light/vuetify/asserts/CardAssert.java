package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.asserts.generic.ColorAssert;
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

    @JDIAction(value = "Assert that '{name}' title has value '{0}'", isAssert = true)
    public CardAssert title(final Matcher<String> condition) {
        jdiAssert(element().title().getText(), condition);
        return this;
    }

    public CardAssert title(String text) {
        return this.title(equalTo(text));
    }

    @JDIAction(value = "Assert that '{name}' subtitle has value '{0}'", isAssert = true)
    public CardAssert subtitle(final Matcher<String> condition) {
        jdiAssert(element().subtitle().getText(), condition);
        return this;
    }

    public CardAssert subtitle(String text) {
        return this.subtitle(equalTo(text));
    }

    @JDIAction(value = "Assert that '{name}' has loader height {0}", isAssert = true)
    public CardAssert loaderHeightPx(int height) {
        jdiAssert(element().getLoaderHeight(), Matchers.equalTo(height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is link", isAssert = true)
    public CardAssert link() {
        jdiAssert(element().isLink(), Matchers.is(true), "Card is not link");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not link", isAssert = true)
    public CardAssert notLink() {
        jdiAssert(element().isLink(), Matchers.is(false), "Card is link");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' max-width is '{0}'", isAssert = true)
    public CardAssert maxWidthPx(int maxWidth) {
        jdiAssert(element().getMaxWidth(), Matchers.is(maxWidth));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' max-height is '{0}'", isAssert = true)
    public CardAssert maxHeightPx(int maxHeight) {
        jdiAssert(element().getMaxWidth(), Matchers.is(maxHeight));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is hover", isAssert = true)
    public CardAssert hover() {
        jdiAssert(element().isHover(), Matchers.is(true), "Card is not hover");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not hover", isAssert = true)
    public CardAssert notHover() {
        jdiAssert(element().isHover(), Matchers.is(false), "Card is hover");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is raised", isAssert = true)
    public CardAssert raised() {
        jdiAssert(element().isRaised(), Matchers.is(true), "Card is not raised");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not raised", isAssert = true)
    public CardAssert notRaised() {
        jdiAssert(element().isRaised(), Matchers.is(false), "Card is raised");
        return this;
    }
}
