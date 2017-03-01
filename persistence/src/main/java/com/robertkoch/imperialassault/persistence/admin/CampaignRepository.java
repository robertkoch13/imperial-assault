package com.robertkoch.imperialassault.persistence.admin;

import com.robertkoch.imperialassault.domain.admin.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by robert.koch on 2017/02/16.
 */
public interface CampaignRepository extends JpaRepository<Campaign, String> {
    Campaign findByName(String name);
}
