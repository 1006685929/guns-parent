package com.stylefeng.guns.rest.modular.order;

import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxk
 * 2019/3/16 17:50
 */


@RestController
@RequestMapping(value = "/order/")
public class OrderController {




    /**
     *   //购票
     * @param fieldId  当前场次
     * @param soldSeats  已售出的作为
     * @param seatsName  座位
     * @return
     */
    @RequestMapping(value = "buyTickets",method = RequestMethod.POST)
    public ResponseVO buyTickets(Integer fieldId,String soldSeats,String seatsName){

        //验证售出的票是否为真

        //已经售出的座位中，有没有这些座位

        //创建订单信息，注意获取登录人
        return null;
    }


    @RequestMapping(value = "getOrderInfo",method = RequestMethod.POST)
    public ResponseVO getOrderInfo(
            @RequestParam(name = "nowPage",required = false,defaultValue = "1")Integer nowPage,
            @RequestParam(name = "pageSize",required = false,defaultValue = "5")Integer pageSize){

        //获取当前登录人的信息


        //使用当前登录人，获取已经购买的订单

        return null;
    }
}
