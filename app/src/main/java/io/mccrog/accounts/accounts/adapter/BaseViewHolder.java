package io.mccrog.accounts.accounts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.mccrog.accounts.model.CurrencyAccount;

abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    abstract void bind(CurrencyAccount account);
}
