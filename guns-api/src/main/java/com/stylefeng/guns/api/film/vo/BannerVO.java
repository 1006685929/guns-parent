package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hxk
 * 2019/3/4 17:42
 */

@Data
public class BannerVO implements Serializable{

    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;

    //getter  setter  toString
    
}
