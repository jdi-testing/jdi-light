package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ProfileCard;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProfileCardAssert extends UIAssert<ProfileCardAssert, ProfileCard> {

    @JDIAction("Assert that {name} is displayed")
    public ProfileCardAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has avatar photo")
    public ProfileCardAssert avatarPhoto() {
        jdiAssert(element().hasAvatarPhoto(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has background photo")
    public ProfileCardAssert backgroundPhoto() {
        jdiAssert(element().hasBackgroundPhoto(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has proper text in 'name' text field")
    public ProfileCardAssert properName(String text) {
        jdiAssert(element().hasProperName(text), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has proper text in 'name' text field")
    public ProfileCardAssert properJobFunction(String text) {
        jdiAssert(element().hasProperJobFunction(text), Matchers.is(true));
        return this;
    }
 }

