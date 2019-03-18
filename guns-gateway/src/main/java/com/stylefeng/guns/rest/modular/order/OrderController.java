package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.order.vo.OrderVO;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxk
 * 2019/3/16 17:50
 */


@Slf4j
@RestController
@RequestMapping(value = "/order/")
public class OrderController {

    @Reference(interfaceClass = OrderServiceAPI.class,check = false)
    private OrderServiceAPI orderServiceAPI;

    /**
     *   //开始购票
     * @param fieldId  当前场次
     * @param soldSeats  已售出的作为
     * @param seatsName  座位
     * @return
     */
    @RequestMapping(value = "buyTickets",method = RequestMethod.POST)
    public ResponseVO buyTickets(Integer fieldId,String soldSeats,String seatsName){

        try {
            //验证售出的票是否为真
            boolean isTrue = orderServiceAPI.isTrueSeats(fieldId+"",soldSeats);

            //已经售出的座位中，有没有这些座位
            boolean isNotSold = orderServiceAPI.isNotSoldSeats(fieldId+"",soldSeats);

            //验证上述两个内容有一个不为真，则不创建订单
            if (isTrue && isNotSold){
                //创建订单信息，注意获取登录人
                String userId = CurrentUser.getCurrentUser();
                if (userId == null || userId.trim().length() == 0){
                    return ResponseVO.serviceFail("用户未登录");
                }
                OrderVO orderVO = orderServiceAPI.saveOrderInfo(fieldId,soldSeats,seatsName,Integer.parseInt(userId));
                if (orderVO == null){
                    log.error("购票业务异常");
                    return ResponseVO.serviceFail("购票业务异常");
                }else {
                    return ResponseVO.success(orderVO);
                }
            }else {
                return ResponseVO.serviceFail("业务异常,座位编号出错");
            }
        }catch (Exception e){
            log.error("购票业务异常",e);
            return ResponseVO.serviceFail("购票业务异常");
        }
    }


    /**
     *   获取订单信息
     * @param nowPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getOrderInfo",method = RequestMethod.POST)
    public ResponseVO getOrderInfo(
            @RequestParam(name = "nowPage",required = false,defaultValue = "1")Integer nowPage,
            @RequestParam(name = "pageSize",required = false,defaultValue = "5")Integer pageSize){

        //获取当前登录人的信息
        String userId = CurrentUser.getCurrentUser();

        //使用当前登录人，获取已经购买的订单
        Page<OrderVO> page = new Page<>(nowPage,pageSize);
        if (userId != null && userId.trim().length()>0){
            Page<OrderVO> result = orderServiceAPI.getOrderByUserId(Integer.parseInt(userId), page);

            return ResponseVO.success(nowPage,(int) result.getPages(),"",result.getRecords());
        }else {
            return ResponseVO.serviceFail("用户未登录");
        }
    }
}
