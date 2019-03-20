package com.stylefeng.guns.api.alipay.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hxk
 * 2019/3/19 17:39
 */

@Data
public class AliPayResultVO implements Serializable{

    private String orderId;
    private Integer orderStatus;
    private String orderMsg;
}
