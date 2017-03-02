package com.robertkoch.imperialassault.web.model;

import com.robertkoch.imperialassault.domain.enums.PlayerType;

/**
 * Created by robert.koch on 2017/03/01.
 */
public class AddXP {
    private PlayerType playerType;
    private short increaseXPBy;

    public AddXP() {
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public short getIncreaseXPBy() {
        return increaseXPBy;
    }

    public void setIncreaseXPBy(short increaseXPBy) {
        this.increaseXPBy = increaseXPBy;
    }
}
