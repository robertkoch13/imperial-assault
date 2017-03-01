package com.robertkoch.imperialassault.domain.admin;

import com.robertkoch.imperialassault.domain.common.IdentifiableGameComponentByNameFromExpansion;
import com.robertkoch.imperialassault.domain.enums.PlayerType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robert.koch on 2017/02/23.
 */
@Entity
@Table(name = "classes")
public class PlayerClass extends IdentifiableGameComponentByNameFromExpansion implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name="class_type")
    @Enumerated(EnumType.STRING)
    private PlayerType classType;

    public PlayerClass() {
        super("Class");
    }

    public PlayerClass(String name, String imageURL, PlayerType classType, Expansion expansion) {
        super(name, imageURL, "Class", expansion);
        this.classType = classType;
    }

    public PlayerType getClassType() {
        return classType;
    }

    public void setClassType(PlayerType classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", getType(), getName(), getExpansion().toString());
    }

}
