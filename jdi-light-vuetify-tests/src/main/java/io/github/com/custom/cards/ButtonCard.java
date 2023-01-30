package io.github.com.custom.cards;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Text;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;

public class ButtonCard extends Card {

    private UIElement expander() {
        return this.find("[class*='selection']");
    }

    public ButtonCard() {
        super();
    }

    public ButtonCard(UIElement element) {
        setCore(ButtonCard.class, element.base());
    }

    public Text text() {
        return new Text().setCore(Text.class, content().find("p"));
    }

    public Button button() {
        return new Button().setCore(Button.class, find("button"));
    }

    //Methods for Card with Switch (Required for DataIterator)

    private DataIterator dataIterator;
    @JDIAction("Expand '{name}'")
    public void expandColumn() {
        if (!columnIsExpanded() && expander().isExist()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void collapseCollumn() {
        if (columnIsExpanded() && expander().isExist()) {
            expander().click();
        }
    }

    @JDIAction("Is '{name}' expanded")
    public boolean columnIsExpanded() {
        if (expander().isExist()) {
            return this.find("input[role=switch]")
                    .attr("aria-checked")
                    .equalsIgnoreCase("true");
        } else {
            return false;
        }
    }
}
