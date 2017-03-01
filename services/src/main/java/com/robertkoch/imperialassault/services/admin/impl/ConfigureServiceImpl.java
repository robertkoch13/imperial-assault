package com.robertkoch.imperialassault.services.admin.impl;

import com.robertkoch.imperialassault.domain.admin.*;
import com.robertkoch.imperialassault.domain.enums.*;
import com.robertkoch.imperialassault.persistence.admin.*;
import com.robertkoch.imperialassault.services.admin.ConfigureService;
import com.robertkoch.imperialassault.services.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/16.
 */
@Service
public class ConfigureServiceImpl implements ConfigureService {
    private CampaignRepository campaignRepository;
    private ExpansionRepository expansionRepository;
    private MissionRepository missionRepository;
    private AgendaSetRepository agendaSetRepository;
    private AgendaCardRepository agendaCardRepository;
    private ItemRepository itemRepository;
    private PlayerClassRepository playerClassRepository;

    @Autowired
    public ConfigureServiceImpl(CampaignRepository campaignRepository,
                                ExpansionRepository expansionRepository,
                                MissionRepository missionRepository,
                                AgendaSetRepository agendaSetRepository,
                                AgendaCardRepository agendaCardRepository,
                                ItemRepository itemRepository,
                                PlayerClassRepository playerClassRepository) {
        this.campaignRepository = campaignRepository;
        this.expansionRepository = expansionRepository;
        this.missionRepository = missionRepository;
        this.agendaSetRepository = agendaSetRepository;
        this.agendaCardRepository = agendaCardRepository;
        this.itemRepository = itemRepository;
        this.playerClassRepository = playerClassRepository;
    }

    @Override
    @Transactional
    public CampaignModel addCampaign(String campaignName, String expansionName, String imageURL) {
        Expansion expansion = expansionRepository.findByName(expansionName);
        return new CampaignModel(campaignRepository.save(new Campaign(campaignName, imageURL, expansion)));
    }

    @Override
    public CampaignModel addCampaign(CampaignModel campaignModel) {
        return addCampaign(campaignModel.getCampaignName(), campaignModel.getExpansionName(), campaignModel.getImageURL());
    }

    @Override
    @Transactional
    public CampaignModel updateCampaign(CampaignModel campaignModel) {
        Campaign campaign = campaignRepository.findByName(campaignModel.getCampaignName());
        Expansion expansion = expansionRepository.findByName(campaignModel.getExpansionName());
        campaign.setExpansion(expansion);
        campaign.setImageURL(campaignModel.getImageURL());
        return new CampaignModel(campaignRepository.save(campaign));
    }

