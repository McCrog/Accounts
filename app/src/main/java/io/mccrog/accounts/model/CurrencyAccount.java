package io.mccrog.accounts.model;

/**
 * {@link CurrencyAccount} Extends the base {@link Account} class and represents the currency account.
 * It contains currencyType.
 */
public class CurrencyAccount extends Account {
    private final CurrencyType currencyType;

    public CurrencyAccount(String id, String title, float amount, CurrencyType currencyType) {
        super(id, title, amount);
        this.currencyType = currencyType;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
