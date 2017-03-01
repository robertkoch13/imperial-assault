package com.robertkoch.imperialassault.persistence.admin;

import com.robertkoch.imperialassault.domain.admin.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/22.
 */
public interface MissionRepository extends JpaRepository<Mission, String> {
    Mission findByName(String mission);
}
