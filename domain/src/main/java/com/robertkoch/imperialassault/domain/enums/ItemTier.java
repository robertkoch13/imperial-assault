package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/22.
 */
public enum ItemTier {
    Tier1("Tier1"),
    Tier2("Tier2"),
    Tier3("Tier3");

    private String itemTier;

    ItemTier(String itemTier) {
        this.itemTier = itemTier;
    }

    public String getItemTier() {
        return itemTier;
    }

    @Override
    public String toString() {
        return itemTier;
    }
}
