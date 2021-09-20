package com.epam.jdi.light.material.elements.utils.enums;

public enum CurrencyItems {
  USD("$"),
  EUR("€"),
  BTC("฿"),
  JPY("¥");

  public final String value;

  CurrencyItems(String currencyItemText) {
    this.value = currencyItemText;
  }
}
