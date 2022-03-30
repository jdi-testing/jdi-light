package io.github.epam.enums;

/**
 * Contains named constants representing currencies (i.e. USD, EUR, BTC, JPY).
 * Each constant includes information about its symbol.
 */
public enum Currency {
  USD("$"),
  EUR("€"),
  BTC("฿"),
  JPY("¥");

  private final String value;

  Currency(String currencyItemText) {
    this.value = currencyItemText;
  }

  @Override
  public String toString() {
    return value;
  }
}
