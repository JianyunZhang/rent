package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LandlordHousePublishController {
    @Autowired
    private LandlordService landlordService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private House house;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //跳转到发布房屋界面
    @RequestMapping("/landlord_house_publish")
    public String showLandlordHousePublish(){
        return "landlord_house_publish";
    }

    //发布房屋
    @RequestMapping(value="/landlordPublishHouse.action", method = POST)
    public String landlordPublishHouse(HttpSession session, String name, String location, String category, String area, String floor, int price, @RequestParam("picture") MultipartFile file){
        Landlord landlord = (Landlord) session.getAttribute("landlord");
        house.setName(name);
        house.setLocation(location);
        house.setCategory(category);
        house.setArea(area);
        house.setFloor(floor);
        house.setPrice(price);
        house.setLandlord(landlord.getId());
        house.setIslease(true);
        house.setPublishdate(sdf.format(date));

        String newPicture = FileUtil.uploadFile(file);
        if(newPicture != null){
            house.setPicture(newPicture);
        }

        //保存到数据库
        try{
            houseService.save(house);
            return "redirect:/landlord";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
