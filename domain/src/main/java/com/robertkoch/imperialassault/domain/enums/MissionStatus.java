package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/03/03.
 */
public enum MissionStatus {
    Active("Active"),
    Inactive("Inactive"),
    Completed("Completed"),
    Discarded("Discarded");

    private String missionStatus;

    MissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    @Override
    public String toString() {
        return missionStatus;
    }
}
