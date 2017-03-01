package com.robertkoch.imperialassault.services.user;

import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.services.models.PlayerCampaignModel;
import com.robertkoch.imperialassault.services.models.PlayerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by robert.koch on 2017/02/23.
 */
public interface PlayerService {
    PlayerCampaignModel addPlayerCampaign(String username, String campaign, String name);
    PlayerCampaignModel addPlayerCampaign(String username, PlayerCampaignModel playerCampaignModel);
    PlayerCampaignModel updatePlayerCampaign(String username, PlayerCampaignModel playerCampaignModel);
    Page<PlayerCampaignModel> allPlayerCampaigns(String username, Pageable pageable);
    List<PlayerCampaignModel> allPlayerCampaigns(String username);
    PlayerCampaignModel findPlayerCampaignByName(String username, String name);
    PlayerCampaignModel getNewPlayerCampaignModel();

    PlayerModel addPlayer(String username, String campaign, String name, PlayerType playerType, String playerClass);
    PlayerModel addPlayer(String username, PlayerModel playerModel);
    PlayerModel updatePlayer(String username, PlayerModel playerModel);
    List<PlayerModel> allPlayers(String username, String campaignName);
    PlayerModel findPlayerByName(String username, String campaignName, String name);
    PlayerModel getNewPlayerModel();
}
