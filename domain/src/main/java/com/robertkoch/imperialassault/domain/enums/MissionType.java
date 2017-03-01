package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/22.
 */
public enum MissionType {
    Story("Story"),
    Threat("Threat"),
    Forced("Forced"),
    Agenda("Agenda"),
    Grey("Grey"),
    Green("Green"),
    Red("Red");

    private String missionType;

    MissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getMissionType() {
        return missionType;
    }

    @Override
    public String toString() {
        return missionType;
    }
}
