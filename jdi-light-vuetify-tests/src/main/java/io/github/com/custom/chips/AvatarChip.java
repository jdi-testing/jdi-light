package io.github.com.custom.chips;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.com.custom.asserts.AvatarChipAssert;

import java.util.List;
import java.util.stream.Collectors;

public class AvatarChip extends Chip {
	@Override
	public AvatarChipAssert is() {
		return (AvatarChipAssert) new AvatarChipAssert().set(this);
	}

	@JDIAction("Get '{name}' avatar")
	public Avatar getAvatar() {
		List<Avatar> avatars = getContent()
				.stream()
				.filter((e) -> e.hasClass("v-avatar"))
				.map((e) -> new Avatar().setCore(Avatar.class, e))
				.collect(Collectors.toList());
		if (avatars.size() > 0) {
			return avatars.get(0);
		} else {
			throw new RuntimeException("Element doesn't have avatars");
		}
	}
}
