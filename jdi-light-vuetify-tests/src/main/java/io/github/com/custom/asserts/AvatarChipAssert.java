package io.github.com.custom.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.ChipAssert;
import io.github.com.custom.chips.AvatarChip;
import org.hamcrest.Matchers;

public class AvatarChipAssert extends ChipAssert implements ITextAssert<ChipAssert> {
	@Override
	public AvatarChip element() {
		return (AvatarChip) super.element();
	}

	@Override
	@JDIAction("Assert that '{name}' has text '{0}'")
	public AvatarChipAssert text(String text) {
		text(Matchers.containsString(text));
		return this;
	}
}
