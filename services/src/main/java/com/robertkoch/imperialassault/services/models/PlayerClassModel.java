package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.PlayerClass;
import com.robertkoch.imperialassault.domain.enums.PlayerType;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/27.
 */
public class PlayerClassModel {
    @NotNull
    private String className;

    @NotNull
    private String expansionName;

    @NotNull
    private PlayerType classType;

    private String imageURL;

    public PlayerClassModel() {
    }

    public PlayerClassModel(String className, String expansionName, PlayerType classType, String imageURL) {
        this.className = className;
        this.expansionName = expansionName;
        this.classType = classType;
        this.imageURL = imageURL;
    }

    public PlayerClassModel(PlayerClass playerClass) {
        this.className = playerClass.getName();
        this.classType = playerClass.getClassType();
        this.expansionName = playerClass.getExpansion().getName();
        this.imageURL = playerClass.getImageURL();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public PlayerType getClassType() {
        return classType;
    }

    public void setClassType(PlayerType classType) {
        this.classType = classType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
