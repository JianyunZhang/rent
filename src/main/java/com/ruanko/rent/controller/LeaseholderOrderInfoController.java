package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.entity.Order;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LeaseholderOrderInfoController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private LandlordService landlordService;

    //跳转到订单信息页面
    @RequestMapping("/leaseholder_order_info")
    public String showLeaseholderOrderInfoPage(Model model){
        //从数据库中取出订单列表，存入model
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("orderList", orderList);
        return "leaseholder_order_info";
    }

    //跳转到订单详情页面
    @RequestMapping("/leaseholderShowOrder")
    public String leaseholderShowOrder(Model model, int id){
        //根据id查询订单并添加到model
        Order order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        //查询订单房屋并添加到model
        House house = houseService.findHouseById(order.getHouse());
        model.addAttribute("house", house);
        //查询房东信息并添加到model
        Landlord landlord = landlordService.findLandlordById(order.getLandlord());
        model.addAttribute("landlord", landlord);
        //跳转到订单详情界面
        return "leaseholder_order_detail_info";
    }

    //删除订单操作
    @RequestMapping(value = {"/leaseholderDeleteOrder", "/leaseholderDetailDeleteOrder"})
    public String leaseholderDeleteOrder(int id){
        //在数据库中查询被删除订单的房屋id并删除订单
        Order order = orderService.findOrderById(id);
        //判断订单状态，如果房东已经确认订单，则无法删除
        if(order.isState())
            return "error";
        //否则删除订单
        orderService.delete(id);

        //将被租用房屋的状态设为可租用,并存入数据库
        House house = houseService.findHouseById(order.getHouse());
        house.setIslease(true);
        houseService.edit(house);

        //删除成功，重定向到订单信息页面
        return "redirect:/leaseholder_order_info";
    }
}
