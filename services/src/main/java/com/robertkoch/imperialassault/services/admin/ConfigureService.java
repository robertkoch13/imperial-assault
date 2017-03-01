package com.robertkoch.imperialassault.services.admin;

import com.robertkoch.imperialassault.domain.enums.*;
import com.robertkoch.imperialassault.services.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by robert.koch on 2017/02/16.
 */
public interface ConfigureService {
    CampaignModel addCampaign(String campaignName, String expansionName, String imageURL);
    CampaignModel addCampaign(CampaignModel campaignModel);
    CampaignModel updateCampaign(CampaignModel campaignModel);
    Page<CampaignModel> allCampaigns(Pageable pageable);
    List<CampaignModel> allCampaigns();
    CampaignModel findCampaignByName(String campaignName);
    CampaignModel getNewCampaignModel();

    ExpansionModel addExpansion(String expansionName, ExpansionType expansionType, String imageURL);
    ExpansionModel addExpansion(ExpansionModel expansionModel);
    ExpansionModel updateExpansion(ExpansionModel expansionModel);
    Page<ExpansionModel> allExpansions(Pageable pageable);
    List<ExpansionModel> allExpansions();
    ExpansionModel findExpansionByName(String expansionName);
    ExpansionModel getNewExpansionModel();

    MissionModel addMission(String missionName, String expansionName, MissionType missionType, String imageURL);
    MissionModel addMission(MissionModel missionModel);
    MissionModel updateMission(MissionModel missionModel);
    Page<MissionModel> allMissions(Pageable pageable);
    List<MissionModel> allMissions();
    MissionModel findMissionByName(String missionName);
    MissionModel getNewMissionModel();

    AgendaSetModel addAgendaSet(String agendaSetName, String expansionName, String imageURL);
    AgendaSetModel addAgendaSet(AgendaSetModel agendaSetModel);
    AgendaSetModel updateAgendaSet(AgendaSetModel agendaSetModel);
    Page<AgendaSetModel> allAgendaSets(Pageable pageable);
    List<AgendaSetModel> allAgendaSets();
    AgendaSetModel findAgendaSetByName(String agendaSetName);
    AgendaSetModel getNewAgendaSetModel();

    AgendaCardModel addAgendaCard(String agendaCardName, String expansionName, String agendaSetName, AgendaType agendaType, short influenceCost, String imageURL);
    AgendaCardModel addAgendaCard(AgendaCardModel agendaCardModel);
    AgendaCardModel updateAgendaCard(AgendaCardModel agendaCardModel);
    Page<AgendaCardModel> allAgendaCards(Pageable pageable);
    List<AgendaCardModel> allAgendaCards();
    AgendaCardModel findAgendaCardByName(String agendaCardName);
    AgendaCardModel getNewAgendaCardModel();

    ItemModel addItem(String itemName, String expansionName, ItemTier itemTier, ItemType itemType, int itemCost, String imageURL);
    ItemModel addItem(ItemModel itemModel);
    ItemModel updateItem(ItemModel itemModel);
    Page<ItemModel> allItems(Pageable pageable);
    List<ItemModel> allItems();
    ItemModel findItemByName(String itemName);
    ItemModel getNewItemModel();

    PlayerClassModel addPlayerClass(String playerClassName, String expansionName, PlayerType classType, String imageURL);
    PlayerClassModel addPlayerClass(PlayerClassModel playerClassModel);
    PlayerClassModel updatePlayerClass(PlayerClassModel playerClassModel);
    Page<PlayerClassModel> allPlayerClasses(Pageable pageable);
    List<PlayerClassModel> allPlayerClasses();
    PlayerClassModel findPlayerClassByName(String playerClassName);
    PlayerClassModel getNewPlayerClassModel();

}
