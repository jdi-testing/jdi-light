package com.epam.jdi.light.material.elements.utils.enums;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

public enum Position {
  TOP("top"),
  BOTTOM("bottom"),
  LEFT("left"),
  RIGHT("right"),
  END("end"),
  START("start"),
  TOP_RIGHT("TopRight"),
  TOP_LEFT("TopLeft"),
  TOP_CENTER("TopCenter"),
  BOTTOM_CENTER("BottomCenter"),
  BOTTOM_RIGHT("BottomRight"),
  BOTTOM_LEFT("BottomLeft");

  private final String value;

  @Override
  public String toString() {
    return value;
  }

  Position(String value) {
    this.value = value.toLowerCase();
  }

  public static Position fromString(String text) {
    for (Position b : Position.values()) {
      if (b.value.equalsIgnoreCase(text)) {
        return b;
      }
    }
    throw runtimeException(String.format("No appropriate %s constant found for value '%s'", Position.class.getName(), text));
  }
}
