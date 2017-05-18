package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.enums.CampaignMissionType;
import com.robertkoch.imperialassault.domain.enums.MissionStatus;
import com.robertkoch.imperialassault.domain.enums.MissionType;
import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.domain.user.UserMission;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by robert.koch on 2017/03/02.
 */
public class PlayerMissionModel {
    @NotNull
    private String name;

    @NotNull
    private String playerCampaignName;

    @NotNull
    private MissionType missionType;

    @NotNull
    private MissionStatus missionStatus;

    private PlayerType victoryType;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateCompleted;

    private String details;

    private short rewardCredits;

    private short rewardInfluence;

    private short rewardXPImperial;

    private short rewardXPRebels;

    public PlayerMissionModel() {
    }

    public PlayerMissionModel(String name, String playerCampaignName, MissionType missionType, MissionStatus missionStatus, PlayerType victoryType, Date dateCompleted, String details, short rewardCredits, short rewardInfluence, short rewardXPImperial, short rewardXPRebels) {
        this.name = name;
        this.playerCampaignName = playerCampaignName;
        this.missionType = missionType;
        this.missionStatus = missionStatus;
        this.victoryType = victoryType;
        this.dateCompleted = dateCompleted;
        this.details = details;
        this.rewardCredits = rewardCredits;
        this.rewardInfluence = rewardInfluence;
        this.rewardXPImperial = rewardXPImperial;
        this.rewardXPRebels = rewardXPRebels;
    }

    public PlayerMissionModel(UserMission userMission) {
        this.name = userMission.getName();
        this.playerCampaignName = userMission.getUserCampaign().getName();
        this.missionType = userMission.getMissionType();
        this.missionStatus = userMission.getMissionStatus();
        this.victoryType = userMission.getVictoryType();
        this.dateCompleted = userMission.getCompletedDate();
        this.details = userMission.getDetails();
        this.rewardCredits = userMission.getRewardCredits();
        this.rewardInfluence = userMission.getRewardInfluence();
        this.rewardXPImperial = userMission.getRewardXPImperial();
        this.rewardXPRebels = userMission.getRewardXPRebels();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerCampaignName() {
        return playerCampaignName;
    }

    public void setPlayerCampaignName(String playerCampaignName) {
        this.playerCampaignName = playerCampaignName;
    }

    public CampaignMissionType getCampaignMissionType() {
        if(this.missionType == MissionType.Story)
            return CampaignMissionType.Story;
        else if(this.missionType == MissionType.Forced)
            return CampaignMissionType.Forced;
        else
            return CampaignMissionType.Side;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(MissionStatus missionStatus) {
        this.missionStatus = missionStatus;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType missionType) {
        this.missionType = missionType;
    }

    public PlayerType getVictoryType() {
        return victoryType;
    }

    public void setVictoryType(PlayerType victoryType) {
        this.victoryType = victoryType;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public short getRewardCredits() {
        return rewardCredits;
    }

    public void setRewardCredits(short rewardCredits) {
        this.rewardCredits = rewardCredits;
    }

    public short getRewardInfluence() {
        return rewardInfluence;
    }

    public void setRewardInfluence(short rewardInfluence) {
        this.rewardInfluence = rewardInfluence;
    }

    public short getRewardXPImperial() {
        return rewardXPImperial;
    }

    public void setRewardXPImperial(short rewardXPImperial) {
        this.rewardXPImperial = rewardXPImperial;
    }

    public short getRewardXPRebels() {
        return rewardXPRebels;
    }

    public void setRewardXPRebels(short rewardXPRebels) {
        this.rewardXPRebels = rewardXPRebels;
    }

    public String getType() { return String.format("%s (%s)", getCampaignMissionType(), getMissionType()); }
}
