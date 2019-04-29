package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * RegisterController Class
 *
 * @author zhangjianyun
 * @date 2018-9-20
 */
@Controller
public class RegisterController {
    @Autowired
    private LeaseholderService leaseholderService;
    @Autowired
    private LandlordService landlordService;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/register")
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value="/registerCheck.action", method = POST)
    public String registerCheck(Leaseholder leaseholder, Landlord landlord, String option) {
        try {
            if(option.equals("leaseholder")) {
                leaseholder.setRegisterdate(sdf.format(date));
                leaseholderService.save(leaseholder);
            }
            else {
                landlord.setRegisterdate(sdf.format(date));
                landlordService.save(landlord);
            }
            return "register_success";
        } catch (Exception e) {
            System.out.print(e);
            return "register_failed";
        }
    }
}
