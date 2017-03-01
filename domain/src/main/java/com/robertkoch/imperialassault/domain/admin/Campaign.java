package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByNameFromExpansion;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/16.
 */
@Entity
@Table(name="campaigns")
public class Campaign extends IdentifiableGameComponentByNameFromExpansion implements Serializable {
    public static final long serialVersionUID = 1L;

    public Campaign() {
        super("UserCampaign");
    }

    public Campaign(String name, String imageURL, Expansion expansion) {
        super(name, imageURL, "UserCampaign", expansion);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getType(), getName(), getExpansion().toString());
    }
}
