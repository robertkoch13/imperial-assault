package com.robertkoch.imperialassault.persistence.user;

import com.robertkoch.imperialassault.domain.user.UserCampaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by robert.koch on 2017/02/23.
 */
public interface UserCampaignRepository extends JpaRepository<UserCampaign, Integer> {
    Page<UserCampaign> findByUsername(String username, Pageable pageable);
    List<UserCampaign> findByUsername(String username);
    UserCampaign findByUsernameAndName(String username, String name);
}
