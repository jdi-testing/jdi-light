package io.github.com.custom.chips;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.common.Image;

import java.util.List;
import java.util.stream.Collectors;

public class ExpandableChip extends Chip {
	@JDIAction("Expand '{name}'")
	public void expand() {
		click();
	}

	@JDIAction("Get '{name}' image")
	public Image getImage() {
		List<Image> images = getContent().stream()
				.filter((e) -> e.hasClass("v-image__image"))
				.map((e) -> new Image().setCore(Image.class, e))
				.collect(Collectors.toList());
		if (images.size() > 0) {
			return images.get(0);
		} else {
			throw new RuntimeException("Element doesn't have images");
		}
	}

}
