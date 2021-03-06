package com.robertkoch.imperialassault.web.controllers;

import com.robertkoch.imperialassault.domain.enums.MissionType;
import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.services.admin.ConfigureService;
import com.robertkoch.imperialassault.services.models.*;
import com.robertkoch.imperialassault.services.user.PlayerService;
import com.robertkoch.imperialassault.web.model.AddXP;
import com.robertkoch.imperialassault.web.utils.PagingBuilder;
import com.robertkoch.imperialassault.web.utils.WebAppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/23.
 */
@Controller
public class PlayerController {
    private PlayerService playerService;
    private ConfigureService configureService;
    private PagingBuilder pagingBuilder;

    @Autowired
    public PlayerController(PlayerService playerService, ConfigureService configureService, PagingBuilder pagingBuilder) {
        this.playerService = playerService;
        this.configureService = configureService;
        this.pagingBuilder = pagingBuilder;
    }

    @ModelAttribute("allCampaigns")
    public List<CampaignModel> populateCampaignModels() {
        return configureService.allCampaigns();
    }

    @ModelAttribute("allPlayerTypes")
    public List<PlayerType> populatePlayerTypes() {
        return Arrays.asList(PlayerType.values());
    }

    @ModelAttribute("allPlayerClasses")
    public List<PlayerClassModel> populatePlayerClasses() { return configureService.allPlayerClasses(); }

    @ModelAttribute("allMissionTypes")
    public List<MissionType> populateMissionTypes() { return Arrays.asList(MissionType.values()); }

    @ModelAttribute("allMissions")
    public List<MissionModel> populatePlayerMissions() { return configureService.allMissions(); }

    @ModelAttribute("newPlayer")
    public PlayerModel getNewPlayer() { return playerService.getNewPlayerModel(); }

    @ModelAttribute("newMission")
    public PlayerMissionModel getNewMission() { return playerService.getNewPlayerMissionModel(); }

    @ModelAttribute("addXP")
    public AddXP getAddXP() { return new AddXP(); }

    private ModelAndView getCampaignListView(Page<PlayerCampaignModel> playerCampaignModels, Pageable pageable) {
        String viewName = "player/campaign/campaignList";
        return pagingBuilder.getModelAndView(viewName, playerCampaignModels, pageable);
    }

    @GetMapping("/campaigns/list")
    public ModelAndView showCampaignList(Pageable pageable) {
        return getCampaignListView(playerService.allPlayerCampaigns(WebAppUtils.getPrincipal(), pageable), pageable);
    }

    @GetMapping("/campaigns/add")
    public String addCampaign(Model model) {
        model.addAttribute("campaign", playerService.getNewPlayerCampaignModel());
        return "player/campaign/addCampaign";
    }

    @PostMapping("/campaigns/add")
    public String addCampaignSubmit(@ModelAttribute PlayerCampaignModel playerCampaignModel) {
        playerService.addPlayerCampaign(WebAppUtils.getPrincipal(), playerCampaignModel);
        return "redirect:/campaigns/list";
    }

    @GetMapping("/{campaignName}")
    public String showCampaignDetail(@PathVariable String campaignName, Model model) {
        model.addAttribute("campaign", playerService.findPlayerCampaignByName(WebAppUtils.getPrincipal(), campaignName));
        model.addAttribute("campaignURL", String.format("/%s", campaignName));
        model.addAttribute("campaignPlayers", playerService.allPlayers(WebAppUtils.getPrincipal(), campaignName));
        model.addAttribute("campaignMissions", playerService.allPlayerMissions(WebAppUtils.getPrincipal(), campaignName));
        return "player/campaignDetails";
    }

    @PostMapping("/{campaignName}/edit")
    public String updateCampaignDetail(@PathVariable String campaignName, @ModelAttribute PlayerCampaignModel playerCampaignModel, Model model) {
        model.asMap().clear();  //this is a hack - clears the unwanted parameters?
        return String.format("redirect:/%s", playerService.updatePlayerCampaign(WebAppUtils.getPrincipal(), campaignName, playerCampaignModel).getName());
    }

    @PostMapping("/{campaignName}/players/add")
    public String addCampaignPlayerSubmit(@PathVariable String campaignName, @ModelAttribute PlayerModel playerModel, Model model) {
        playerModel.setPlayerCampaignName(campaignName);
        playerService.addPlayer(WebAppUtils.getPrincipal(), playerModel);
        model.addAttribute("campaignPlayers", playerService.allPlayers(WebAppUtils.getPrincipal(), campaignName));
        return "player/player/playerList :: campaignPlayerList";
    }

    @PostMapping("/{campaignName}/missions/add")
    public String addCampaignMissionSubmit(@PathVariable String campaignName, @ModelAttribute PlayerMissionModel playerMissionModel, Model model) {
        playerMissionModel.setPlayerCampaignName(campaignName);
        playerService.addPlayerMission(WebAppUtils.getPrincipal(), playerMissionModel);
        model.addAttribute("campaignMissions", playerService.allPlayerMissions(WebAppUtils.getPrincipal(), campaignName));
        return "player/mission/missionList :: campaignMissionList";
    }

    @PostMapping("/{campaignName}/players/addXP")
    public String addCampaignPlayerXPSubmit(@PathVariable String campaignName, @ModelAttribute AddXP addXP, Model model) {
        playerService.addXP(WebAppUtils.getPrincipal(), campaignName, addXP.getPlayerType(), addXP.getIncreaseXPBy());
        model.addAttribute("campaignPlayers", playerService.allPlayers(WebAppUtils.getPrincipal(), campaignName));
        return "player/player/playerList :: campaignPlayerList";
    }

}
