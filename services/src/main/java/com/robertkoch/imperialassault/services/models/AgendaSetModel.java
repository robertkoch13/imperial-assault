package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.AgendaSet;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/22.
 */
public class AgendaSetModel {
    @NotNull
    private String agendaSetName;

    @NotNull
    private String expansionName;

    private String imageURL;

    public AgendaSetModel() {
    }

    public AgendaSetModel(String agendaSetName, String expansionName, String imageURL) {
        this.agendaSetName = agendaSetName;
        this.expansionName = expansionName;
        this.imageURL = imageURL;
    }

    public AgendaSetModel(AgendaSet agendaSet) {
        this.agendaSetName = agendaSet.getName();
        this.expansionName = agendaSet.getExpansion().getName();
        this.imageURL = agendaSet.getImageURL();
    }

    public String getAgendaSetName() {
        return agendaSetName;
    }

    public void setAgendaSetName(String agendaSetName) {
        this.agendaSetName = agendaSetName;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
