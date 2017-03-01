package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/23.
 */
public enum PlayerType {
    Rebel("Rebel"),
    Empire("Empire");

    private String playerType;

    PlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPlayerType() {
        return playerType;
    }

    @Override
    public String toString() {
        return playerType;
    }
}
