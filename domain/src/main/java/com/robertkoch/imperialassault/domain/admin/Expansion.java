package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.enums.ExpansionType;
import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/17.
 */
@Entity
@Table(name="expansions")
public class Expansion extends IdentifiableGameComponentByName implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name="expansion_type")
    @Enumerated(EnumType.STRING)
    private ExpansionType expansionType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expansion")
    private List<Campaign> campaigns = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expansion")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expansion")
    private List<AgendaSet> agendaSets = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expansion")
    private List<AgendaCard> agendaCards = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expansion")
    private List<Item> items = new ArrayList<>();

    public Expansion() {
        super("Expansion");
    }

    public Expansion(String name, String imageURL, ExpansionType expansionType) {
        super(name, imageURL, "Expansion");
        this.expansionType = expansionType;
    }

    public ExpansionType getExpansionType() {
        return expansionType;
    }

    public void setExpansionType(ExpansionType expansionType) {
        this.expansionType = expansionType;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public List<AgendaSet> getAgendaSets() {
        return agendaSets;
    }

    public void setAgendaSets(List<AgendaSet> agendaSets) {
        this.agendaSets = agendaSets;
    }

    public List<AgendaCard> getAgendaCards() {
        return agendaCards;
    }

    public void setAgendaCards(List<AgendaCard> agendaCards) {
        this.agendaCards = agendaCards;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getName(), this.expansionType);
    }
}
