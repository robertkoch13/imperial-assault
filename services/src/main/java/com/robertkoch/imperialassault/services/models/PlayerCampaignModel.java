package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.user.UserCampaign;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by robert.koch on 2017/02/23.
 */
public class PlayerCampaignModel {
    @NotNull
    private String name;

    @NotNull
    private String campaign;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateStarted;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateCompleted;

    @NotNull
    private short credits;

    @NotNull
    private short influence;

    public PlayerCampaignModel() {
        this.credits = 0;
        this.influence = 0;
    }

    public PlayerCampaignModel(String name, String campaign, Date dateStarted, Date dateCompleted, short credits, short influence) {
        this.name = name;
        this.campaign = campaign;
        this.dateStarted = dateStarted;
        this.dateCompleted = dateCompleted;
        this.credits = credits;
        this.influence = influence;
    }

    public PlayerCampaignModel(UserCampaign userCampaign) {
        this.name = userCampaign.getName();
        this.campaign = userCampaign.getCampaign();
        this.dateStarted = userCampaign.getDateStarted();
        this.dateCompleted = userCampaign.getDateEnded();
        this.credits = userCampaign.getCredits();
        this.influence = userCampaign.getInfluence();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public short getCredits() {
        return credits;
    }

    public void setCredits(short credits) {
        this.credits = credits;
    }

    public short getInfluence() {
        return influence;
    }

    public void setInfluence(short influence) {
        this.influence = influence;
    }

    public boolean isComplete() {
        if(this.dateCompleted == null) {
            return false;
        } else {
            return true;
        }
    }
}
