package io.mccrog.accounts.accounts.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.mccrog.accounts.R;
import io.mccrog.accounts.model.CurrencyAccount;

class AccountViewHolder extends BaseViewHolder {

    private ImageView currencyIcon;
    private TextView title;
    private TextView amount;

    AccountViewHolder(@NonNull View itemView) {
        super(itemView);
        currencyIcon = itemView.findViewById(R.id.currency_icon_card_view);
        title = itemView.findViewById(R.id.title_card_view);
        amount = itemView.findViewById(R.id.amount_card_view);
    }

    @Override
    void bind(CurrencyAccount account) {
        title.setText(account.getTitle());
        amount.setText(String.valueOf(account.getAmount()));
        currencyIcon.setImageResource(account.getCurrencyType().getDrawableId());
    }
}
