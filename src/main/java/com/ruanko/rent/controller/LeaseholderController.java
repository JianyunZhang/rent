package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LeaseholderController {
    @Autowired
    private HouseService houseService;

    //跳转到leaseholder页面
    @RequestMapping("/leaseholder")
    public String showLeaseholderPage(Model model) {
        List<House> houseList = houseService.getHouseList();
        model.addAttribute("houseList", houseList);
        return "leaseholder";
    }

    //跳转到leaseholder_help页面
    @RequestMapping("/leaseholder_help")
    public String showLeaseholderHelpPage() {
        return "leaseholder_help";
    }
}
