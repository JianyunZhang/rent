package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.LeaseholderService;
import com.ruanko.rent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * AdminController Class
 *
 * @author zhangjianyun
 * @date 2018-9-28
 */
@Controller
public class AdminController {
    @Autowired
    private LeaseholderService leaseholderService;
    @Autowired
    private LandlordService landlordService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/admin")
    public String showAdminPage(Model model) {
        int leaseholderNum = leaseholderService.getLeaseholderList().size();
        model.addAttribute("leaseholderNum", leaseholderNum);

        int landlordNum = landlordService.getLandlordList().size();
        model.addAttribute("landlordNum", landlordNum);

        List<House> houseList = houseService.getHouseList();
        model.addAttribute("houseList", houseList);

        int houseNum = houseList.size();
        model.addAttribute("houseNum", houseNum);

        //计算待审核房屋数量,并存入model
        int noCheckHouseNum = 0;
        for(int i=0; i<houseList.size(); i++){
            if(houseList.get(i).isIscheck() == false){
                noCheckHouseNum++;
            }
        }
        model.addAttribute("noCheckHouseNum", noCheckHouseNum);

        //计算已审核房屋数量
        int checkedHouseNum = houseList.size() - noCheckHouseNum;
        model.addAttribute("checkedHouseNum", checkedHouseNum);

        //计算订单数量
        int orderNum = orderService.getOrderList().size();
        model.addAttribute("orderNum", orderNum);

        return "admin";
    }

    //跳转到admin_help页面
    @RequestMapping("/admin_help")
    public String showAdminHelpPage() {
        return "admin_help";
    }
}
