package com.robertkoch.imperialassault.domain.common;

import javax.persistence.*;

@MappedSuperclass
public class IdentifiableEntityByName {

    @Id
    private String name;

    @Version
    private Long version;

    public IdentifiableEntityByName() {
    }

    public IdentifiableEntityByName(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Long getVersion() {
        return this.version;
    }
}
