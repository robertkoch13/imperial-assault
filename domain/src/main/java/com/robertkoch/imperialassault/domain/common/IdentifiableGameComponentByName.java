package com.robertkoch.imperialassault.domain.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Created by robert.koch on 2017/02/17.
 */
@MappedSuperclass
public class IdentifiableGameComponentByName extends IdentifiableEntityByName {
    @Transient
    private String type;

    @Column(name = "image")
    private String imageURL;

    public IdentifiableGameComponentByName(String type) {
        this.type = type;
    }

    public IdentifiableGameComponentByName(String name, String imageURL, String type) {
        super(name);
        this.imageURL = imageURL;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
