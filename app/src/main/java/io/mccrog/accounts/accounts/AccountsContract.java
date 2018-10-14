package io.mccrog.accounts.accounts;

import java.util.List;

import io.mccrog.accounts.model.CurrencyAccount;

public interface AccountsContract {

    interface View extends LoadingContract {
        void showAccounts(List<CurrencyAccount> currencyAccounts);

        void showError();
    }

    interface Presenter {
        void attachView(View view);

        void detachView();
    }
}
