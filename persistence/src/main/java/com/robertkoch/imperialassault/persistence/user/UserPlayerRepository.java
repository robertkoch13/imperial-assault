package com.robertkoch.imperialassault.persistence.user;

import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.domain.user.UserPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by robert.koch on 2017/02/23.
 */
public interface UserPlayerRepository extends JpaRepository<UserPlayer, Integer> {
    List<UserPlayer> findByUserCampaignUsernameAndUserCampaignName(String username, String userCampaignName);
    UserPlayer findByUserCampaignUsernameAndUserCampaignNameAndName(String username, String userCampaignName, String name);
    List<UserPlayer> findByUserCampaignUsernameAndUserCampaignNameAndPlayerType(String username, String userCampaignName, PlayerType playerType);
}
