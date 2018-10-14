package io.mccrog.accounts.data;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import io.mccrog.accounts.model.CurrencyAccount;
import io.mccrog.accounts.model.CurrencyType;
import io.reactivex.Flowable;

public class FakeNetworkDataRepository {

    private static final int SIZE = 100;

    private static FakeNetworkDataRepository sInstance = null;

    private List<CurrencyAccount> mCurrencyAccounts;

    private FakeNetworkDataRepository() {
    }

    public synchronized static FakeNetworkDataRepository getInstance() {
        if (sInstance == null) {
            sInstance = new FakeNetworkDataRepository();
        }
        return sInstance;
    }

    /**
     * Returns Flowable list of currency accounts for a given length
     *
     * @return the Flowable list containing CurrencyAccount's
     */
    public Flowable<List<CurrencyAccount>> getAllCurrencyAccounts() {
        List<CurrencyAccount> currencyAccounts = generateNewRandomCurrencyAccountsList(SIZE);
        Collections.sort(currencyAccounts, (ca1, ca2) -> Integer.compare(ca1.getCurrencyType().ordinal(), ca2.getCurrencyType().ordinal()));
        return Flowable.fromCallable(() -> currencyAccounts);
    }

    /**
     * Returns the generated list of currency accounts for a given length
     *
     * @param size the size of new ArrayList
     * @return the List containing CurrencyAccount's
     */
    @SuppressLint("DefaultLocale")
    private List<CurrencyAccount> generateNewRandomCurrencyAccountsList(int size) {
        if (mCurrencyAccounts == null) {
            String id;
            String title;
            String strFloat;
            float amount;
            CurrencyType currencyType;

            mCurrencyAccounts = new ArrayList<>(size);
            Random random = new Random();

            for (int i = 0; i < size; i++) {
                id = UUID.randomUUID().toString();
                title = "Currency Account #" + i;
                strFloat = String.format("%.2f", random.nextFloat() * 100);
                amount = Float.parseFloat(strFloat);
                currencyType = CurrencyType.values()[random.nextInt(CurrencyType.values().length)];
                mCurrencyAccounts.add(new CurrencyAccount(id, title, amount, currencyType));
            }
        }

        return mCurrencyAccounts;
    }
}
