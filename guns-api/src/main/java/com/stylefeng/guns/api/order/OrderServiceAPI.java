package com.stylefeng.guns.api.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.order.vo.OrderVO;

import java.util.List;

public interface OrderServiceAPI {

    //验证售出的票是否为真
    boolean isTrueSeats(String filedId,String seats);

    //已经售出的座位中，有没有这些座位
    boolean isNotSoldSeats(String filedId,String seats);

    //创建订单信息,注意获取登录人
    OrderVO saveOrderInfo(Integer fieldId,String soldSeats,String seatsName,Integer userId);

    //使用当前登录人，获取已经购买的订单
    Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page);

    //根据fieldId获取所有已经销售的座位编号
    String getSoldSeatsByFieldId(Integer fieldId);


    // 根据订单编号获取订单信息
    OrderVO getOrderInfoById(String orderId);

    // 修改订单状态
    boolean paySuccess(String orderId);

    boolean payFail(String orderId);
}
