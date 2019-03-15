package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hxk
 * 2019/3/14 16:26
 */

@Data
public class CinemaVO implements Serializable{

    private String uuid;
    private String cinemaName;
    private String address;
    private String minimumPrice;
}