    @Override
    public Page<CampaignModel> allCampaigns(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("campaignName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else if (orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "expansion.name"));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        } else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<Campaign> page = campaignRepository.findAll(newPageable);
        List<CampaignModel> campaignModels = new ArrayList<>();
        for(Campaign campaign : page.getContent()) {
            campaignModels.add(new CampaignModel(campaign));
        }
        return new PageImpl<>(campaignModels, pageable, page.getTotalElements());
    }

    @Override
    public List<CampaignModel> allCampaigns() {
        List<CampaignModel> campaignModels = new ArrayList<>();
        for(Campaign campaign : campaignRepository.findAll()) {
            campaignModels.add(new CampaignModel(campaign));
        }
        return campaignModels;
    }

    @Override
    public CampaignModel findCampaignByName(String campaignName) {
        return new CampaignModel(campaignRepository.findByName(campaignName));
    }

    @Override
    public CampaignModel getNewCampaignModel() {
        return new CampaignModel();
    }

    @Override
    @Transactional
    public ExpansionModel addExpansion(String expansionName, ExpansionType expansionType, String imageURL) {
        return new ExpansionModel(expansionRepository.save(new Expansion(expansionName, imageURL, expansionType)));
    }

    @Override
    public ExpansionModel addExpansion(ExpansionModel expansionModel) {
        return addExpansion(expansionModel.getExpansionName(), expansionModel.getExpansionType(), expansionModel.getImageURL());
    }

    @Override
    @Transactional
    public ExpansionModel updateExpansion(ExpansionModel expansionModel) {
        Expansion expansion = expansionRepository.findByName(expansionModel.getExpansionName());
        expansion.setImageURL(expansionModel.getImageURL());
        expansion.setExpansionType(expansionModel.getExpansionType());
        return new ExpansionModel(expansionRepository.save(expansion));
    }

    @Override
    public Page<ExpansionModel> allExpansions(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else {
                    newOrders.add(new Sort.Order(orders.getDirection(), orders.getProperty()));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        }
        else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<Expansion> page = expansionRepository.findAll(newPageable);
        List<ExpansionModel> expansionModels = new ArrayList<>();
        for(Expansion expansion : page.getContent()) {
            expansionModels.add(new ExpansionModel(expansion));
        }
        return new PageImpl<>(expansionModels, pageable, page.getTotalElements());
    }

    @Override
    public List<ExpansionModel> allExpansions() {
        List<ExpansionModel> expansionModels = new ArrayList<>();
        for(Expansion expansion : expansionRepository.findAll()) {
            expansionModels.add(new ExpansionModel(expansion));
        }
        return expansionModels;
    }

    @Override
    public ExpansionModel findExpansionByName(String expansionName) {
        return new ExpansionModel(expansionRepository.findByName(expansionName));
    }

    @Override
    public ExpansionModel getNewExpansionModel() {
        return new ExpansionModel();
    }

    @Override
    @Transactional
    public MissionModel addMission(String missionName, String expansionName, MissionType missionType, String imageURL) {
        Expansion expansion = expansionRepository.findByName(expansionName);
        return new MissionModel(missionRepository.save(new Mission(missionName, imageURL, missionType, expansion)));
    }

    @Override
    public MissionModel addMission(MissionModel missionModel) {
        return addMission(missionModel.getMissionName(), missionModel.getExpansionName(), missionModel.getMissionType(), missionModel.getImageURL());
    }

    @Override
    @Transactional
    public MissionModel updateMission(MissionModel missionModel) {
        Mission mission = missionRepository.findByName(missionModel.getMissionName());
        Expansion expansion = expansionRepository.findByName(missionModel.getExpansionName());
        mission.setExpansion(expansion);
        mission.setMissionType(missionModel.getMissionType());
        mission.setImageURL(missionModel.getImageURL());
        return new MissionModel(missionRepository.save(mission));
    }

    @Override
    public Page<MissionModel> allMissions(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("missionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else if(orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "expansion.name"));
                } else {
                    newOrders.add(new Sort.Order(orders.getDirection(), orders.getProperty()));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        }
        else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<Mission> page = missionRepository.findAll(newPageable);
        List<MissionModel> missionModels = new ArrayList<>();
        for(Mission mission : page.getContent()) {
            missionModels.add(new MissionModel(mission));
        }
        return new PageImpl<>(missionModels, pageable, page.getTotalElements());
    }

    @Override
    public List<MissionModel> allMissions() {
        List<MissionModel> missionModels = new ArrayList<>();
        for(Mission mission : missionRepository.findAll()) {
            missionModels.add(new MissionModel(mission));
        }
        return missionModels;
    }

    @Override
    public MissionModel findMissionByName(String missionName) {
        return new MissionModel(missionRepository.findByName(missionName));
    }

    @Override
    public MissionModel getNewMissionModel() {
        return new MissionModel();
    }

    @Override
    @Transactional
    public AgendaSetModel addAgendaSet(String agendaSetName, String expansionName, String imageURL) {
        Expansion expansion = expansionRepository.findByName(expansionName);
        return new AgendaSetModel(agendaSetRepository.save(new AgendaSet(agendaSetName, imageURL, expansion)));
    }

    @Override
    public AgendaSetModel addAgendaSet(AgendaSetModel agendaSetModel) {
        return addAgendaSet(agendaSetModel.getAgendaSetName(), agendaSetModel.getExpansionName(), agendaSetModel.getImageURL());
    }

    @Override
    @Transactional
    public AgendaSetModel updateAgendaSet(AgendaSetModel agendaSetModel) {
        AgendaSet agendaSet = agendaSetRepository.findByName(agendaSetModel.getAgendaSetName());
        Expansion expansion = expansionRepository.findByName(agendaSetModel.getExpansionName());
        agendaSet.setExpansion(expansion);
        agendaSet.setImageURL(agendaSetModel.getImageURL());
        return new AgendaSetModel(agendaSetRepository.save(agendaSet));
    }

    @Override
    public Page<AgendaSetModel> allAgendaSets(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("agendaSetName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else if(orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "expansion.name"));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        }
        else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<AgendaSet> page = agendaSetRepository.findAll(newPageable);
        List<AgendaSetModel> agendaSetModels = new ArrayList<>();
        for(AgendaSet agendaSet : page.getContent()) {
            agendaSetModels.add(new AgendaSetModel(agendaSet));
        }
        return new PageImpl<>(agendaSetModels, pageable, page.getTotalElements());
    }

    @Override
    public List<AgendaSetModel> allAgendaSets() {
        List<AgendaSetModel> agendaSetModels = new ArrayList<>();
        for(AgendaSet agendaSet : agendaSetRepository.findAll()) {
            agendaSetModels.add(new AgendaSetModel(agendaSet));
        }
        return agendaSetModels;
    }

    @Override
    public AgendaSetModel findAgendaSetByName(String agendaSetName) {
        return new AgendaSetModel(agendaSetRepository.findByName(agendaSetName));
    }

    @Override
    public AgendaSetModel getNewAgendaSetModel() {
        return new AgendaSetModel();
    }

    @Override
    @Transactional
    public AgendaCardModel addAgendaCard(String agendaCardName, String expansionName, String agendaSetName, AgendaType agendaType, short influenceCost, String imageURL) {
        Expansion expansion = expansionRepository.findByName(expansionName);
        AgendaSet agendaSet = agendaSetRepository.findByName(agendaSetName);
        return new AgendaCardModel(agendaCardRepository.save(new AgendaCard(agendaCardName, imageURL, expansion, agendaSet, agendaType, influenceCost)));
    }

    @Override
    public AgendaCardModel addAgendaCard(AgendaCardModel agendaCardModel) {
        return addAgendaCard(agendaCardModel.getAgendaCardName(), agendaCardModel.getExpansionName(), agendaCardModel.getAgendaSetName(), agendaCardModel.getAgendaType(), agendaCardModel.getInfluenceCost(), agendaCardModel.getImageURL());
    }

    @Override
    @Transactional
    public AgendaCardModel updateAgendaCard(AgendaCardModel agendaCardModel) {
        AgendaCard agendaCard = agendaCardRepository.findByName(agendaCardModel.getAgendaCardName());
        AgendaSet agendaSet = agendaSetRepository.findByName(agendaCardModel.getAgendaSetName());
        Expansion expansion = expansionRepository.findByName(agendaCardModel.getExpansionName());
        agendaCard.setExpansion(expansion);
        agendaCard.setAgendaSet(agendaSet);
        agendaCard.setAgendaType(agendaCardModel.getAgendaType());
        agendaCard.setInfluenceCost(agendaCardModel.getInfluenceCost());
        agendaSet.setImageURL(agendaCardModel.getImageURL());
        return new AgendaCardModel(agendaCardRepository.save(agendaCard));
    }

    @Override
    public Page<AgendaCardModel> allAgendaCards(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("agendaCardName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else if(orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "expansion.name"));
                } else if(orders.getProperty().equals("agendaSetName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "agendaSet.name"));
                } else {
                    newOrders.add(new Sort.Order(orders.getDirection(), orders.getProperty()));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        }
        else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<AgendaCard> page = agendaCardRepository.findAll(newPageable);
        List<AgendaCardModel> agendaCardModels = new ArrayList<>();
        for(AgendaCard agendaCard : page.getContent()) {
            agendaCardModels.add(new AgendaCardModel(agendaCard));
        }
        return new PageImpl<>(agendaCardModels, pageable, page.getTotalElements());
    }

    @Override
    public List<AgendaCardModel> allAgendaCards() {
        List<AgendaCardModel> agendaCardModels = new ArrayList<>();
        for(AgendaCard agendaCard : agendaCardRepository.findAll()) {
            agendaCardModels.add(new AgendaCardModel(agendaCard));
        }
        return agendaCardModels;
    }

    @Override
    public AgendaCardModel findAgendaCardByName(String agendaCardName) {
        return new AgendaCardModel(agendaCardRepository.findByName(agendaCardName));
    }

    @Override
    public AgendaCardModel getNewAgendaCardModel() {
        return new AgendaCardModel();
    }

    @Override
    @Transactional
    public ItemModel addItem(String itemName, String expansionName, ItemTier itemTier, ItemType itemType, int itemCost, String imageURL) {
        Expansion expansion = expansionRepository.findByName(expansionName);
        return new ItemModel(itemRepository.save(new Item(itemName, imageURL, expansion, itemTier, itemType, itemCost)));
    }

    @Override
    public ItemModel addItem(ItemModel itemModel) {
        return addItem(itemModel.getItemName(), itemModel.getExpansionName(), itemModel.getItemTier(), itemModel.getItemType(), itemModel.getItemCost(), itemModel.getImageURL());
    }

    @Override
    @Transactional
    public ItemModel updateItem(ItemModel itemModel) {
        Item item = itemRepository.findByName(itemModel.getItemName());
        Expansion expansion = expansionRepository.findByName(itemModel.getExpansionName());
        item.setExpansion(expansion);
        item.setImageURL(itemModel.getImageURL());
        item.setItemCost(itemModel.getItemCost());
        item.setItemTier(itemModel.getItemTier());
        item.setItemType(itemModel.getItemType());
        return new ItemModel(itemRepository.save(item));
    }

    @Override
    public Page<ItemModel> allItems(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("itemName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else if(orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "expansion.name"));
                } else {
                    newOrders.add(new Sort.Order(orders.getDirection(), orders.getProperty()));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        }
        else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<Item> page = itemRepository.findAll(newPageable);
        List<ItemModel> itemModels = new ArrayList<>();
        for(Item item : page.getContent()) {
            itemModels.add(new ItemModel(item));
        }
        return new PageImpl<>(itemModels, pageable, page.getTotalElements());
    }

    @Override
    public List<ItemModel> allItems() {
        List<ItemModel> itemModels = new ArrayList<>();
        for(Item item : itemRepository.findAll()) {
            itemModels.add(new ItemModel(item));
        }
        return itemModels;
    }

    @Override
    public ItemModel findItemByName(String itemName) {
        return new ItemModel(itemRepository.findByName(itemName));
    }

    @Override
    public ItemModel getNewItemModel() {
        return new ItemModel();
    }

    @Override
    @Transactional
    public PlayerClassModel addPlayerClass(String playerClassName, String expansionName, PlayerType classType, String imageURL) {
        Expansion expansion = expansionRepository.findByName(expansionName);
        return new PlayerClassModel(playerClassRepository.save(new PlayerClass(playerClassName, imageURL, classType, expansion)));
    }

    @Override
    public PlayerClassModel addPlayerClass(PlayerClassModel playerClassModel) {
        return addPlayerClass(playerClassModel.getClassName(), playerClassModel.getExpansionName(), playerClassModel.getClassType(), playerClassModel.getImageURL());
    }

    @Override
    @Transactional
    public PlayerClassModel updatePlayerClass(PlayerClassModel playerClassModel) {
        PlayerClass playerClass = playerClassRepository.findByName(playerClassModel.getClassName());
        Expansion expansion = expansionRepository.findByName(playerClassModel.getExpansionName());
        playerClass.setExpansion(expansion);
        playerClass.setClassType(playerClassModel.getClassType());
        playerClass.setImageURL(playerClassModel.getImageURL());
        return new PlayerClassModel(playerClassRepository.save(playerClass));
    }

    @Override
    public Page<PlayerClassModel> allPlayerClasses(Pageable pageable) {
        Pageable newPageable;
        if(pageable.getSort() != null) {
            List<Sort.Order> newOrders = new ArrayList<>();
            for (Sort.Order orders : pageable.getSort()) {
                if (orders.getProperty().equals("className")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "name"));
                } else if(orders.getProperty().equals("expansionName")) {
                    newOrders.add(new Sort.Order(orders.getDirection(), "expansion.name"));
                } else {
                    newOrders.add(new Sort.Order(orders.getDirection(), orders.getProperty()));
                }
            }
            Sort newSort = new Sort(newOrders);
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), newSort);
        }
        else {
            newPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize());
        }
        Page<PlayerClass> page = playerClassRepository.findAll(newPageable);
        List<PlayerClassModel> playerClassModels = new ArrayList<>();
        for(PlayerClass playerClass : page.getContent()) {
            playerClassModels.add(new PlayerClassModel(playerClass));
        }
        return new PageImpl<>(playerClassModels, pageable, page.getTotalElements());
    }

    @Override
    public List<PlayerClassModel> allPlayerClasses() {
        List<PlayerClassModel> playerClassModels = new ArrayList<>();
        for(PlayerClass playerClass : playerClassRepository.findAll()) {
            playerClassModels.add(new PlayerClassModel(playerClass));
        }
        return playerClassModels;
    }

    @Override
    public PlayerClassModel findPlayerClassByName(String playerClassName) {
        return new PlayerClassModel(playerClassRepository.findByName(playerClassName));
    }

    @Override
    public PlayerClassModel getNewPlayerClassModel() {
        return new PlayerClassModel();
    }
}
