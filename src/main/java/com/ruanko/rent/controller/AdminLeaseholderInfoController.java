package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AdminLeaseholderInfoController {
    @Autowired
    private LeaseholderService leaseholderService;

    //跳转到租客信息列表界面
    @RequestMapping("/admin_leaseholder_info")
    public String showAdminLeaseholderInfoPage(Model model) {
        List<Leaseholder> leaseholderList = leaseholderService.getLeaseholderList();
        model.addAttribute("leaseholderList", leaseholderList);
        return "admin_leaseholder_info";
    }

    //跳转到租客信息修改界面
    @RequestMapping("/adminChangeLeaseholderInfo")
    public String adminChangeLeaseholderInfo(HttpSession session, String id){
        Leaseholder leaseholder = leaseholderService.findLeaseholderById(id);
        session.setAttribute("leaseholder", leaseholder);
        return "admin_leaseholder_change_info";
    }

    //执行修改租客信息操作
    @RequestMapping(value = "/changeLeaseholderInfo.action", method = POST)
    public String changeLeaseholderInfo(HttpSession session, String name, String phone, String email){
        Leaseholder leaseholder = (Leaseholder) session.getAttribute("leaseholder");
        leaseholder.setName(name);
        leaseholder.setPhone(phone);
        leaseholder.setEmail(email);

        //保存到数据库
        try{
            leaseholderService.edit(leaseholder);
            session.setAttribute("leaseholder", leaseholder);
            return "redirect:/admin_leaseholder_info";  //修改完成，重定向到租客列表界面
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //执行删除租客信息操作
    @RequestMapping("/adminDeleteLeaseholderInfo")
    public String adminDeleteLeaseholderInfo(String id){
        leaseholderService.delete(id);
        return "redirect:/admin_leaseholder_info";
    }
}
