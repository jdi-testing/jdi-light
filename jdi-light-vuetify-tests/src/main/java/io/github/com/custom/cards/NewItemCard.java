package io.github.com.custom.cards;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import org.openqa.selenium.Keys;

public class NewItemCard extends Card {

    @UI("input")
    public static WebList inputs;

    public void save() {
        new Button().setCore(Button.class, actions().setCore(find("//button[./span[contains(text(),'Save')]]"))).click();
    }

    public void cancel() {
        new Button().setCore(Button.class, actions().setCore(find("//button[./span[contains(text(),'Cancel')]]"))).click();
    }

    public void fill(String... values) {
        int maxIndex = inputs.size() < values.length ? inputs.size() : values.length;
        for (int i = 0; i < maxIndex; i++) {
            inputs.get(i + 1).sendKeys(Keys.BACK_SPACE);
            inputs.get(i + 1).sendKeys(values[i]);
        }
    }
}
