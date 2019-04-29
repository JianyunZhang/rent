package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * IndexController Class
 *
 * @author zhangjianyun
 * @date 2018-9-27
 */
@Controller
public class IndexController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private LandlordService landlordService;

    @RequestMapping(value={"/", "/index"})
    public String showIndexPage(Model model){
        List<House> houseList = houseService.getHouseList();
        if(houseList.size() > 3) {
            houseList = houseList.subList(houseList.size() - 3, houseList.size());
        }
        model.addAttribute("houseList", houseList);

        List<Landlord> landlordList = landlordService.getLandlordList();
        if(landlordList.size() > 3) {
            landlordList = landlordList.subList(0, 6);
        }
        model.addAttribute("landlordList", landlordList);
        return "index";
    }
}