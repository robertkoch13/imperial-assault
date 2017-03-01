package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.Expansion;
import com.robertkoch.imperialassault.domain.enums.ExpansionType;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/17.
 */
public class ExpansionModel {
    @NotNull
    private String expansionName;

    @NotNull
    private ExpansionType expansionType;

    private String imageURL;

    public ExpansionModel() {
    }

    public ExpansionModel(String expansionName, ExpansionType expansionType, String imageURL) {
        this.expansionName = expansionName;
        this.expansionType = expansionType;
        this.imageURL = imageURL;
    }

    public ExpansionModel(Expansion expansion) {
        this.expansionName = expansion.getName();
        this.expansionType = expansion.getExpansionType();
        this.imageURL = expansion.getImageURL();
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public ExpansionType getExpansionType() {
        return expansionType;
    }

    public void setExpansionType(ExpansionType expansionType) {
        this.expansionType = expansionType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
