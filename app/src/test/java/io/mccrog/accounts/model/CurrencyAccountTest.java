package io.mccrog.accounts.model;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CurrencyAccountTest {

    private static final String id;
    private static final String title;
    private static final float amount;
    private static final CurrencyType currencyType;
    private static final CurrencyAccount currencyAccount;

    static {
        id = UUID.randomUUID().toString();
        title = "New";
        amount = new Random().nextFloat() * 100;
        currencyType = CurrencyType.RUB;
        currencyAccount = new CurrencyAccount(id, title, amount, currencyType);
    }

    @Test
    public void whenInitializedWithNew_thenInstanceIsNotNull() {
        assertNotNull(currencyAccount);
    }

    @Test
    public void whenInitializedWithNew_thenFieldsAreEqualToValueReturnedByGetters() {
        assertThat(currencyAccount.getId(), is(id));
        assertThat(currencyAccount.getTitle(), is(title));
        assertThat(currencyAccount.getAmount(), is(amount));
        assertThat(currencyAccount.getCurrencyType(), is(currencyType));
    }
}