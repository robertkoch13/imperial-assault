package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByNameFromExpansion;
import com.robertkoch.imperialassault.domain.enums.AgendaType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/22.
 */
@Entity
@Table(name="agenda_cards")
public class AgendaCard extends IdentifiableGameComponentByNameFromExpansion implements Serializable {

    @Column(name="agenda_type")
    @Enumerated(EnumType.STRING)
    private AgendaType agendaType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agenda_set", nullable = false)
    private AgendaSet agendaSet;

    @Column(name = "influence_cost")
    private short influenceCost;

    public AgendaCard() {
        super("AgendaCard");
    }

    public AgendaCard(String name, String imageURL, Expansion expansion, AgendaSet agendaSet, AgendaType agendaType, short influenceCost) {
        super(name, imageURL, "AgendaCard", expansion);
        this.agendaSet = agendaSet;
        this.agendaType = agendaType;
        this.influenceCost = influenceCost;
    }

    public AgendaSet getAgendaSet() {
        return agendaSet;
    }

    public void setAgendaSet(AgendaSet agendaSet) {
        this.agendaSet = agendaSet;
    }

    public short getInfluenceCost() {
        return influenceCost;
    }

    public void setInfluenceCost(short influenceCost) {
        this.influenceCost = influenceCost;
    }

    public AgendaType getAgendaType() {
        return agendaType;
    }

    public void setAgendaType(AgendaType agendaType) {
        this.agendaType = agendaType;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getType(), getName(), getExpansion().toString());
    }
}
