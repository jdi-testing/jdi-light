package io.github.epam.enums;

public enum Currency {
  USD("$"),
  EUR("€"),
  BTC("฿"),
  JPY("¥");

  public final String value;

  Currency(String currencyItemText) {
    this.value = currencyItemText;
  }
}
