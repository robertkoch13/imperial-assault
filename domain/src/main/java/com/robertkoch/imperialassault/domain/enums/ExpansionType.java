package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/17.
 */
public enum ExpansionType {
    Core("Core"),
    BigBox("BigBox"),
    SmallBox("SmallBox"),
    AllyPack("AllyPack"),
    VillainPack("VillainPack");

    private String expansionType;

    ExpansionType(String expansionType) {
        this.expansionType = expansionType;
    }

    public String getExpansionType() {
        return expansionType;
    }

    @Override
    public String toString() {
        return expansionType;
    }
}
