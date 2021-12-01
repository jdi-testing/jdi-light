package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.Image;

import java.util.List;
import java.util.stream.Collectors;

public interface HasImage extends ICoreElement {

    default Image image() {
        return new Image().setCore(Image.class, find("img"));
    }

    default List<Image> images() {
        return finds("img").stream()
                .map(i -> new Image().setCore(Image.class, i)).collect(Collectors.toList());
    }
}
