package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.displaydata.ChipAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Chip web element please visit
 * https://mui.com/components/chips/
 */

public class Chip extends UIBaseElement<ChipAssert> implements HasClick, CanBeDisabled, HasColor, HasLabel {

    @Override
    @JDIAction("Get '{name}'s label")
    public Label label() {
        return new Label().setCore(Label.class, find(".MuiChip-label"));
    }

    @JDIAction("Get '{name}'s delete icon")
    public Icon deleteIcon() {
        return new Icon().setCore(Icon.class, find(".MuiChip-deleteIcon"));
    }

    @JDIAction("Get '{name}'s avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, find(".MuiChip-avatar"));
    }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find(".MuiChip-icon"));
    }

    @JDIAction("Is '{name}' outlined")
    public boolean isOutlined() {
        return attr("class").contains("outlined");
    }

    @JDIAction("Is '{name}' clickable")
    public boolean isClickable() {
        return attr("class").contains("clickable");
    }

    @JDIAction("Is '{name}' deletable")
    public boolean isDeletable() {
        return hasClass("MuiChip-deletable") && deleteIcon().isDisplayed();
    }

    @JDIAction("Is '{name}' link")
    public boolean isLink() {
        return hasAttribute("href") && getTagName().equals("a");
    }

    @JDIAction("Get '{name}'s href")
    public String href() {
        if (isLink()) {
            return attr("href");
        } else {
            throw runtimeException("Element is not a link");
        }
    }

    @JDIAction("Delete '{name}'")
    public void delete() {
        if (deleteIcon().isDisplayed()) {
            deleteIcon().click();
        } else {
            throw runtimeException("Chip does not have delete icon");
        }
    }

    @Override
    public ChipAssert is() {
        return new ChipAssert().set(this);
    }
}
