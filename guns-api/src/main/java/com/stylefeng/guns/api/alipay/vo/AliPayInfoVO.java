package com.stylefeng.guns.api.alipay.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hxk
 * 2019/3/19 17:38
 */

@Data
public class AliPayInfoVO implements Serializable {

    private String orderId;
    private String QRCodeAddress;
}
