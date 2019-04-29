package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.service.LeaseholderService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LeaseholderSelfInfoController {
    @Autowired
    private LeaseholderService leaseholderService;

    //跳转到租户个人信息页面
    @RequestMapping("/leaseholder_self_info")
    public String showLeaseholderSelfInfoPage()
    {
        return "leaseholder_self_info";
    }

    //修改个人信息操作
    @RequestMapping(value = "/changeLeaseholderSelfInfo.action", method = POST)
    public String changeLeaseholderSelfInfo(HttpSession session, String name, String phone, String email, @RequestParam("icon") MultipartFile file) {
        Leaseholder leaseholder = (Leaseholder) session.getAttribute("leaseholder");
        leaseholder.setName(name);
        leaseholder.setPhone(phone);
        leaseholder.setEmail(email);
        String newIcon = FileUtil.uploadFile(file);
        if(newIcon != null){
            leaseholder.setIcon(newIcon);
        }

        //保存到数据库
        try{
            leaseholderService.edit(leaseholder);
            session.setAttribute("leaseholder", leaseholder);
            return "redirect:/leaseholder";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //跳转到修改密码界面
    @RequestMapping("/leaseholder_self_change_password")
    public String showLeaseholderSelfChangePasswordPage()
    {
        return "leaseholder_self_change_password";
    }

    //修改密码操作
    @RequestMapping(value = "/changeLeaseholderSelfPassword.action", method = POST)
    public String changeLeaseholderSelfPassword(HttpSession session, String oldpassword, String newpassword1, String newpassword2){
        Leaseholder leaseholder = (Leaseholder) session.getAttribute("leaseholder");

        if(oldpassword.equals(leaseholder.getPassword()) && newpassword1.equals(newpassword2)){
            leaseholder.setPassword(newpassword1);

            leaseholderService.edit(leaseholder);
            session.setAttribute("leaseholder", leaseholder);
            return "redirect:/leaseholder";
        }
        else{
            return "error";
        }
    }
}
