package com.robertkoch.imperialassault.domain.common;

import javax.persistence.*;

@MappedSuperclass
public class IdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private Long version;

    public int getId() {
        return this.id;
    }

    public Long getVersion() {
        return this.version;
    }
}
