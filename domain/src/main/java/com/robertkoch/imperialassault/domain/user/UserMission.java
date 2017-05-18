package com.robertkoch.imperialassault.domain.user;

import com.robertkoch.imperialassault.domain.common.IdentifiableEntity;
import com.robertkoch.imperialassault.domain.enums.CampaignMissionType;
import com.robertkoch.imperialassault.domain.enums.MissionStatus;
import com.robertkoch.imperialassault.domain.enums.MissionType;
import com.robertkoch.imperialassault.domain.enums.PlayerType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by robert.koch on 2017/03/02.
 */
@Entity
@Table(name="user_missions")
public class UserMission extends IdentifiableEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaignid", nullable = false)
    private UserCampaign userCampaign;

    @Column(name = "mission_name")
    private String name;

    @Column(name="mission_type")
    @Enumerated(EnumType.STRING)
    private MissionType missionType;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    @Column(name="victory_type")
    @Enumerated(EnumType.STRING)
    private PlayerType victoryType;

    @Temporal(TemporalType.DATE)
    @Column(name="date_completed")
    private Date completedDate;

    private String details;

    @Column(name="reward_credits")
    private short rewardCredits;

    @Column(name="reward_xp_imperial")
    private short rewardXPImperial;

    @Column(name="reward_xp_rebel")
    private short rewardXPRebels;

    @Column(name="reward_influence")
    private short rewardInfluence;

    public UserMission() {
        this.rewardCredits = 0;
        this.rewardInfluence = 0;
        this.rewardXPImperial = 0;
        this.rewardXPRebels = 0;
        this.missionStatus = MissionStatus.Inactive;
    }

    public UserMission(UserCampaign userCampaign, String name, MissionType missionType) {
        this();
        this.userCampaign = userCampaign;
        this.name = name;
        this.missionType = missionType;
    }

    public UserCampaign getUserCampaign() {
        return userCampaign;
    }

    public void setUserCampaign(UserCampaign userCampaign) {
        this.userCampaign = userCampaign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType missionType) {
        this.missionType = missionType;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(MissionStatus missionStatus) {
        this.missionStatus = missionStatus;
    }

    public PlayerType getVictoryType() {
        return victoryType;
    }

    public void setVictoryType(PlayerType victoryType) {
        this.victoryType = victoryType;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
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

    public short getRewardInfluence() {
        return rewardInfluence;
    }

    public void setRewardInfluence(short rewardInfluence) {
        this.rewardInfluence = rewardInfluence;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.missionType.toString());
    }

}
