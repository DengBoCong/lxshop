package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Service.ProfileService;
import com.dbc.lxshop.Utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-17 16:03
 **/
@Controller
@RequestMapping("/Admin/Summary")
public class SummaryController {
    @Qualifier("profileService")
    @Autowired
    private ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET, value = "/Profile")
    public String profile(ModelMap modelMap){
        modelMap.addAttribute("ProfileDataBean", profileService.profileDataBean());
        modelMap.addAttribute("WeekTop15Goods", profileService.listTop15ByTime(DateUtil.LastWeekTime()));
        modelMap.addAttribute("MonthTop15Goods", profileService.listTop15ByTime(DateUtil.LastMonthTime()));
        modelMap.addAttribute("YearTop15Goods", profileService.listTop15ByTime(DateUtil.LastYearTime()));
        return "admin/summary/profile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Flow")
    public String flow(ModelMap modelMap){
        return "admin/summary/flow";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/User")
    public String user(ModelMap modelMap){
        return "admin/summary/user";
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public ProfileService getProfileService() {
        return profileService;
    }
}
