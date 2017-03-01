package com.robertkoch.imperialassault.domain.user;

import com.robertkoch.imperialassault.domain.common.IdentifiableEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/23.
 */
@Entity
@Table(name = "user_campaign")
public class UserCampaign extends IdentifiableEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "username")
    private String username;

    private String campaign;

    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="date_started")
    private Date dateStarted;

    @Temporal(TemporalType.DATE)
    @Column(name="date_ended")
    private Date dateEnded;

    @Column(name = "amount_of_credits")
    private short credits;

    @Column(name = "amount_of_influence")
    private short influence;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userCampaign")
    private List<UserPlayer> userPlayers = new ArrayList<>();

    public UserCampaign() {
        this.dateStarted = new Date();
        this.credits = 0;
        this.influence = 0;
    }

    public UserCampaign(String username, String campaign, String name) {
        this();
        this.username = username;
        this.campaign = campaign;
        this.name = name;
    }

    public String getAssociatedUsername() {
        return username;
    }

    public void setAssociatedUsername(String username) {
        this.username = username;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
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

    public List<UserPlayer> getUserPlayers() {
        return userPlayers;
    }

    public void setUserPlayers(List<UserPlayer> userPlayers) {
        this.userPlayers = userPlayers;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.campaign.toString());
    }
}
