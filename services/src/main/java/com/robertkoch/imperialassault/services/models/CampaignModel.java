package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.Campaign;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/17.
 */
public class CampaignModel {
    @NotNull
    private String campaignName;

    @NotNull
    private String expansionName;

    private String imageURL;

    public CampaignModel() {
    }

    public CampaignModel(String campaignName, String expansionName, String imageURL) {
        this.campaignName = campaignName;
        this.expansionName = expansionName;
        this.imageURL = imageURL;
    }

    public CampaignModel(Campaign campaign) {
        this.campaignName = campaign.getName();
        this.expansionName = campaign.getExpansion().getName();
        this.imageURL = campaign.getImageURL();
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
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
