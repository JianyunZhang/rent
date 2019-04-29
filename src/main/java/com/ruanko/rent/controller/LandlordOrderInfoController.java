package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.entity.Order;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LeaseholderService;
import com.ruanko.rent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LandlordOrderInfoController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private LeaseholderService leaseholderService;

    //跳转到房东查看订单界面
    @RequestMapping("/landlord_order_info")
    public String showLandlordOrderInfoPage(Model model){
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("orderList", orderList);
        return "landlord_order_info";
    }

    //跳转到房东查看订单详情界面
    @RequestMapping("/landlordShowOrderInfo")
    public String showLandlordOrderDetailInfoPage(Model model, int id){
        //根据id查询订单并添加到model
        Order order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        //查询订单房屋并添加到model
        House house = houseService.findHouseById(order.getHouse());
        model.addAttribute("house", house);
        //查询租户信息并添加到model
        Leaseholder leaseholder = leaseholderService.findLeaseholderById(order.getLeaseholder());
        model.addAttribute("leaseholder", leaseholder);
        //跳转到订单详情界面
        return "landlord_order_detail_info";
    }

    //房东接受订单
    @RequestMapping("/landlordReceiveOrderInfo")
    public String landlordReceiveOrderInfo(int id){
        Order order = orderService.findOrderById(id);
        order.setState(true);
        orderService.edit(order);
        return "redirect:/landlord_order_info";
    }

    //删除订单操作
    @RequestMapping(value = {"/landlordDeleteOrder", "/landlordDetailDeleteOrder"})
    public String landlordDeleteOrder(int id){
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
        return "redirect:/landlord_order_info";
    }
}
