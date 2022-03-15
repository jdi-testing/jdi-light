package com.epam.jdi.light.material.elements.utils.enums;

public enum Position {
  TOP("top"),
  BOTTOM("bottom"),
  LEFT("left"),
  RIGHT("right"),
  END("end"),
  START("start"),
  TOP_RIGHT("TopRight"),
  TOP_LEFT("TopLeft"),
  BOTTOM_RIGHT("BottomRight"),
  BOTTOM_LEFT("BottomLeft");

  private String position;

  public String getPosition() {
    return position;
  }

  Position(String position) {
    this.position = position.toLowerCase();
  }

  public static Position fromString(String text) {
    for (Position b : Position.values()) {
      if (b.position.equalsIgnoreCase(text)) {
        return b;
      }
    }
    return Position.END;
  }
}
