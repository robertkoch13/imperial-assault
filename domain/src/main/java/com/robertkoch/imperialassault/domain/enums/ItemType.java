package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/22.
 */
public enum ItemType {
    Ranged("Ranged"),
    Melee("Melee"),
    RangedUpgrade("RangedUpgrade"),
    MeleeUpgrade("MeleeUpgrade"),
    Armour("Armour"),
    Accessory("Accessory");

    private String itemType;

    ItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return itemType;
    }
}
