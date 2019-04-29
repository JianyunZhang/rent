package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.entity.Order;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LeaseholderHouseInfoController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private Order order;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //显示房屋界面
    @RequestMapping("/leaseholder_house_info")
    public String showLeaseholderHouseInfoPage(Model model) {
        List<House> houseList = houseService.getHouseList();
        model.addAttribute("houseList", houseList);
        return "leaseholder_house_info";
    }

    //跳转到房屋详情界面
    @RequestMapping("/leaseholderShowHouseInfo")
    public String showLeaseholderHouseDetailInfoPage(Model model, int id) {
        House house = houseService.findHouseById(id);
        model.addAttribute("house", house);
        return "leaseholder_house_detail_info";
    }

    //跳转到下单界面
    @RequestMapping("/leaseholderShowHouseOrder")
    public String showLeaseholderHouseOrderPage(Model model, int id) {
        House house = houseService.findHouseById(id);
        model.addAttribute("house", house);
        return "leaseholder_house_order";
    }

    //确认下单操作
    @RequestMapping(value = "/leaseholderConfirmOrder.action", method = POST)
    public String leaseholderConfirmOrder(Order order) {
        //将总价设为每日租金*所租天数
        order.setPrice(order.getPrice()*order.getDuration());

        //设定下单日期
        order.setOrderdate(sdf.format(date));

        //将房屋设为被租,并存入数据库
        House houseutil = houseService.findHouseById(order.getHouse());
        houseutil.setIslease(false);
        houseService.edit(houseutil);

        //将订单信息存入数据库
        orderService.save(order);

        //操作成功，重定向至订单信息列表
        return "redirect:/leaseholder_order_info";
    }
}
