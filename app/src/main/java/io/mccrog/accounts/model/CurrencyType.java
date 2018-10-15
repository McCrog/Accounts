package io.mccrog.accounts.model;

import io.mccrog.accounts.R;
import io.mccrog.accounts.utilities.Constants;

/**
 * {@link CurrencyType} represents an enumeration of currencies.
 */
public enum CurrencyType {
    RUB(R.drawable.ic_currency_rub, Constants.VIEW_TYPE_IMAGE_TITLE_AMOUNT),
    EUR(R.drawable.ic_currency_eur, Constants.VIEW_TYPE_TITLE_IMAGE_AMOUNT),
    USD(R.drawable.ic_currency_usd, Constants.VIEW_TYPE_TITLE_AMOUNT_IMAGE);

    private final int drawableId;
    private final int viewType;

    CurrencyType(int drawableId, int viewType) {
        this.drawableId = drawableId;
        this.viewType = viewType;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public int getViewType() {
        return viewType;
    }
}
