package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByNameFromExpansion;
import com.robertkoch.imperialassault.domain.enums.MissionType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/22.
 */
@Entity
@Table(name="missions")
public class Mission extends IdentifiableGameComponentByNameFromExpansion implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name="mission_type")
    @Enumerated(EnumType.STRING)
    private MissionType missionType;

    public Mission() {
        super("Mission");
    }

    public Mission(String name, String imageURL, MissionType missionType, Expansion expansion) {
        super(name, imageURL, "Mission", expansion);
        this.missionType = missionType;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType missionType) {
        this.missionType = missionType;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getType(), getName(), getExpansion().toString());
    }

}
