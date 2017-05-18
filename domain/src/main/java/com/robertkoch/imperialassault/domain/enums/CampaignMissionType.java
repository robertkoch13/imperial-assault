package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/03/02.
 */
public enum CampaignMissionType {
    Story("Story"),
    Side("Side"),
    Forced("Forced");

    private String campaignMissionType;

    CampaignMissionType(String campaignMissionType) {
        this.campaignMissionType = campaignMissionType;
    }

    public String getCampaignMissionType() {
        return campaignMissionType;
    }

    @Override
    public String toString() {
        return campaignMissionType;
    }
}
