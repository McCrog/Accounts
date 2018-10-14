package io.mccrog.accounts.accounts;

import java.util.concurrent.TimeUnit;

import io.mccrog.accounts.data.FakeNetworkDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AccountsPresenter implements AccountsContract.Presenter {

    private AccountsContract.View mView;

    @Override
    public void attachView(AccountsContract.View view) {
        mView = view;
        fetchAllAccounts();
    }

    @Override
    public void detachView() {
        mView = null;
    }

    private void fetchAllAccounts() {
        if (mView != null) {
            FakeNetworkDataRepository.getInstance()
                    .getAllCurrencyAccounts()
                    .delay(3, TimeUnit.SECONDS) //stub long-running operation
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(__ -> mView.showLoading())
                    .doOnTerminate(() -> mView.hideLoading())
                    .subscribe(accounts -> mView.showAccounts(accounts),
                            throwable -> mView.showError());
        }
    }
}
