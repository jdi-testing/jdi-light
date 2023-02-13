package io.github.com.custom.asserts;

import com.epam.jdi.light.vuetify.asserts.CardAssert;
import io.github.com.custom.ExpandableCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpandableCardAssert extends CardAssert {

    public ExpandableCardAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Card is collapsed");
        return this;
    }

    public ExpandableCardAssert collapsed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "Card is expanded");
        return this;
    }

    public ExpandableCardAssert hasContent() {
        jdiAssert(element().isItemsEmpty(), Matchers.is(false), "Card has empty list");
        return this;
    }

    public ExpandableCardAssert hasNoContent() {
        jdiAssert(element().isItemsEmpty(), Matchers.is(true), "Card has content in the list");
        return this;
    }

    @Override
    public ExpandableCard element() {
        return (ExpandableCard) super.element();
    }

    public ExpandableCardAssert set(ExpandableCard card) {
        super.set(card);
        return this;
    }

    public ExpandableCardAssert and() {
        super.and();
        return this;
    }

}
