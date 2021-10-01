package io.github.com.custom.cards;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.ProgressBar;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.Card;

import java.util.List;

public class LoadingCard extends Card {
    @UI(".v-card__progress")
    protected ProgressBar progressBar;

    @UI("//div[contains(@class, 'v-card__title')][2]")
    protected Text secondTitle;

    @UI(".v-chip")
    protected List<UIElement> chipsList;

    @Override
    public UIElement subtitle() {
        return content().find(".text-subtitle-1");
    }

    public ProgressBar progressBar() {
        return progressBar;
    }

    public List<UIElement> chipsList() {
        return chipsList;
    }

    public Text secondTitle() {
        return secondTitle;
    }

    public Button reserveButton() {
        return new Button().setCore(Button.class, actions().find("button"));
    }
}
