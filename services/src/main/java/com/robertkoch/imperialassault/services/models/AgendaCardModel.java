package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.AgendaCard;
import com.robertkoch.imperialassault.domain.enums.AgendaType;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/22.
 */
public class AgendaCardModel {
    @NotNull
    private String agendaCardName;

    @NotNull
    private String expansionName;

    @NotNull
    private String agendaSetName;

    @NotNull
    private AgendaType agendaType;

    @NotNull
    private short influenceCost;

    private String imageURL;

    public AgendaCardModel() {
    }

    public AgendaCardModel(String agendaCardName, String expansionName, String agendaSetName, AgendaType agendaType, short influenceCost, String imageURL) {
        this.agendaCardName = agendaCardName;
        this.expansionName = expansionName;
        this.agendaSetName = agendaSetName;
        this.agendaType = agendaType;
        this.influenceCost = influenceCost;
        this.imageURL = imageURL;
    }

    public AgendaCardModel(AgendaCard agendaCard) {
        this.agendaCardName = agendaCard.getName();
        this.expansionName = agendaCard.getExpansion().getName();
        this.agendaSetName = agendaCard.getAgendaSet().getName();
        this.agendaType = agendaCard.getAgendaType();
        this.influenceCost = agendaCard.getInfluenceCost();
        this.imageURL = agendaCard.getImageURL();
    }

    public String getAgendaCardName() {
        return agendaCardName;
    }

    public void setAgendaCardName(String agendaCardName) {
        this.agendaCardName = agendaCardName;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public String getAgendaSetName() {
        return agendaSetName;
    }

    public void setAgendaSetName(String agendaSetName) {
        this.agendaSetName = agendaSetName;
    }

    public AgendaType getAgendaType() {
        return agendaType;
    }

    public void setAgendaType(AgendaType agendaType) {
        this.agendaType = agendaType;
    }

    public short getInfluenceCost() {
        return influenceCost;
    }

    public void setInfluenceCost(short influenceCost) {
        this.influenceCost = influenceCost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
