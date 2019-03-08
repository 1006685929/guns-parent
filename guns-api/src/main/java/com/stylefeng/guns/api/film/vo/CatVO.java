package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hxk
 * 2019/3/8 15:55
 */

@Data
public class CatVO implements Serializable {

    private String catId;
    private String catName;
    private boolean isActive;
}
