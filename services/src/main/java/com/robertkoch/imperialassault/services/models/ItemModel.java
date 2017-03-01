package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.Item;
import com.robertkoch.imperialassault.domain.enums.ItemTier;
import com.robertkoch.imperialassault.domain.enums.ItemType;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/22.
 */
public class ItemModel {
    @NotNull
    private String itemName;

    @NotNull
    private String expansionName;

    @NotNull
    private ItemTier itemTier;

    @NotNull
    private ItemType itemType;

    @NotNull
    private int itemCost;

    private String imageURL;

    public ItemModel() {
    }

    public ItemModel(String itemName, String expansionName, ItemTier itemTier, ItemType itemType, int itemCost, String imageURL) {
        this.itemName = itemName;
        this.expansionName = expansionName;
        this.itemTier = itemTier;
        this.itemType = itemType;
        this.itemCost = itemCost;
        this.imageURL = imageURL;
    }

    public ItemModel(Item item) {
        this.itemName = item.getName();
        this.expansionName = item.getExpansion().getName();
        this.itemTier = item.getItemTier();
        this.itemType = item.getItemType();
        this.itemCost = item.getItemCost();
        this.imageURL = item.getImageURL();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public ItemTier getItemTier() {
        return itemTier;
    }

    public void setItemTier(ItemTier itemTier) {
        this.itemTier = itemTier;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
