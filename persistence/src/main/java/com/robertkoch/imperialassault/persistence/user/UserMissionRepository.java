package com.robertkoch.imperialassault.persistence.user;

import com.robertkoch.imperialassault.domain.user.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by robert.koch on 2017/03/02.
 */
public interface UserMissionRepository extends JpaRepository<UserMission, Integer> {
    List<UserMission> findByUserCampaignUsernameAndUserCampaignName(String username, String userCampaignName);
    UserMission findByUserCampaignUsernameAndUserCampaignNameAndName(String username, String userCampaignName, String name);

}
