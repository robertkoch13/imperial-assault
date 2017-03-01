package com.robertkoch.imperialassault.web.controllers;

import com.robertkoch.imperialassault.domain.enums.ExpansionType;
import com.robertkoch.imperialassault.domain.enums.MissionType;
import com.robertkoch.imperialassault.domain.enums.PlayerType;
import com.robertkoch.imperialassault.services.admin.ConfigureService;
import com.robertkoch.imperialassault.services.models.CampaignModel;
import com.robertkoch.imperialassault.services.models.ExpansionModel;
import com.robertkoch.imperialassault.services.models.MissionModel;
import com.robertkoch.imperialassault.services.models.PlayerClassModel;
import com.robertkoch.imperialassault.web.utils.PagingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/16.
 */
@Controller
public class AdminController {
    private ConfigureService configureService;
    private PagingBuilder pagingBuilder;

    @Autowired
    public AdminController(ConfigureService configureService,
                           PagingBuilder pagingBuilder) {
        this.configureService = configureService;
        this.pagingBuilder = pagingBuilder;
    }

    @ModelAttribute("allExpansionTypes")
    public List<ExpansionType> populateExpansionTypes() {
        return Arrays.asList(ExpansionType.values());
    }

    @ModelAttribute("allExpansions")
    public List<ExpansionModel> populateExpansionModels() {
        return configureService.allExpansions();
    }

    @ModelAttribute("allMissionTypes")
    public List<MissionType> populateMissionTypes() {
        return Arrays.asList(MissionType.values());
    }

    @ModelAttribute("allClassTypes")
    public List<PlayerType> populateClassTypes() {
        return Arrays.asList(PlayerType.values());
    }

    private ModelAndView getCampaignListView(Page<CampaignModel> campaignModels, Pageable pageable) {
        String viewName = "admin/campaign/campaignList";
        return pagingBuilder.getModelAndView(viewName, campaignModels, pageable);
    }

    @GetMapping("/admin/campaigns/list")
    public ModelAndView showCampaignList(Pageable pageable) {
        return getCampaignListView(configureService.allCampaigns(pageable), pageable);
    }

    @GetMapping("/admin/campaigns/add")
    public String addCampaign(Model model) {
        model.addAttribute("campaign", configureService.getNewCampaignModel());
        return "admin/campaign/addCampaign";
    }

    @PostMapping("/admin/campaigns/add")
    public String addCampaignSubmit(@ModelAttribute CampaignModel campaignModel) {
        configureService.addCampaign(campaignModel);
        return "redirect:/admin/campaigns/list";
    }

    @GetMapping("/admin/campaigns/edit")
    public String editCampaign(@RequestParam("name") String name, Model model) {
        model.addAttribute("campaign", configureService.findCampaignByName(name));
        return "admin/campaign/editCampaign";
    }

    @PostMapping("/admin/campaigns/edit")
    public String editCampaignSubmit(@ModelAttribute CampaignModel campaignModel) {
        configureService.updateCampaign(campaignModel);
        return "redirect:/admin/campaigns/list";
    }

    private ModelAndView getExpansionListView(Page<ExpansionModel> expansionModels, Pageable pageable) {
        String viewName = "admin/expansion/expansionList";
        return pagingBuilder.getModelAndView(viewName, expansionModels, pageable);
    }

    @GetMapping("/admin/expansions/list")
    public ModelAndView showExpansionList(Pageable pageable) {
        return getExpansionListView(configureService.allExpansions(pageable), pageable);
    }

    @GetMapping("/admin/expansions/add")
    public String addExpansion(Model model) {
        model.addAttribute("expansion", configureService.getNewExpansionModel());
        return "admin/expansion/addExpansion";
    }

    @PostMapping("/admin/expansions/add")
    public String addExpansionSubmit(@ModelAttribute ExpansionModel expansionModel) {
        configureService.addExpansion(expansionModel);
        return "redirect:/admin/expansions/list";
    }

    @GetMapping("/admin/expansions/edit")
    public String editExpansion(@RequestParam("name") String name, Model model) {
        model.addAttribute("expansion", configureService.findExpansionByName(name));
        return "admin/expansion/editExpansion";
    }

    @PostMapping("/admin/expansions/edit")
    public String editExpansionSubmit(@ModelAttribute ExpansionModel expansionModel) {
        configureService.updateExpansion(expansionModel);
        return "redirect:/admin/expansions/list";
    }

    private ModelAndView getMissionListView(Page<MissionModel> missionModels, Pageable pageable) {
        String viewName = "admin/mission/missionList";
        return pagingBuilder.getModelAndView(viewName, missionModels, pageable);
    }

    @GetMapping("/admin/missions/list")
    public ModelAndView showMissionList(Pageable pageable) {
        return getMissionListView(configureService.allMissions(pageable), pageable);
    }

    @GetMapping("/admin/missions/add")
    public String addMission(Model model) {
        model.addAttribute("mission", configureService.getNewMissionModel());
        return "admin/mission/addMission";
    }

    @PostMapping("/admin/missions/add")
    public String addMissionSubmit(@ModelAttribute MissionModel missionModel) {
        configureService.addMission(missionModel);
        return "redirect:/admin/missions/list";
    }

    @GetMapping("/admin/missions/edit")
    public String editMission(@RequestParam("name") String name, Model model) {
        model.addAttribute("mission", configureService.findMissionByName(name));
        return "admin/mission/editMission";
    }

    @PostMapping("/admin/missions/edit")
    public String editMissionSubmit(@ModelAttribute MissionModel missionModel) {
        configureService.updateMission(missionModel);
        return "redirect:/admin/missions/list";
    }

    private ModelAndView getPlayerClassList(Page<PlayerClassModel> playerClassModels, Pageable pageable) {
        String viewName = "admin/class/classList";
        return pagingBuilder.getModelAndView(viewName, playerClassModels, pageable);
    }

    @GetMapping("/admin/classes/list")
    public ModelAndView showPlayerClassList(Pageable pageable) {
        return getPlayerClassList(configureService.allPlayerClasses(pageable), pageable);
    }

    @GetMapping("/admin/classes/add")
    public String addPlayerClass(Model model) {
        model.addAttribute("playerClass", configureService.getNewPlayerClassModel());
        return "admin/class/addClass";
    }

    @PostMapping("/admin/classes/add")
    public String addPlayerClassSubmit(@ModelAttribute PlayerClassModel playerClassModel) {
        configureService.addPlayerClass(playerClassModel);
        return "redirect:/admin/classes/list";
    }

    @GetMapping("/admin/classes/edit")
    public String editPlayerClass(@RequestParam("name") String name, Model model) {
        model.addAttribute("playerClass", configureService.findPlayerClassByName(name));
        return "admin/class/editClass";
    }

    @PostMapping("/admin/classes/edit")
    public String editPlayerClassSubmit(@ModelAttribute PlayerClassModel playerClassModel) {
        configureService.updatePlayerClass(playerClassModel);
        return "redirect:/admin/classes/list";
    }

}
