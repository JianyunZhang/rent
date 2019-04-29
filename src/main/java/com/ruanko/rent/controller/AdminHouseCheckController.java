package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Checklog;
import com.ruanko.rent.entity.House;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.ChecklogService;
import com.ruanko.rent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AdminHouseCheckController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private ChecklogService checklogService;
    @Autowired
    private Checklog checklog;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //跳转到房屋审核界面，显示待审核房屋列表
    @RequestMapping("/admin_house_check")
    public String showAdminCheckHousePage(Model model) {
        List<House> houseList = houseService.getHouseList();

        //将待审核房屋列表存入model
        model.addAttribute("houseList", houseList);
        return "admin_house_check";
    }

    //跳转到房屋细节审核页面
    @RequestMapping("/adminCheckHouseInfo")
    public String showAdminHouseDetailInfoPage(HttpSession session, int id) {
        House house = houseService.findHouseById(id);
        session.setAttribute("house", house);
        return "admin_house_check_detail";
    }

    //审核通过
    @RequestMapping("/checkSuccess.action")
    public String checkSuccess(HttpSession session) {
        House house = (House) session.getAttribute("house");
        Admin admin = (Admin) session.getAttribute("admin");

        house.setIscheck(true);

        //设置操作记录
        checklog.setAdmin(admin.getId());
        checklog.setHouse(house.getId());
        checklog.setCheckdate(sdf.format(date));
        checklog.setCheckresult(true);

        //将操作记录存入数据库
        checklogService.save(checklog);
        houseService.edit(house);

        //操作完成，返回审核界面
        return "redirect:/admin_house_check";
    }

    //审核不通过
    @RequestMapping("/checkFailed.action")
    public String checkFailed(HttpSession session) {
        House house = (House) session.getAttribute("house");
        Admin admin = (Admin) session.getAttribute("admin");

        house.setIscheck(false);

        //设置操作记录
        checklog.setAdmin(admin.getId());
        checklog.setHouse(house.getId());
        checklog.setCheckdate(sdf.format(date));
        checklog.setCheckresult(false);

        //将操作记录存入数据库
        checklogService.save(checklog);
        houseService.edit(house);

        //操作完成，返回审核界面
        return "redirect:/admin_house_check";
    }

    //跳转到审核记录界面，显示审核记录列表
    @RequestMapping("/admin_house_log")
    public String showAdminHouseLogPage(Model model) {
        //从数据库中获取操作记录列表
        List<Checklog> checklogList = checklogService.getChecklogList();
        //从数据库中获取管理员列表
        List<Admin> adminList = adminService.getAdminList();

        //用管理员姓名替换id
        for(int i = 0; i<checklogList.size(); i++){
            for(int j = 0; j<adminList.size(); j++){
                if(checklogList.get(i).getAdmin().equals(adminList.get(j).getId())){
                    checklogList.get(i).setAdmin(adminList.get(j).getName());
                    break;
                }
            }
        }

        //将待审核记录列表存入model
        model.addAttribute("checklogList", checklogList);
        return "admin_house_log";
    }

}
