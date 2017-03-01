package com.robertkoch.imperialassault.domain.enums;

/**
 * Created by robert.koch on 2017/02/22.
 */
public enum AgendaType {
    Place("Place"),
    Discard("Discard"),
    DiscardOrShuffle("DiscardOrShuffle"),
    SideMission("SideMission"),
    ForcedMission("ForcedMission");

    private String agendaType;

    AgendaType(String agendaType) {
        this.agendaType = agendaType;
    }

    public String getAgendaType() {
        return agendaType;
    }

    public void setAgendaType(String agendaType) {
        this.agendaType = agendaType;
    }

    @Override
    public String toString() {
        return agendaType;
    }
}
