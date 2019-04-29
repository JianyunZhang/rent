package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *AdminSelfInfoController Class
 *
 * @author zhangjianyun
 * @date 2018-9-28
 */
@Controller
public class AdminSelfInfoController {
    @Autowired
    private AdminService adminService;

    //跳转到管理员个人信息页面
    @RequestMapping("/admin_self_info")
    public String showAdminSelfInfoPage()
    {
        return "admin_self_info";
    }

    @RequestMapping(value = "/changeAdminSelfInfo.action", method = POST)
    public String changeAdminSelfInfo(HttpSession session, String name, String phone, String email, @RequestParam("icon") MultipartFile file){
        Admin admin = (Admin) session.getAttribute("admin");
        admin.setName(name);
        admin.setPhone(phone);
        admin.setEmail(email);
        String newIcon = FileUtil.uploadFile(file);
        if(newIcon != null){
            admin.setIcon(newIcon);
        }

        //保存到数据库
        try{
            adminService.edit(admin);
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    @RequestMapping("/admin_self_change_password")
    public String showAdminSelfChangePasswordPage()
    {
        return "admin_self_change_password";
    }

    @RequestMapping(value = "/changeAdminSelfPassword.action", method = POST)
    public String changeAdminSelfPassword(HttpSession session, String oldpassword, String newpassword1, String newpassword2){
        Admin admin = (Admin) session.getAttribute("admin");

        if(oldpassword.equals(admin.getPassword()) && newpassword1.equals(newpassword2)){
            admin.setPassword(newpassword1);

            adminService.edit(admin);
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        }
        else{
            return "error";
        }
    }
}
