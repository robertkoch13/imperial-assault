package com.robertkoch.imperialassault.domain.user;

import com.robertkoch.imperialassault.domain.common.IdentifiableEntity;
import com.robertkoch.imperialassault.domain.enums.PlayerType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/23.
 */
@Entity
@Table(name = "user_players")
public class UserPlayer extends IdentifiableEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "campaignid", nullable = false)
    private UserCampaign userCampaign;

    @Column(name = "player_name")
    private String name;

    @Column(name="player_type")
    @Enumerated(EnumType.STRING)
    private PlayerType playerType;

    @Column(name = "player_class")
    private String playerClass;

    @Column(name = "player_xp")
    private short XP;

    public UserPlayer() {
        this.XP = 0;
    }

    public UserPlayer(UserCampaign userCampaign, String name, PlayerType playerType, String playerClass) {
        this();
        this.userCampaign = userCampaign;
        this.name = name;
        this.playerType = playerType;
        this.playerClass = playerClass;
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

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public short getXP() {
        return XP;
    }

    public void setXP(short XP) {
        this.XP = XP;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.playerClass.toString());
    }

}
