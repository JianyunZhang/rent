package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LandlordHouseInfoController {
    @Autowired
    private HouseService houseService;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    //显示房屋界面
    @RequestMapping("/landlord_house_info")
    public String showLandlordHouseInfoPage(Model model) {
        List<House> houseList = houseService.getHouseList();
        model.addAttribute("houseList", houseList);
        return "landlord_house_info";
    }

    //跳转到房屋详情界面
    @RequestMapping("/landlordShowHouseInfo")
    public String showLandlordHouseDetailInfoPage(Model model, int id) {
        House house = houseService.findHouseById(id);
        model.addAttribute("house", house);
        return "landlord_house_detail_info";
    }

    //跳转到房屋信息修改界面
    @RequestMapping(value = {"/landlordChangeHouseInfo", "/landlordChangeHouseDetailInfo"})
    public String showLandlordHouseChangeInfoPage(Model model, int id) {
        House house = houseService.findHouseById(id);
        model.addAttribute("house", house);
        return "landlord_house_change_info";
    }

    //删除房屋操作
    @RequestMapping(value = {"/landlordDeleteHouseInfo", "/landlordDeleteHouseDetailInfo"})
    public String landlordDeleteLandlordInfo(int id) {
        House house = houseService.findHouseById(id);
        houseService.delete(id);
        return "redirect:/landlord_house_info";
    }

    //修改房屋资料操作
    @RequestMapping(value = "/changeLandlordHouseInfo.action", method = POST)
    public String landlordChangeHouseInfo(int id, String name, String location, String category, String area, String floor, int price, @RequestParam("picture") MultipartFile file){
        House house = houseService.findHouseById(id);
        house.setName(name);
        house.setLocation(location);
        house.setCategory(category);
        house.setArea(area);
        house.setFloor(floor);
        house.setPrice(price);
        house.setPublishdate(sdf.format(date));
        String newPicture = FileUtil.uploadFile(file);
        if(newPicture != null){
            house.setPicture(newPicture);
        }

        //保存到数据库
        try{
            houseService.edit(house);
            return "redirect:/landlord_house_info";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
