package com.robertkoch.imperialassault.services.user.impl;

import com.robertkoch.imperialassault.domain.enums.CampaignMissionType;
import com.robertkoch.imperialassault.domain.enums.MissionType;
import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.domain.user.UserCampaign;
import com.robertkoch.imperialassault.domain.user.UserMission;
import com.robertkoch.imperialassault.domain.user.UserPlayer;
import com.robertkoch.imperialassault.persistence.user.UserCampaignRepository;
import com.robertkoch.imperialassault.persistence.user.UserMissionRepository;
import com.robertkoch.imperialassault.persistence.user.UserPlayerRepository;
import com.robertkoch.imperialassault.services.models.PlayerCampaignModel;
import com.robertkoch.imperialassault.services.models.PlayerMissionModel;
import com.robertkoch.imperialassault.services.models.PlayerModel;
import com.robertkoch.imperialassault.services.user.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/23.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    private UserCampaignRepository userCampaignRepository;
    private UserPlayerRepository userPlayerRepository;
    private UserMissionRepository userMissionRepository;

    @Autowired
    public PlayerServiceImpl(UserCampaignRepository userCampaignRepository,
                             UserPlayerRepository userPlayerRepository,
                             UserMissionRepository userMissionRepository) {
        this.userCampaignRepository = userCampaignRepository;
        this.userPlayerRepository = userPlayerRepository;
        this.userMissionRepository = userMissionRepository;
    }

    @Override
    @Transactional
    public PlayerCampaignModel addPlayerCampaign(String username, String campaignName, String name) {
        return new PlayerCampaignModel(userCampaignRepository.save(new UserCampaign(username, campaignName, name)));
    }

    @Override
    public PlayerCampaignModel addPlayerCampaign(String username, PlayerCampaignModel playerCampaignModel) {
        return addPlayerCampaign(username, playerCampaignModel.getCampaign(), playerCampaignModel.getName());
    }

    @Override
    @Transactional
    public PlayerCampaignModel updatePlayerCampaign(String username, String campaignName, PlayerCampaignModel playerCampaignModel) {
        UserCampaign userCampaign = userCampaignRepository.findByUsernameAndName(username, campaignName);
        userCampaign.setName(playerCampaignModel.getName());
        userCampaign.setDateStarted(playerCampaignModel.getDateStarted());
        userCampaign.setDateEnded(playerCampaignModel.getDateCompleted());
        userCampaign.setCredits(playerCampaignModel.getCredits());
        userCampaign.setInfluence(playerCampaignModel.getInfluence());
        return new PlayerCampaignModel(userCampaignRepository.save(userCampaign));
    }

    @Override
    public Page<PlayerCampaignModel> allPlayerCampaigns(String username, Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("complete") || orders.getProperty().equals("dateCompleted")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "dateEnded"));
                } else {
                    newOrders.add(new Sort.Order(orders.getDirection(), orders.getProperty()));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        } else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<UserCampaign> page = userCampaignRepository.findByUsername(username, newPageable);
        List<PlayerCampaignModel> playerCampaignModels = new ArrayList<>();
        for(UserCampaign userCampaign : page.getContent()) {
            playerCampaignModels.add(new PlayerCampaignModel(userCampaign));
        }
        return new PageImpl<>(playerCampaignModels, pageable, page.getTotalElements());
    }

    @Override
    public List<PlayerCampaignModel> allPlayerCampaigns(String username) {
        List<PlayerCampaignModel> playerCampaignModels = new ArrayList<>();
        for(UserCampaign userCampaign : userCampaignRepository.findByUsername(username)) {
            playerCampaignModels.add(new PlayerCampaignModel(userCampaign));
        }
        return playerCampaignModels;
    }

    @Override
    public PlayerCampaignModel findPlayerCampaignByName(String username, String name) {
        return new PlayerCampaignModel(userCampaignRepository.findByUsernameAndName(username, name));
    }

    @Override
    public PlayerCampaignModel getNewPlayerCampaignModel() {
        return new PlayerCampaignModel();
    }

    @Override
    @Transactional
    public PlayerModel addPlayer(String username, String campaignName, String name, PlayerType playerType, String playerClass) {
        UserCampaign userCampaign = userCampaignRepository.findByUsernameAndName(username, campaignName);
        return new PlayerModel(userPlayerRepository.save(new UserPlayer(userCampaign, name, playerType, playerClass)));
    }

    @Override
    public PlayerModel addPlayer(String username, PlayerModel playerModel) {
        return addPlayer(username, playerModel.getPlayerCampaignName(), playerModel.getName(), playerModel.getPlayerType(), playerModel.getPlayerClass());
    }

    @Override
    @Transactional
    public PlayerModel updatePlayer(String username, PlayerModel playerModel) {
        UserPlayer userPlayer = userPlayerRepository.findByUserCampaignUsernameAndUserCampaignNameAndName(username, playerModel.getPlayerCampaignName(), playerModel.getName());
        userPlayer.setPlayerType(playerModel.getPlayerType());
        userPlayer.setPlayerClass(playerModel.getPlayerClass());
        userPlayer.setXP(playerModel.getXP());
        return new PlayerModel(userPlayerRepository.save(userPlayer));
    }

    @Override
    public List<PlayerModel> allPlayers(String username, String campaignName) {
        List<PlayerModel> playerModels = new ArrayList<>();
        for(UserPlayer userPlayer : userPlayerRepository.findByUserCampaignUsernameAndUserCampaignName(username, campaignName)) {
            playerModels.add(new PlayerModel(userPlayer));
        }
        return playerModels;
    }

    @Override
    public PlayerModel findPlayerByName(String username, String campaignName, String name) {
        return new PlayerModel(userPlayerRepository.findByUserCampaignUsernameAndUserCampaignNameAndName(username, campaignName, name));
    }

    @Override
    public PlayerModel getNewPlayerModel() {
        return new PlayerModel();
    }

    @Override
    public void addXP(String username, String campaignName, PlayerType playerType, short increaseXPBy) {
        for(UserPlayer userPlayer : userPlayerRepository.findByUserCampaignUsernameAndUserCampaignNameAndPlayerType(username, campaignName, playerType)) {
            userPlayer.setXP((short)(userPlayer.getXP() + increaseXPBy));
            userPlayerRepository.save(userPlayer);
        }
    }

    @Override
    @Transactional
    public PlayerMissionModel addPlayerMission(String username, String campaignName, String name, MissionType missionType) {
        UserCampaign userCampaign = userCampaignRepository.findByUsernameAndName(username, campaignName);
        return new PlayerMissionModel(userMissionRepository.save(new UserMission(userCampaign, name, missionType)));
    }

    @Override
    public PlayerMissionModel addPlayerMission(String username, PlayerMissionModel playerMissionModel) {
        return addPlayerMission(username, playerMissionModel.getPlayerCampaignName(), playerMissionModel.getName(), playerMissionModel.getMissionType());
    }

    @Override
    @Transactional
    public PlayerMissionModel updatePlayerMission(String username, PlayerMissionModel playerMissionModel) {
        UserMission userMission = userMissionRepository.findByUserCampaignUsernameAndUserCampaignNameAndName(username, playerMissionModel.getPlayerCampaignName(), playerMissionModel.getName());
        userMission.setMissionStatus(playerMissionModel.getMissionStatus());
        userMission.setCompletedDate(playerMissionModel.getDateCompleted());
        userMission.setDetails(playerMissionModel.getDetails());
        userMission.setVictoryType(playerMissionModel.getVictoryType());
        userMission.setRewardCredits(playerMissionModel.getRewardCredits());
        userMission.setRewardInfluence(playerMissionModel.getRewardInfluence());
        userMission.setRewardXPImperial(playerMissionModel.getRewardXPImperial());
        userMission.setRewardXPRebels(playerMissionModel.getRewardXPRebels());
        userMission.setMissionType(playerMissionModel.getMissionType());
        return new PlayerMissionModel(userMissionRepository.save(userMission));
    }

    @Override
    public List<PlayerMissionModel> allPlayerMissions(String username, String campaignName) {
        List<PlayerMissionModel> playerMissionModels = new ArrayList<>();
        for(UserMission userMission : userMissionRepository.findByUserCampaignUsernameAndUserCampaignName(username, campaignName)) {
            playerMissionModels.add(new PlayerMissionModel(userMission));
        }
        return playerMissionModels;
    }

    @Override
    public PlayerMissionModel findPlayerMissionByName(String username, String campaignName, String name) {
        return new PlayerMissionModel(userMissionRepository.findByUserCampaignUsernameAndUserCampaignNameAndName(username, campaignName, name));
    }

    @Override
    public PlayerMissionModel getNewPlayerMissionModel() {
        return new PlayerMissionModel();
    }
}
