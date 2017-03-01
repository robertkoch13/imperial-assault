package com.robertkoch.imperialassault.persistence.admin;

import com.robertkoch.imperialassault.domain.admin.PlayerClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/27.
 */
public interface PlayerClassRepository extends JpaRepository<PlayerClass, String> {
    PlayerClass findByName(String name);
}
