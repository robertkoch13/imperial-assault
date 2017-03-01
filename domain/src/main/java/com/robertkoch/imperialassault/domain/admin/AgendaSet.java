package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByNameFromExpansion;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/22.
 */
@Entity
@Table(name="agenda_sets")
public class AgendaSet extends IdentifiableGameComponentByNameFromExpansion implements Serializable {
    public static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agendaSet")
    private List<AgendaCard> agendaCards = new ArrayList<>();

    public AgendaSet() {
        super("AgendaSet");
    }

    public AgendaSet(String name, String imageURL, Expansion expansion) {
        super(name, imageURL, "AgendaSet", expansion);
    }

    public List<AgendaCard> getAgendaCards() {
        return agendaCards;
    }

    public void setAgendaCards(List<AgendaCard> agendaCards) {
        this.agendaCards = agendaCards;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getType(), getName(), getExpansion().toString());
    }

}
