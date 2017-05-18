package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.admin.Mission;
import com.robertkoch.imperialassault.domain.enums.MissionType;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/22.
 */
public class MissionModel {
    @NotNull
    private String missionName;

    @NotNull
    private String expansionName;

    @NotNull
    private MissionType missionType;

    private String imageURL;

    public MissionModel() {
    }

    public MissionModel(String missionName, String expansionName, MissionType missionType, String imageURL) {
        this.missionName = missionName;
        this.expansionName = expansionName;
        this.missionType = missionType;
        this.imageURL = imageURL;
    }

    public MissionModel(Mission mission) {
        this.missionName = mission.getName();
        this.expansionName = mission.getExpansion().getName();
        this.missionType = mission.getMissionType();
        this.imageURL = mission.getImageURL();
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType missionType) {
        this.missionType = missionType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return missionName + " (" +
                expansionName + ")";
    }
}
