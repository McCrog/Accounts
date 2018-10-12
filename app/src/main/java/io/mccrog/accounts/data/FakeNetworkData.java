package io.mccrog.accounts.data;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import io.mccrog.accounts.model.CurrencyAccount;
import io.mccrog.accounts.model.CurrencyType;

public class FakeNetworkData {

    private FakeNetworkData() {
    }

    /**
     * Returns the generated list of currency accounts for a given length
     * @param length the length of new ArrayList
     * @return the List containing CurrencyAccount's
     */
    @SuppressLint("DefaultLocale")
    public static List<CurrencyAccount> getNewCurrencyAccountList(int length) {
        String id;
        String title;
        String strFloat;
        float amount;
        CurrencyType currencyType;

        List<CurrencyAccount> currencyAccounts = new ArrayList<>(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            id = UUID.randomUUID().toString();
            title = "Currency Account #" + i;
            strFloat = String.format("%.2f", random.nextFloat() * 100);
            amount = Float.parseFloat(strFloat);
            currencyType = CurrencyType.values()[random.nextInt(CurrencyType.values().length)];
            currencyAccounts.add(new CurrencyAccount(id, title, amount, currencyType));
        }

        return currencyAccounts;
    }
}
