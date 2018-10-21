package io.mccrog.accounts.accounts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import io.mccrog.accounts.R;
import io.mccrog.accounts.accounts.adapter.AccountsAdapter;
import io.mccrog.accounts.model.CurrencyAccount;

public class AccountsActivity extends AppCompatActivity implements AccountsContract.View {

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;

    private AccountsAdapter mAccountsAdapter;

    private AccountsContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.main_progress_bar);
        mRecyclerView = findViewById(R.id.main_recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAccountsAdapter = new AccountsAdapter();
        mRecyclerView.setAdapter(mAccountsAdapter);

        attachPresenter();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showAccounts(List<CurrencyAccount> currencyAccounts) {
        mAccountsAdapter.setData(currencyAccounts);
    }

    @Override
    public void showError() {
        Toast toast = Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.internet_error_title),
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    private void attachPresenter() {
        mPresenter = (AccountsContract.Presenter) getLastCustomNonConfigurationInstance();
        if (mPresenter == null) {
            mPresenter = new AccountsPresenter();
        }
        mPresenter.attachView(this);
    }
}
