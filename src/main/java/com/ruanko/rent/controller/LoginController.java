package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * LoginController Class
 *
 * @author zhangjianyun
 * @date 2018-9-20
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private LeaseholderService leaseholderService;
    @Autowired
    private LandlordService landlordService;

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value="/loginCheck.action", method = POST)
    public String loginCheck(HttpSession session, String id, String password, String option) {
        if(option.equals("admin")) {
            Admin admin = adminService.findAdminById(id);
            if (admin == null || !admin.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("admin", admin);
                return "redirect:/admin";   //重定向到admin主界面
            }
        }
        else if(option.equals("leaseholder")){
            Leaseholder leaseholder = leaseholderService.findLeaseholderById(id);
            if (leaseholder == null || !leaseholder.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("leaseholder", leaseholder);
                return "redirect:/leaseholder";   //重定向到leaseholder主界面
            }
        }
        else {
            Landlord landlord = landlordService.findLandlordById(id);
            if (landlord == null || !landlord.getPassword().equals(password)) {
                return "login_failed";
            } else {
                session.setAttribute("landlord", landlord);
                return "redirect:/landlord";   //重定向到landlord主界面
            }
        }
    }
}