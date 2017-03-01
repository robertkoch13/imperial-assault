package com.robertkoch.imperialassault.services.models;

import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.domain.user.UserPlayer;

import javax.validation.constraints.NotNull;

/**
 * Created by robert.koch on 2017/02/23.
 */
public class PlayerModel {
    @NotNull
    private String name;

    @NotNull
    private String playerCampaignName;

    @NotNull
    private PlayerType playerType;

    @NotNull
    private String playerClass;

    @NotNull
    private short XP;

    public PlayerModel() {
        this.XP = 0;
    }

    public PlayerModel(String name, String playerCampaignName, PlayerType playerType, String playerClass, short XP) {
        this.name = name;
        this.playerCampaignName = playerCampaignName;
        this.playerType = playerType;
        this.playerClass = playerClass;
        this.XP = XP;
    }

    public PlayerModel(UserPlayer userPlayer) {
        this.name = userPlayer.getName();
        this.playerCampaignName = userPlayer.getUserCampaign().getName();
        this.playerType = userPlayer.getPlayerType();
        this.playerClass = userPlayer.getPlayerClass();
        this.XP = userPlayer.getXP();
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
}
