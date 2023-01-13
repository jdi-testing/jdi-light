package io.github.com.custom.chips;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.com.custom.asserts.AvatarChipAssert;

public class AvatarChip extends Chip {
	@Override
	public AvatarChipAssert is() {
		return (AvatarChipAssert) new AvatarChipAssert().set(this);
	}

	@JDIAction("Get '{name}' avatar")
	public Avatar getAvatar() {
		return new Avatar().setCore(Avatar.class, getContent().find(".v-avatar"));
	}
}
