package io.mccrog.accounts.model;

/**
 * {@link Account} represents the base class of the account model.
 * It contains an id, title and an amount.
 */
class Account {
    private final String id;
    private final String title;
    private final float amount;

    Account(String id, String title, float amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getAmount() {
        return amount;
    }
}
