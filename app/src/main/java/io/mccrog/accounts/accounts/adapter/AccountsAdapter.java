package io.mccrog.accounts.accounts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.mccrog.accounts.R;
import io.mccrog.accounts.model.CurrencyAccount;
import io.mccrog.accounts.utilities.Constants;

public class AccountsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final List<CurrencyAccount> mCurrencyAccounts;

    public AccountsAdapter() {
        mCurrencyAccounts = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case Constants.VIEW_TYPE_IMAGE_TITLE_AMOUNT:
                return new AccountViewHolder(getView(viewGroup, R.layout.item_account_rub));
            case Constants.VIEW_TYPE_TITLE_IMAGE_AMOUNT:
                return new AccountViewHolder(getView(viewGroup, R.layout.item_account_usd));
            case Constants.VIEW_TYPE_TITLE_AMOUNT_IMAGE:
                return new AccountViewHolder(getView(viewGroup, R.layout.item_account_eur));
            case Constants.VIEW_TYPE_TITLE_AMOUNT:
                return new CoronaAccountViewHolder(getView(viewGroup, R.layout.item_account_corona));
            default:
                throw new IllegalArgumentException("Unknown CurrencyType: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int i) {
        CurrencyAccount currencyAccount = mCurrencyAccounts.get(i);
        viewHolder.bind(currencyAccount);
    }

    @Override
    public int getItemCount() {
        return mCurrencyAccounts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mCurrencyAccounts.get(position).getCurrencyType().getViewType();
    }

    public void setData(List<CurrencyAccount> newCurrencyAccounts) {
        mCurrencyAccounts.clear();
        mCurrencyAccounts.addAll(newCurrencyAccounts);
        notifyDataSetChanged();
    }

    private View getView(@NonNull ViewGroup viewGroup, int layout) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
    }
}
