package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByNameFromExpansion;
import com.robertkoch.imperialassault.domain.enums.ItemTier;
import com.robertkoch.imperialassault.domain.enums.ItemType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/22.
 */
@Entity
@Table(name = "items")
public class Item extends IdentifiableGameComponentByNameFromExpansion implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name="item_tier")
    @Enumerated(EnumType.STRING)
    private ItemTier itemTier;

    @Column(name="item_type")
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(name="item_cost")
    private int itemCost;

    public Item() {
        super("Item");
    }

    public Item(String name, String imageURL, Expansion expansion, ItemTier itemTier, ItemType itemType, int itemCost) {
        super(name, imageURL, "Item", expansion);
        this.itemTier = itemTier;
        this.itemType = itemType;
        this.itemCost = itemCost;
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

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getType(), getName(), getExpansion().toString());
    }

}
