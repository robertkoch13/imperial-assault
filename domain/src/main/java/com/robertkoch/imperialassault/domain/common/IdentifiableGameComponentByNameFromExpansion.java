package com.robertkoch.imperialassault.domain.common;

import com.robertkoch.imperialassault.domain.admin.Expansion;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by robert.koch on 2017/02/22.
 */
@MappedSuperclass
public class IdentifiableGameComponentByNameFromExpansion extends IdentifiableGameComponentByName {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expansion", nullable = false)
    private Expansion expansion;

    public IdentifiableGameComponentByNameFromExpansion(String type) {
        super(type);
    }

    public IdentifiableGameComponentByNameFromExpansion(String name, String imageURL, String type, Expansion expansion) {
        super(name, imageURL, type);
        this.expansion = expansion;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }
}
