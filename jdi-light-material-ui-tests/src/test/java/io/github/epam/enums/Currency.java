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

  /**
   * Currency symbol (e.g. "$", "€").
   */
  public final String value;

  Currency(String currencyItemSymbol) {
    this.value = currencyItemSymbol;
  }
}
