package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.BannerAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import com.epam.jdi.light.vuetify.interfaces.MayContainButtons;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/banners/
 */

public class Banner extends UIBaseElement<BannerAssert> implements IsText, HasRounded, IsTile, IsShaped, IsOutlined,
        HasTheme, HasElevation, HasColor, IsSingleLine, HasIcon, MayContainButtons {

    @Override
    @JDIAction("Get '{name}' button group")
    public List<VuetifyButton> buttons() {
        return bannerActions().finds(".v-btn").stream().map(this::castToButton).collect(Collectors.toList());
   }

    @JDIAction("Get '{name}' text content")
    public String getText() {
        return bannerContent().find(".v-banner__text").getText();
    }

    @JDIAction("Get '{name}' content element")
    public UIElement bannerContent() {
        return core().find(".v-banner__content");
    }

    @Override
    public Icon icon() {
        return new Icon().setCore(Icon.class, bannerContent().find("div.v-banner__icon"));
    }

    @JDIAction("Get '{name}' icons")
    public List<UIElement> getIconsFromContent() {
        return bannerContent().finds("div.v-banner__icon");
    }

    @Override
    @JDIAction("Get if '{name}' has icon")
    public boolean hasIcon() {
        return getIconsFromContent().size() > 0;
    }

    @JDIAction("Get '{name}' actions element")
    public UIElement bannerActions() {
        return core().find(".v-banner__actions");
    }

    @JDIAction("Get if '{name}' is sticky")
    public boolean isSticky() {
        return hasClass("v-banner--sticky");
    }

    public BannerAssert is() {
        return new BannerAssert().set(this);
    }
}
