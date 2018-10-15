package io.mccrog.accounts.accounts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.mccrog.accounts.R;
import io.mccrog.accounts.model.CurrencyAccount;
import io.mccrog.accounts.utilities.Constants;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.AccountViewHolder> {

    private final List<CurrencyAccount> mCurrencyAccounts;

    public AccountsAdapter() {
        mCurrencyAccounts = new ArrayList<>();
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView;
        switch (viewType) {
            case Constants.VIEW_TYPE_IMAGE_TITLE_AMOUNT:
                itemView = getView(viewGroup, R.layout.item_account_rub);
                break;
            case Constants.VIEW_TYPE_TITLE_IMAGE_AMOUNT:
                itemView = getView(viewGroup, R.layout.item_account_eur);
                break;
            case Constants.VIEW_TYPE_TITLE_AMOUNT_IMAGE:
                itemView = getView(viewGroup, R.layout.item_account_usd);
                break;
            default:
                throw new IllegalArgumentException("Unknown CurrencyType: " + viewType);
        }
        return new AccountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder accountViewHolder, int i) {
        CurrencyAccount currencyAccount = mCurrencyAccounts.get(i);

        accountViewHolder.title.setText(currencyAccount.getTitle());
        accountViewHolder.amount.setText(String.valueOf(currencyAccount.getAmount()));
        accountViewHolder.currencyIcon.setImageResource(currencyAccount.getCurrencyType().getDrawableId());
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

    class AccountViewHolder extends RecyclerView.ViewHolder {
        ImageView currencyIcon;
        TextView title;
        TextView amount;

        AccountViewHolder(View itemView) {
            super(itemView);

            currencyIcon = itemView.findViewById(R.id.currency_icon_card_view);
            title = itemView.findViewById(R.id.title_card_view);
            amount = itemView.findViewById(R.id.amount_card_view);
        }
    }
}
